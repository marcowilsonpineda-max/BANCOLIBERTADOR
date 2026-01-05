package com.pineda.api.mic_cuentas.services;

import com.pineda.api.mic_cuentas.dtos.ClientePersonaDTO;
import com.pineda.api.mic_cuentas.entities.Cliente;
import com.pineda.api.mic_cuentas.entities.Persona;
import com.pineda.api.mic_cuentas.repositories.ClienteRepository;
import com.pineda.api.mic_cuentas.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Marco
 * @date 1/2/2026
 */
@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;/** Gestion servidor **/

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Cliente save(ClientePersonaDTO clientePersonaDTO) {
        Persona persona = new Persona();
        persona.setNombre(clientePersonaDTO.getNombre());
        persona.setGenero(clientePersonaDTO.getGenero());
        persona.setEdad(clientePersonaDTO.getEdad());
        persona.setIdentificacion(clientePersonaDTO.getIdentificacion());
        persona.setDireccion(clientePersonaDTO.getDireccion());
        persona.setTelefono(clientePersonaDTO.getTelefono());

        Persona savedPersona = personaRepository.save(persona);

        Cliente cliente = new Cliente();
        cliente.setCliente_id(clientePersonaDTO.getCliente_id());
        cliente.setContrasena(clientePersonaDTO.getContrasena());
        cliente.setEstado(clientePersonaDTO.isEstado());
        cliente.setPersona(savedPersona);

        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
