package com.ef.FinancieraApp;

import com.ef.FinancieraApp.entity.Producto;
import com.ef.FinancieraApp.repository.ProductoRepository;
import com.ef.FinancieraApp.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductoServiceTest {
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    public void testCrearCliente() {
        Producto producto = new Producto();
        producto.setNombres("Juan");
        producto.setApellido("Pérez");
        producto.setCorreoElectronico("juan@example.com");
        producto.setFechaNacimiento(LocalDate.of(1990, 1, 1));

        when(productoRepository.save(any(Producto.class))).thenReturn(producto);

        Producto resultado = productoService.crearProducto(producto);
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombres());
    }
}
