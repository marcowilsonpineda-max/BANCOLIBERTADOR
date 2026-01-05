package com.pineda.api.mic_movimientos.controllers;

import com.pineda.api.mic_movimientos.entities.Movimiento;
import com.pineda.api.mic_movimientos.services.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Marco Pineda
 * @date 1/3/2026
 */

@RestController
@RequestMapping("/movimientos")
public class MovimientoController
{
    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> findAll() {
        return movimientoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> findById(@PathVariable Long id) {
        return movimientoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movimiento save(@RequestBody Movimiento movimiento) {
        return movimientoService.save(movimiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> update(@PathVariable Long id, @RequestBody Movimiento movimiento) {
        return movimientoService.findById(id)
                .map(existingMovimiento -> {
                    movimiento.setId(existingMovimiento.getId());
                    return ResponseEntity.ok(movimientoService.save(movimiento));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return movimientoService.findById(id)
                .map(movimiento -> {
                    movimientoService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/reportes")
    public List<Movimiento> findByCuentaIdAndFechaBetween(
            @RequestParam Long cuentaId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return movimientoService.findByCuentaIdAndFechaBetween(cuentaId, startDate, endDate);
    }
}
