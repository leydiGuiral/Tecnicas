package co.edu.usbcali.HollowBank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdministradorDTO {
    private Integer id;

    private String nombre;

    private String apellido;

    private BigDecimal salario;

    private String telefono;

}

