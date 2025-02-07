package com.ef.FinancieraApp;

import com.ef.FinancieraApp.entity.Cliente;
import com.ef.FinancieraApp.repository.ClienteRepository;
import com.ef.FinancieraApp.service.ClienteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTest {
    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @Test
    public void testCrearCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombres("Juan");
        cliente.setApellido("Pérez");
        cliente.setCorreoElectronico("juan@example.com");
        cliente.setFechaNacimiento(LocalDate.of(1990, 1, 1));

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente resultado = clienteService.crearCliente(cliente);
        assertNotNull(resultado);
        assertEquals("Juan", resultado.getNombres());
    }
}