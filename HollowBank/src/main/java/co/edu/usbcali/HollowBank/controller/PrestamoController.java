package co.edu.usbcali.HollowBank.controller;

public class PrestamoController {

    private final PrestamoRepository prestamoRepository;
    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoRepository prestamoRepository, PrestamoService prestamoService) {
        this.prestamoRepository = prestamoRepository;
        this.prestamoService = prestamoService;
    }

    @GetMapping("/obtenerTodas")
    public List<Prestamo> obtenerTodos() {
        List<Prestamo> prestamos = prestamoRepository.findAll();
        return prestamos;
    }

    @PostMapping("/guardar")
    public ResponseEntity<PrestamoDTO> guardarPrestamo(@RequestBody PrestamoDTO prestamoDTO) throws Exception {
        PrestamoDTO prestamoDTO1 = prestamoService.guardarNuevoPrestamo(prestamoDTO);

        return new ResponseEntity<>(prestamoDTO1, HttpStatus.OK);
    }
}

