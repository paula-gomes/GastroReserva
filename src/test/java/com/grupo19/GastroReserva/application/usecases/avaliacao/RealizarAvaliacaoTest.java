package com.grupo19.GastroReserva.application.usecases.avaliacao;

import com.grupo19.GastroReserva.application.gateways.avaliacao.RealizarAvaliacaoInterface;
import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RealizarAvaliacaoTest {
    @Test
    public void deveRealizarAvaliacao() {

        RealizarAvaliacaoInterface mockRealizarAvaliacaoInterface = mock(RealizarAvaliacaoInterface.class);
        RealizarAvaliacao realizarAvaliacao = new RealizarAvaliacao(mockRealizarAvaliacaoInterface);

        Cliente cliente = new Cliente("12345678900", "John Doe", "john.doe@example.com");
        Restaurante restaurante = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);


        cliente.addRestaurante(restaurante);
        Avaliacao avaliacao = new Avaliacao(cliente, restaurante, 4, "Bom", LocalDate.now());

        when(mockRealizarAvaliacaoInterface.realizarAvaliacao(avaliacao)).thenReturn(avaliacao);

        Avaliacao resultado = realizarAvaliacao.realizarAvaliacao(avaliacao);

        verify(mockRealizarAvaliacaoInterface, times(1)).realizarAvaliacao(avaliacao);

        assertNotNull(resultado);
        assertEquals(avaliacao, resultado);
    }


}
