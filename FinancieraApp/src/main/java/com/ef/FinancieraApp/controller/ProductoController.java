package com.ef.FinancieraApp.controller;

import com.ef.FinancieraApp.entity.Producto;
import com.ef.FinancieraApp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.crearProducto(producto);
    }

    @PutMapping("/{id}/activar")
    public Producto activarProducto(@PathVariable Long id) {
        return productoService.activarProducto(id);
    }

    @PutMapping("/{id}/inactivar")
    public Producto inactivarProducto(@PathVariable Long id) {
        return productoService.inactivarProducto(id);
    }

    @PutMapping("/{id}/cancelar")
    public Producto cancelarProducto(@PathVariable Long id) {
        return productoService.cancelarProducto(id);
    }
}