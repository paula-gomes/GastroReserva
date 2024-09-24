package com.grupo19.gastroreserva.application.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ListarClienteInterfaceTest {
    @Mock
    private ListarClientesInterface listarClientesInterface;

    private AutoCloseable openMocks;

    @BeforeEach
    void configurar() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void derrubar() throws Exception {
        if (openMocks != null) {
            openMocks.close();
        }
    }

    @Test
    void deveListarClientesComSucesso() {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente();
        cliente1.setNome("ClienteNome1");
        cliente1.setEmail("cliente1@email.com");
        clientes.add(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setNome("ClienteNome2");
        cliente2.setEmail("cliente2@email.com");
        clientes.add(cliente2);

        when(listarClientesInterface.listarClientes()).thenReturn(clientes);

        List<Cliente> clientesListados = listarClientesInterface.listarClientes();

        assertEquals(2, clientesListados.size());
        assertEquals("ClienteNome1", clientesListados.get(0).getNome());
        assertEquals("ClienteNome2", clientesListados.get(1).getNome());
    }
}
