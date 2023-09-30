package com.springboot.Clientes.entities;
import lombok.*;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "clientes")
public class Cliente {
    /* *@Id: Se usa para marcar un campo como clave primaria de la entidad */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(name = "nombre_cliente")
    private String nombre_cliente;

    @Column(name = "apellido_cliente")
    private String apellido_cliente;

    @Column(name = "correo_cliente")
    private String correo_cliente;

    @Column(name = "fecha_registro")
    private Date fecha_registro;

}
