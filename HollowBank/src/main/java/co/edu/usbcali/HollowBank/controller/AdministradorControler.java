package co.edu.usbcali.HollowBank.controller;
import co.edu.usbcali.HollowBank.domain.Administrador;
import co.edu.usbcali.HollowBank.dto.AdministradorDTO;
import co.edu.usbcali.HollowBank.repository.AdministradorRepository;
import co.edu.usbcali.HollowBank.service.AdministradorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/administrador")


public class AdministradorControler {

    private final AdministradorRepository administradorRepository;
    private final AdministradorService administradorService;
    public AdministradorControler(AdministradorRepository administradorRepository, AdministradorService administradorService) {
        this.administradorRepository = administradorRepository;
        this.administradorService = administradorService;
    }
    @getMapping("/obtenerTodas")
    public List<Administrador> obtenerTodos() {
        List<Administrador> administrador = administradorRepository.findAll();
        return administradores;
    }
    @PostMapping("/guardar")
    public ResponseEntity<AdministradorDTO> guardarAdministrador(@RequestBody AdministradorDTO administradorDTO) throws Exception{
     AdministradorDTO administradorDTO1 =administradorService.guardarNuevoAdministrador(administradorDTO);

     return new ResponseEntity<>(administradorDTO1, httpStatus.OK);

   }
}