package com.ef.FinancieraApp.controller;

import com.ef.FinancieraApp.entity.Transaccion;
import com.ef.FinancieraApp.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    @Autowired
    private TransaccionService transaccionService;

    @PostMapping("/consignacion")
    public Transaccion realizarConsignacion(@RequestBody Transaccion transaccion) {
        return transaccionService.realizarConsignacion(transaccion);
    }

    @PostMapping("/retiro")
    public Transaccion realizarRetiro(@RequestBody Transaccion transaccion) {
        return transaccionService.realizarRetiro(transaccion);
    }

    @PostMapping("/transferencia")
    public Transaccion realizarTransferencia(@RequestBody Transaccion transaccion) {
        return transaccionService.realizarTransferencia(transaccion);
    }
}