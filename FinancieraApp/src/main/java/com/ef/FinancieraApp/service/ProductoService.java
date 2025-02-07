package com.ef.FinancieraApp.service;

import com.ef.FinancieraApp.entity.Producto;
import com.ef.FinancieraApp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        // Validar que el saldo no sea negativo para cuentas de ahorro
        if (producto.getTipoCuenta().equals("ahorros") && producto.getSaldo() < 0) {
            throw new IllegalArgumentException("El saldo de una cuenta de ahorros no puede ser negativo.");
        }

        // Validar que el número de cuenta sea único
        if (productoRepository.existsByNumeroCuenta(producto.getNumeroCuenta())) {
            throw new IllegalArgumentException("El número de cuenta ya existe.");
        }

        // Asignar fechas automáticamente
        producto.setFechaCreacion(LocalDate.now());
        producto.setFechaModificacion(LocalDate.now());

        return productoRepository.save(producto);
    }

    public Producto activarProducto(Long id) {
        return null;
    }

    public Producto inactivarProducto(Long id) {
        return null;
    }

    public Producto cancelarProducto(Long id) {
        return null;
    }

    // Implementar otros métodos (activar, inactivar, cancelar, etc.)
}