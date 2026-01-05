package com.pineda.api.mic_cuentas.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Marco Pineda
 * @date 1/2/2026
 */

@Getter
@Setter
public class ClientePersonaDTO
{
    private Long id;
    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    private Long cliente_id;
    private String contrasena;
    private boolean estado;
}
