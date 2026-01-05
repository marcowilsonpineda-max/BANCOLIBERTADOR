package com.pineda.api.mic_movimientos.services;

import com.pineda.api.mic_movimientos.entities.Cuenta;
import com.pineda.api.mic_movimientos.errors.ErrorMessages;
import com.pineda.api.mic_movimientos.exception.InvalidCuentaException;
import com.pineda.api.mic_movimientos.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author Marco
 * @date 1/3/2026
 */
@Service
public class CuentaService
{
    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id);
    }

    public Cuenta save(Cuenta cuenta) {
        if (ObjectUtils.isEmpty(cuenta.getCliente_id())) {
            throw new InvalidCuentaException(ErrorMessages.CLIENTE_ID_NULL);
        }
        return cuentaRepository.save(cuenta);
    }

    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }
}
