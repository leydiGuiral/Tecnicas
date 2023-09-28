package co.edu.usbcali.HollowBank.service.impl;

import co.edu.usbcali.HollowBank.domain.Administrador;
import co.edu.usbcali.HollowBank.dto.AdministradorDTO;
import co.edu.usbcali.HollowBank.mapper.AdministradorMapper;
import co.edu.usbcali.HollowBank.repository.AdministradorRepository;
import co.edu.usbcali.HollowBank.service.AdministradorService;
import org.springframework.stereotype.Service;



@Service
public class AdministradorServiceImpl implements AdministradorService {


    private final AdministradorRepository administradorRepository;

    public AdministradorServiceImpl(AdministradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Override
    public TransaccionDTO guardarNuevaTransaccion(TransaccionDTO transaccionDTO) throws Exception {
        // 1. Validar datos de la transacción
        if (transaccionDTO == null) {
            throw new Exception("La transacción es nula");
        }
        if (transaccionDTO.getNombre() == null || transaccionDTO.getNombre().trim().equals("")) {
            throw new Exception("Nombre vacío");
        }
        if (transaccionDTO.getApellido() == null || transaccionDTO.getApellido().trim().equals("")) {
            throw new Exception("Apellido vacío");
        }
        if (transaccionDTO.getSalario() == null || transaccionDTO.getSalario().trim().equals("")) {
            throw new Exception("Salario vacío");
        }
        if (transaccionDTO.getTelefono() == null || transaccionDTO.getTelefono().trim().equals("")) {
            throw new Exception("Teléfono vacío");
        }


        // Registrar la transacción en la BD mapeando desde DTO hacia DOMINIO
        Transaccion transaccion = TransaccionMapper.dtoToDomain(transaccionDTO);
        transaccion = transaccionRepository.save(transaccion);

        // Retornar la transacción mapeada a DTO
        transaccionDTO = TransaccionMapper.domainToDto(transaccion);

        return transaccionDTO;
    }
}

