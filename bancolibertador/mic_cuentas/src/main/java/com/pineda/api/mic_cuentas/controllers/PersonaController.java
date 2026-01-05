package com.pineda.api.mic_cuentas.controllers;

import com.pineda.api.mic_cuentas.entities.Persona;
import com.pineda.api.mic_cuentas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Marco
 * @date 1/2/2026
 */

@RestController
@RequestMapping("/personas")
public class PersonaController
{
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id) {
        return personaService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.findById(id)
                .map(existingPersona -> {
                    persona.setId(existingPersona.getId());
                    return ResponseEntity.ok(personaService.save(persona));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return personaService.findById(id)
                .map(persona -> {
                    personaService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
