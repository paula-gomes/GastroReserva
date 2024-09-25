package com.grupo19.gastroreserva.application.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AlterarEmailClienteInterfaceTest {
    @Mock
    private AlterarEmailClienteInterface alterarEmailClienteInterface;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deveAlterarEmailCliente() {
        Cliente cliente = new Cliente();
        cliente.setEmail("cliente@teste.com");

        when(alterarEmailClienteInterface.alterarEmailCliente(cliente)).thenReturn(cliente);

        Cliente clienteAlterado = alterarEmailClienteInterface.alterarEmailCliente(cliente);

        verify(alterarEmailClienteInterface, times(1)).alterarEmailCliente(cliente);

        assertEquals(cliente, clienteAlterado);
        assertEquals("cliente@teste.com", clienteAlterado.getEmail());
    }
}
