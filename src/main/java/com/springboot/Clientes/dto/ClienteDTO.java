package com.springboot.Clientes.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {
    private Long id_cliente;

    private String nombre_cliente;

    private String apellido_cliente;

    private String correo_cliente;

    private Date fecha_registro;
}
