package com.pineda.api.mic_movimientos.services;

import com.pineda.api.mic_movimientos.entities.Movimiento;
import com.pineda.api.mic_movimientos.repositories.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Marco
 * @date 1/3/2026
 */

@Service
public class MovimientoService
{
    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> findById(Long id) {
        return movimientoRepository.findById(id);
    }

    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public void deleteById(Long id) {
        movimientoRepository.deleteById(id);
    }

    public List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, Date startDate, Date endDate) {
        return movimientoRepository.findByCuentaIdAndFechaBetween(cuentaId, startDate, endDate);
    }
}
