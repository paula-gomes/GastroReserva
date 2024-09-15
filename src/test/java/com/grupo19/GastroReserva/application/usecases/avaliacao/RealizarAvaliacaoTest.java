package com.grupo19.GastroReserva.application.usecases.avaliacao;

import com.grupo19.GastroReserva.application.gateways.avaliacao.RealizarAvaliacaoInterface;
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

        Avaliacao avaliacao = new Avaliacao(new Cliente(), new Restaurante(), 4, "Bom", LocalDate.now());
        when(mockRealizarAvaliacaoInterface.realizarAvaliacao(avaliacao)).thenReturn(avaliacao);

        Avaliacao resultado = realizarAvaliacao.realizarAvaliacao(avaliacao);

        verify(mockRealizarAvaliacaoInterface, times(1)).realizarAvaliacao(avaliacao);
        assertNotNull(resultado);
        assertEquals(avaliacao, resultado);
    }


}
