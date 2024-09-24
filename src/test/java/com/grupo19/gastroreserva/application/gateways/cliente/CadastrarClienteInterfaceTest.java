package com.grupo19.gastroreserva.application.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CadastrarClienteInterfaceTest {
    @Mock
    private CadastrarClienteInterface cadastrarClienteInterface;

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
    void deveCadastrarClienteComSucesso() {
        Cliente cliente = new Cliente();
        cliente.setNome("ClienteNome");
        cliente.setEmail("cliente@teste.com");

        when(cadastrarClienteInterface.cadastrarCliente(cliente)).thenReturn(cliente);

        Cliente clienteCadastrado = cadastrarClienteInterface.cadastrarCliente(cliente);

        assertEquals("ClienteNome", clienteCadastrado.getNome());
        assertEquals("cliente@teste.com", clienteCadastrado.getEmail());
    }
}
