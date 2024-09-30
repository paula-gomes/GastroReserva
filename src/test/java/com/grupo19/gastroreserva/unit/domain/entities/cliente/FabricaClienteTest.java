package com.grupo19.gastroreserva.unit.domain.entities.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.cliente.FabricaCliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FabricaClienteTest {
    private FabricaCliente fabricaCliente;

    @BeforeEach
    public void setUp() {
        fabricaCliente = new FabricaCliente();
    }

    @Test
    public void testComNomeCpfEmail() {
        
        String nome = "Cliente Teste";
        String cpf = "123.456.789-10";
        String email = "cliente@teste.com";

        
        Cliente cliente = fabricaCliente.comNomeCpfEmail(nome, cpf, email);

        
        assertNotNull(cliente);
        assertEquals(nome, cliente.getNome());
        assertEquals(cpf, cliente.getCpf());
        assertEquals(email, cliente.getEmail());
        assertTrue(cliente.getRestaurantes().isEmpty(), "A lista de restaurantes deve estar vazia inicialmente");
    }

    @Test
    public void testIncluirRestaurante() {
        
        Cliente cliente = fabricaCliente.comNomeCpfEmail("Cliente Teste", "123.456.789-10", "cliente@teste.com");

        
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Exemplo");

        
        cliente = fabricaCliente.incluirRestaurante(restaurante);

        
        assertEquals(1, cliente.getRestaurantes().size(), "Deve haver um restaurante incluído");
        assertEquals(restaurante, cliente.getRestaurantes().get(0), "O restaurante incluído deve ser o mesmo que foi adicionado");
    }
}
