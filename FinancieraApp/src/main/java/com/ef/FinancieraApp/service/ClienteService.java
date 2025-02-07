package com.ef.FinancieraApp.service;

import com.ef.FinancieraApp.entity.Cliente;
import com.ef.FinancieraApp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        // Validar que el cliente sea mayor de edad
        if (!esMayorDeEdad(cliente.getFechaNacimiento())) {
            throw new IllegalArgumentException("El cliente debe ser mayor de edad.");
        }

        // Validar formato del correo electrónico
        if (!esCorreoValido(cliente.getCorreoElectronico())) {
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido.");
        }

        // Validar longitud de nombres y apellidos
        if (cliente.getNombres().length() < 2 || cliente.getApellido().length() < 2) {
            throw new IllegalArgumentException("El nombre y el apellido deben tener al menos 2 caracteres.");
        }

        // Asignar fechas automáticamente
        cliente.setFechaCreacion(LocalDate.now());
        cliente.setFechaModificacion(LocalDate.now());

        return clienteRepository.save(cliente);
    }

    private boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    private boolean esCorreoValido(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(regex).matcher(correo).matches();
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return cliente;
    }

    public void eliminarCliente(Long id) {
    }

    // Implementar otros métodos (actualizar, eliminar, etc.)
}