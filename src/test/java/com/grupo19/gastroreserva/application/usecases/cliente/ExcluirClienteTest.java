package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExcluirClienteTest {
    @Test
    void deveExcluirCliente() {

        ExcluirClienteInterface excluirClienteInterface = mock(ExcluirClienteInterface.class);

        Cliente cliente = new Cliente("12345678900", "Cliente", "cliente@email.com");

        excluirClienteInterface.excluirCliente(cliente);

        verify(excluirClienteInterface, times(1)).excluirCliente(cliente);
    }
}
