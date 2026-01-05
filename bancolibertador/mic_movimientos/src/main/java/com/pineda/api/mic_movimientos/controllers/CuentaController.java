package com.pineda.api.mic_movimientos.controllers;

import com.pineda.api.mic_movimientos.entities.Cuenta;
import com.pineda.api.mic_movimientos.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marco
 * @date 1/3/2026
 */
@RestController
@RequestMapping("/cuentas")
public class CuentaController
{
    @Autowired
    private CuentaService cuentaService;

    @GetMapping
    public List<Cuenta> findAll() {
        return cuentaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> findById(@PathVariable Long id) {
        return cuentaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuenta save(@RequestBody Cuenta cuenta) {
        return cuentaService.save(cuenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> update(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        return cuentaService.findById(id)
                .map(existingCuenta -> {
                    cuenta.setId(existingCuenta.getId());
                    return ResponseEntity.ok(cuentaService.save(cuenta));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return cuentaService.findById(id)
                .map(cuenta -> {
                    cuentaService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
