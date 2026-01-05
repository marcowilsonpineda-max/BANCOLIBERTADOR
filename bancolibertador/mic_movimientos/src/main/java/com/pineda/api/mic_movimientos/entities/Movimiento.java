package com.pineda.api.mic_movimientos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Marco
 * @date 1/3/2026
 */

@Entity
@Getter
@Setter
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String tipo_movimiento;
    private double valor;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta cuenta;

}