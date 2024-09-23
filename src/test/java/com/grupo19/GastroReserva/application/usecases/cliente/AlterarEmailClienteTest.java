package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlterarEmailClienteTest {
    @Test
    public void deveAlterarEmailCliente() {

        AlterarEmailCliente alterarEmailCliente = new AlterarEmailCliente();
        Cliente cliente = new Cliente("12345678900", "Cliente", "clienteA@email.com");
        cliente.setEmail("clienteB@email.com");

        Cliente result = alterarEmailCliente.alterarEmailCliente(cliente);

        assertNotNull(result);
        assertEquals("clienteB@email.com", result.getEmail());
    }

}
