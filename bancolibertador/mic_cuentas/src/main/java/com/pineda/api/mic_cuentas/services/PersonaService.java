package com.pineda.api.mic_cuentas.services;

import com.pineda.api.mic_cuentas.entities.Persona;
import com.pineda.api.mic_cuentas.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Marco Pineda
 * @date 1/2/2026
 * banco libertador
 */

@Service
public class PersonaService
{
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
}
