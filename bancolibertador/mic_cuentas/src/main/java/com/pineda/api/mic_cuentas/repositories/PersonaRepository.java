package com.pineda.api.mic_cuentas.repositories;

import com.pineda.api.mic_cuentas.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marco Pineda
 * @date 1/2/2026
 */

public interface PersonaRepository extends JpaRepository<Persona, Long>
{
}
