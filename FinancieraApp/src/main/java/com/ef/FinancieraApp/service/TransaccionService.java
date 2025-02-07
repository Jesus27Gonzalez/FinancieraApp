package com.ef.FinancieraApp.service;

import com.ef.FinancieraApp.entity.Transaccion;
import com.ef.FinancieraApp.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class TransaccionService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    public Transaccion crearTransaccion(Transaccion transaccion) {
        // Validar que el monto sea positivo
        if (transaccion.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto de la transacción debe ser positivo.");
        }

        // Asignar fecha automáticamente
        transaccion.setFecha(LocalDate.now());

        return transaccionRepository.save(transaccion);
    }

    public Transaccion realizarConsignacion(Transaccion transaccion) {
        return transaccion;
    }

    public Transaccion realizarRetiro(Transaccion transaccion) {
        return transaccion;
    }

    public Transaccion realizarTransferencia(Transaccion transaccion) {
        return transaccion;
    }

    // Implementar otros métodos (consignación, retiro, transferencia, etc.)
}