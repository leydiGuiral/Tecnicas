package co.edu.usbcali.HollowBank.service.impl;

import co.edu.usbcali.HollowBank.domain.Prestamo;
import co.edu.usbcali.HollowBank.dto.PrestamoDTO;
import co.edu.usbcali.HollowBank.mapper.PrestamoMapper;
import co.edu.usbcali.HollowBank.repository.PrestamoRepository;
import co.edu.usbcali.HollowBank.service.PrestamoService;
import org.springframework.stereotype.Service;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public PrestamoDTO guardarNuevoPrestamo(PrestamoDTO prestamoDTO) throws Exception {
        // 1. Validar datos del préstamo
        if (prestamoDTO == null) {
            throw new Exception("El préstamo es nulo");
        }
        if (prestamoDTO.getServicio() == null || prestamoDTO.getServicio().trim().equals("")) {
            throw new Exception("Nombre vacío");
        }
        if (prestamoDTO.getMonto() == null || prestamoDTO.getMonto().trim().equals("")) {
            throw new Exception("Apellido vacío");
        }
        if (prestamoDTO.getFecha() == null || prestamoDTO.getFecha().trim().equals("")) {
            throw new Exception("Salario vacío");
        }


        // Registrar el préstamo en la BD mapeando desde DTO hacia DOMINIO
        Prestamo prestamo = PrestamoMapper.dtoToDomain(prestamoDTO);
        prestamo = prestamoRepository.save(prestamo);

        // Retornar el préstamo mapeado a DTO
        prestamoDTO = PrestamoMapper.domainToDto(prestamo);

        return prestamoDTO;
    }
}

