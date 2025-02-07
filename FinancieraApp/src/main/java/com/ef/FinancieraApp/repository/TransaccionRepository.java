package com.ef.FinancieraApp.repository;

import com.ef.FinancieraApp.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
