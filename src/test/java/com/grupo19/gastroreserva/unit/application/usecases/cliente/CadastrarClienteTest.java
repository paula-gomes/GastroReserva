package com.grupo19.gastroreserva.unit.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.gastroreserva.application.usecases.cliente.CadastrarCliente;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CadastrarClienteTest {
    @Mock
    private CadastrarClienteInterface cadastrarClienteInterface;

    @InjectMocks
    private CadastrarCliente cadastrarCliente;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setNome("João Silva");
        cliente.setEmail("joao.silva@example.com");
    }

    @Test
    void deveCadastrarCliente() {
        when(cadastrarClienteInterface.cadastrarCliente(cliente)).thenReturn(cliente);

        Cliente clienteCadastrado = cadastrarCliente.cadastrarCliente(cliente);

        assertEquals(cliente.getNome(), clienteCadastrado.getNome());
        assertEquals(cliente.getEmail(), clienteCadastrado.getEmail());
    }
}
