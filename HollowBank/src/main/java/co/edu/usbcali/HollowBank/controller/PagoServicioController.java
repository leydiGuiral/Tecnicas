package co.edu.usbcali.HollowBank.controller;

public class PagoServicioController {

    private final PagoServicioRepository pagoServicioRepository;
    private final PagoServicioService pagoServicioService;

    public PagoServicioController(PagoServicioRepository pagoServicioRepository, PagoServicioService pagoServicioService) {
        this.pagoServicioRepository = pagoServicioRepository;
        this.pagoServicioService = pagoServicioService;
    }

    @GetMapping("/obtenerTodas")
    public List<PagoServicio> obtenerTodos() {
        List<PagoServicio> pagosServicio = pagoServicioRepository.findAll();
        return pagosServicio;
    }

    @PostMapping("/guardar")
    public ResponseEntity<PagoServicioDTO> guardarPagoServicio(@RequestBody PagoServicioDTO pagoServicioDTO) throws Exception {
        PagoServicioDTO pagoServicioDTO1 = pagoServicioService.guardarNuevoPagoServicio(pagoServicioDTO);

        return new ResponseEntity<>(pagoServicioDTO1, HttpStatus.OK);
    }
}

