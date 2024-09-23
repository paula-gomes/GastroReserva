package com.grupo19.GastroReserva.domain.entities.avaliacao;

import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FabricaAvaliacaoTest {

    @Test
    public void deveRealizarAvaliacaoComFabricaDeAvaliacao() {
        FabricaAvaliacao fabrica = new FabricaAvaliacao();

        Cliente cliente = new Cliente("12345678910", "nomeCliente", "email@teste.com");
        Endereco endereco = new Endereco("12345-789", "logradouro", "100", "bairro", "cidade", "SP");
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(LocalTime.of(8, 30), LocalTime.of(18, 30));
        Restaurante restaurante = new Restaurante("nomeRestaurante", endereco, "tipo Cozinha", horarioFuncionamento, 100);

        cliente.addRestaurante(restaurante);

        LocalDate data = LocalDate.now();

        Avaliacao avaliacao = fabrica.realizarAvaliacao(cliente, restaurante, 4, "muito bom", data);

        assertNotNull(avaliacao);
        assertEquals(cliente, avaliacao.getCliente());
        assertEquals(restaurante, avaliacao.getRestaurante());
        assertEquals(4, avaliacao.getNota());
        assertEquals("muito bom", avaliacao.getComentario());
        assertEquals(data, avaliacao.getData());
    }
}
