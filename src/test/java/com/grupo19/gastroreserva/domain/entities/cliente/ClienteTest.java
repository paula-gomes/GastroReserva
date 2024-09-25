package com.grupo19.gastroreserva.domain.entities.cliente;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    public void deveRetornarListaDeRestaurante() {
        Cliente cliente = new Cliente("12345678900", "John Doe", "john.doe@example.com");
        Restaurante restaurante1 = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);
        Restaurante restaurante2 = new Restaurante("Restaurante B", new Endereco(), "Japonesa", new HorarioDeFuncionamento(), 30);
        cliente.addRestaurante(restaurante1);
        cliente.addRestaurante(restaurante2);

        List<Restaurante> restaurantes = cliente.getRestaurantes();

        assertNotNull(restaurantes);
        assertEquals(2, restaurantes.size());
        assertTrue(restaurantes.contains(restaurante1));
        assertTrue(restaurantes.contains(restaurante2));
    }
}


