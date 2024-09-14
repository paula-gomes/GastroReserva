package com.grupo19.GastroReserva.domain.entities.cliente;

import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaClienteTest {

    @Test
    public void deveCriarClienteComNomeCpfEmailUtilizandoFabricaCliente(){

        FabricaCliente fabrica = new FabricaCliente();

        Cliente cliente = fabrica.comNomeCpfEmail("nomeCliente", "12345678910", "email@teste.com");
        assertNotNull(cliente);
        assertEquals("nomeCliente", cliente.getNome());
        assertEquals("12345678910", cliente.getCpf());
        assertEquals("email@teste.com", cliente.getEmail());
    }

    @Test
    public void deveAdicionarRestauranteUtilizandoFabricaCliente(){

        FabricaCliente fabrica = new FabricaCliente();
        Endereco endereco = new Endereco("12345-789", "logradouro", "100", "bairro", "cidade", "SP");
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(LocalTime.of(8,30), LocalTime.of(18,30));
        Restaurante restaurante = new Restaurante("nomeRestaurante", endereco, "tipo Cozinha", horarioFuncionamento, 100);

        Cliente cliente = fabrica.comNomeCpfEmail("nomeCliente", "12345678910", "email@teste.com");
        cliente = fabrica.incluirRestaurante(restaurante);
        assertNotNull(cliente);
        assertEquals(1, cliente.getRestaurantes().size());
        assertEquals("nomeRestaurante", cliente.getRestaurantes().get(0).getNome());
    }
}
