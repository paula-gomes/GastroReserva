package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

 class AlterarEmailClienteTest {
    @Test
    void deveAlterarEmailCliente() {

        AlterarEmailCliente alterarEmailCliente = new AlterarEmailCliente();
        Cliente cliente = new Cliente("12345678900", "Cliente", "clienteA@email.com");
        cliente.setEmail("clienteB@email.com");

        Cliente result = alterarEmailCliente.alterarEmailCliente(cliente);

        assertNotNull(result);
        assertEquals("clienteB@email.com", result.getEmail());
    }

}
