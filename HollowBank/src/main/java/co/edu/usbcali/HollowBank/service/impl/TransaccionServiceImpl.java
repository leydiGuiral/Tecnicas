import co.edu.usbcali.HollowBank.domain.Transaccion;
import co.edu.usbcali.HollowBank.dto.TransaccionDTO;
import co.edu.usbcali.HollowBank.mapper.TransaccionMapper;
import co.edu.usbcali.HollowBank.repository.TransaccionRepository;
import co.edu.usbcali.HollowBank.service.TransaccionService;
import org.springframework.stereotype.Service;


@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public TransaccionServiceImpl(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    @Override
    public TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception {
        // 1. Validar datos de la transacción
        if (transaccionDTO == null) {
            throw new Exception("La transacción es nula");
        }
        if (transaccionDTO.getMonto() == null || transaccionDTO.getMonto().trim().equals("")) {
            throw new Exception("monto vacío");
        }
        if (transaccionDTO.getFecha() == null || transaccionDTO.getFecha().trim().equals("")) {
            throw new Exception("Fecha vacia");
        }
        if (transaccionDTO.getTipo() == null || transaccionDTO.getTipo().trim().equals("")) {
            throw new Exception("Tipo vacío");
        }
        if (transaccionDTO.getEstado() == null || transaccionDTO.getEstado().trim().equals("")) {
            throw new Exception("Estado vacío");

        // Registrar la transacción en la BD mapeando desde DTO hacia DOMINIO
        Transaccion transaccion = TransaccionMapper.dtoToDomain(transaccionDTO);
        transaccion = transaccionRepository.save(transaccion);

        // Retornar la transacción mapeada a DTO
        transaccionDTO = TransaccionMapper.domainToDto(transaccion);

        return transaccionDTO;
    }
}
