package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ExcluirClienteTest {
    @Test
    public void deveExcluirCliente() {

        ExcluirClienteInterface excluirClienteInterface = mock(ExcluirClienteInterface.class);


        ExcluirCliente excluirCliente = new ExcluirCliente();

        Cliente cliente = new Cliente("12345678900", "Cliente", "cliente@email.com");

        excluirClienteInterface.excluirCliente(cliente);

        verify(excluirClienteInterface, times(1)).excluirCliente(cliente);
    }
}
