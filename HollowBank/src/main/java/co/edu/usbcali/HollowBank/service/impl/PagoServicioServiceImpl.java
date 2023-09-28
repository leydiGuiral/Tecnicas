package co.edu.usbcali.HollowBank.service.impl;

import co.edu.usbcali.HollowBank.domain.PagoServicio;
import co.edu.usbcali.HollowBank.dto.PagoServicioDTO;
import co.edu.usbcali.HollowBank.mapper.PagoServicioMapper;
import co.edu.usbcali.HollowBank.repository.PagoServicioRepository;
import co.edu.usbcali.HollowBank.service.PagoServicioService;
import org.springframework.stereotype.Service;

@Service
public class PagoServicioServiceImpl implements PagoServicioService {

    private final PagoServicioRepository pagoServicioRepository;

    public PagoServicioServiceImpl(PagoServicioRepository pagoServicioRepository) {
        this.pagoServicioRepository = pagoServicioRepository;
    }

    @Override
    public PagoServicioDTO guardarNuevoPagoServicio(PagoServicioDTO pagoServicioDTO) throws Exception {

        // 1. Validar datos del pago de servicio
        if (pagoServicioDTO == null) {
            throw new Exception("El pago de servicio es nulo");
        }
        if (pagoServicioDTO.getServicio() == null || pagoServicioDTO.getServicio().trim().equals("")) {
            throw new Exception("Servicio vacío");
        }
        if (pagoServicioDTO.getMonto() == null || pagoServicioDTO.getMonto().trim().equals("")) {
            throw new Exception("monto vacío");
        }
        if (pagoServicioDTO.getFecha() == null || pagoServicioDTO.getFecha().trim().equals("")) {
            throw new Exception("fecha vacía");
        }


        // Registrar el pago de servicio en la BD mapeando desde DTO hacia DOMINIO
        PagoServicio pagoServicio = PagoServicioMapper.dtoToDomain(pagoServicioDTO);
        pagoServicio = pagoServicioRepository.save(pagoServicio);

        // Retornar el pago de servicio mapeado a DTO
        pagoServicioDTO = PagoServicioMapper.domainToDto(pagoServicio);

        return pagoServicioDTO;
    }
}
