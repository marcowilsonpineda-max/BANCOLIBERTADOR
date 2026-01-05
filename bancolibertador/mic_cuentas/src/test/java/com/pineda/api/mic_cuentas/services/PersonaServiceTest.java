package com.pineda.api.mic_cuentas.services;

import com.pineda.api.mic_cuentas.entities.Persona;
import com.pineda.api.mic_cuentas.repositories.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Marco
 * @date 1/4/2026
 */

public class PersonaServiceTest
{
    @Mock
    private PersonaRepository personaRepository;

    @InjectMocks
    private PersonaService personaService;

    public PersonaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testSaveCliente() {
        Persona persona = new Persona();
        persona.setNombre("Jose Lema");
        when(personaRepository.save(persona)).thenReturn(persona);
        Persona savedPersona = personaService.save(persona);
        assertEquals(persona.getNombre(), savedPersona.getNombre());
    }
}
