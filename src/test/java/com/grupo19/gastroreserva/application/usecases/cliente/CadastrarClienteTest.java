package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CadastrarClienteTest {
    @Test
    void deveCadastrarCliente() {
        CadastrarCliente cadastrarCliente = new CadastrarCliente();
        Cliente validClient = new Cliente("12345678900", "Cliente", "cliente@email.com");


        Cliente result = cadastrarCliente.cadastrarCliente(validClient);


        Assertions.assertNotNull(result);
        Assertions.assertEquals("12345678900", result.getCpf());
        Assertions.assertEquals("Cliente", result.getNome());
        Assertions.assertEquals("cliente@email.com", result.getEmail());
    }
}
