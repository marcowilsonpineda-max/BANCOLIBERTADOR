package com.pineda.api.mic_movimientos.repositories;

import com.pineda.api.mic_movimientos.entities.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Marco
 * @date 1/3/2026
 */
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>
{
    List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, Date startDate, Date endDate);
}
