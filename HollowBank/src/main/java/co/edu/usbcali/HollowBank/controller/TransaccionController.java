package co.edu.usbcali.HollowBank.controller;


public class TransaccionController {

    private final TransaccionRepository transaccionRepository;
    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionRepository transaccionRepository, TransaccionService transaccionService) {
        this.transaccionRepository = transaccionRepository;
        this.transaccionService = transaccionService;
    }

    @GetMapping("/obtenerTodas")
    public List<Transaccion> obtenerTodos() {
        List<Transaccion> transaccion = transaccionRepository.findAll();
        return transacciones;
    }

    @PostMapping("/guardar")
    public ResponseEntity<TransaccionDTO> guardarTransaccion(@RequestBody TransaccionDTO transaccionDTO) throws Exception {
        TransaccionDTO transaccionDTO1 = transaccionService.guardarNuevaTransaccion(transaccionDTO);

        return new ResponseEntity<>(transaccionDTO1, httpStatus.OK);
    }
}