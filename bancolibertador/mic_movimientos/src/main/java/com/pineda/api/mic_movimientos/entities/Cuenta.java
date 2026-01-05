package com.pineda.api.mic_movimientos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Marco
 * @date 1/3/2026
 */

@Entity
@Getter
@Setter
public class Cuenta
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero_cuenta;
    private String tipo_cuenta;
    private double saldo_inicial;
    private boolean estado;
    private Long cliente_id;
}
