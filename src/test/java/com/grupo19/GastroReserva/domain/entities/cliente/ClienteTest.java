package com.grupo19.GastroReserva.domain.entities.cliente;

import org.junit.jupiter.api.Test;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;


public class ClienteTest {

    @Test
    public void deveCriarCliente() {
        Cliente cliente = new Cliente("12345678910", "nomeCliente", "email@teste.com");

        assertNotNull(cliente);
        assertEquals("12345678910", cliente.getCpf());
        assertEquals("nomeCliente", cliente.getNome());
        assertEquals("email@teste.com", cliente.getEmail());
    }

    @Test
    public void cpfNaoDeveSerNuloOuVazio() {
        String mensagemEsperada = "Campo Obrigatório está nulo ou vazio";

        Exception exceptionNulo = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(null, "nomeCliente", "email@teste.com");
        });
        assertTrue(exceptionNulo.getMessage().contains(mensagemEsperada));

        Exception exceptionVazio = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("", "nomeCliente", "email@teste.com");
        });
        assertTrue(exceptionVazio.getMessage().contains(mensagemEsperada));
    }

    @Test
    public void nomeNaoDeveSerNuloOuVazio() {
        String mensagemEsperada = "Campo Obrigatório está nulo ou vazio";

        Exception exceptionNulo = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("12345678910", null, "email@teste.com");
        });
        assertTrue(exceptionNulo.getMessage().contains(mensagemEsperada));

        Exception exceptionVazio = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("12345678910", "", "email@teste.com");
        });
        assertTrue(exceptionVazio.getMessage().contains(mensagemEsperada));
    }

    @Test
    public void emailNaoDeveSerNuloOuVazio() {
        String mensagemEsperada = "Campo Obrigatório está nulo ou vazio";

        Exception exceptionNulo = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("12345678910", "nomeCliente", null);
        });
        assertTrue(exceptionNulo.getMessage().contains(mensagemEsperada));

        Exception exceptionVazio = assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("12345678910", "nomeCliente", "");
        });
        assertTrue(exceptionVazio.getMessage().contains(mensagemEsperada));
    }
}


