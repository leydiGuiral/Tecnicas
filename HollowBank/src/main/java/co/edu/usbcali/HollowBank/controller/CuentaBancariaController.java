package co.edu.usbcali.HollowBank.controller;


public class CuentaBancariaController {

    private final CuentaBancariaRepository cuentaBancariaRepository;
    private final CuentaBancariaService cuentaBancariaService;

    public CuentaBancariaController(CuentaBancariaRepository cuentaBancariaRepository, CuentaBancariaService cuentaBancariaService) {
        this.cuentaBancariaRepository = cuentaBancariaRepository;
        this.cuentaBancariaService = cuentaBancariaService;
    }

    @GetMapping("/obtenerTodas")
    public List<CuentaBancaria> obtenerTodos() {
        List<CuentaBancaria> cuentasBancarias = cuentaBancariaRepository.findAll();
        return cuentasBancarias;
    }

    @PostMapping("/guardar")
    public ResponseEntity<CuentaBancariaDTO> guardarCuentaBancaria(@RequestBody CuentaBancariaDTO cuentaBancariaDTO) throws Exception {
        CuentaBancariaDTO cuentaBancariaDTO1 = cuentaBancariaService.guardarNuevaCuentaBancaria(cuentaBancariaDTO);

        return new ResponseEntity<>(cuentaBancariaDTO1, HttpStatus.OK);
    }
}
