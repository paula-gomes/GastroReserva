package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CadastrarClienteTest {
    @Test
    public void deveCadastrarCliente() {
        CadastrarClienteInterface mockInterface = Mockito.mock(CadastrarClienteInterface.class);
        Cliente validClient = new Cliente("12345678900", "Cliente", "cliente@email.com");
        Mockito.when(mockInterface.cadastrarCliente(validClient)).thenReturn(validClient);

        CadastrarCliente cadastrarCliente = new CadastrarCliente(mockInterface);
        Cliente result = cadastrarCliente.cadastrarCliente(validClient);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("12345678900", result.getCpf());
        Assertions.assertEquals("Cliente", result.getNome());
        Assertions.assertEquals("cliente@email.com", result.getEmail());
    }
}
