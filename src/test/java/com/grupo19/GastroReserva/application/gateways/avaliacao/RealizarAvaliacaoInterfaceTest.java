package com.grupo19.GastroReserva.application.gateways.avaliacao;

import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RealizarAvaliacaoInterfaceTest {

    @Mock
    private RealizarAvaliacaoInterface realizarAvaliacaoInterface;
    AutoCloseable openMocks;

    @BeforeEach
    public void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void derrubar() throws Exception {
        openMocks.close();
    }
    @Test
    public void deveRealizarAvaliacao() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setComentario("Comentario");
        when(realizarAvaliacaoInterface.realizarAvaliacao(avaliacao)).thenReturn(avaliacao);
        Avaliacao avaliacaoRetornada = realizarAvaliacaoInterface.realizarAvaliacao(avaliacao);
        verify(realizarAvaliacaoInterface, times(1)).realizarAvaliacao(avaliacao);

        assertEquals(avaliacao, avaliacaoRetornada);
        assertEquals("Comentario", avaliacaoRetornada.getComentario());
    }
}
