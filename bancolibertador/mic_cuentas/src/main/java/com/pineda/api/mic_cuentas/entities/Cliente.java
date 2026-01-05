package com.pineda.api.mic_cuentas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marco
 * @date 1/2/2026
 */

@Entity
@Getter
@Setter
public class Cliente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private String contrasena;
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}
