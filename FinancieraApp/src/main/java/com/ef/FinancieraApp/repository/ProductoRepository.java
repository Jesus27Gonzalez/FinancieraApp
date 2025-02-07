package com.ef.FinancieraApp.repository;

import com.ef.FinancieraApp.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    boolean existsByNumeroCuenta(Object numeroCuenta);
}