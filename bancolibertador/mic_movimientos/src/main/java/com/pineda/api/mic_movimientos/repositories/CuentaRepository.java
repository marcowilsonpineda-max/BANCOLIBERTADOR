package com.pineda.api.mic_movimientos.repositories;

import com.pineda.api.mic_movimientos.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marco
 * @date 1/3/2026
 */
public interface CuentaRepository extends JpaRepository<Cuenta, Long>
{
}
