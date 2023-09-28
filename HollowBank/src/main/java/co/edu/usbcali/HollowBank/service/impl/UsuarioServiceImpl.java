package co.edu.usbcali.HollowBank.service.impl;

import co.edu.usbcali.HollowBank.domain.Usuario;
import co.edu.usbcali.HollowBank.dto.UsuarioDTO;
import co.edu.usbcali.HollowBank.repository.UsuarioRepository;
import co.edu.usbcali.HollowBank.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioDTO guardarNuevoUsuario(UsuarioDTO usuarioDTO) throws Exception {
        // Validar datos del usuario
        if (usuarioDTO == null) {
            throw new Exception("El usuario es nulo");
        }
        if (usuarioDTO.getNombre() == null || usuarioDTO.getNombre().trim().equals("")) {
            throw new Exception("NombreVacío");
        }
        if (usuarioDTO.getApellido() == null || usuarioDTO.getApellido().trim().equals("")) {
            throw new Exception("ApellidoVacío");
        }
        if (usuarioDTO.getDireccion() == null || usuarioDTO.getDireccion().trim().equals("")) {
            throw new Exception("DireccionVacío");
        }
        if (usuarioDTO.getTelefono() == null || usuarioDTO.getTelefono().trim().equals("")) {
            throw new Exception("Teléfonovacío");
        }

        // Registrar usuario en BD mapeando desde DTO hacia DOMINIO
        Usuario usuario = UsuarioMapper.dtoToDomain(usuarioDTO);
        usuario = usuarioRepository.save(usuario);

        // Retornar el usuario mapeado a DTO
        usuarioDTO = UsuarioMapper.domainToDto(usuario);

        return usuarioDTO;
    }
}
