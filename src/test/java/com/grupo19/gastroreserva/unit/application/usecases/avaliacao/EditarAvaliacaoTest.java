package com.grupo19.gastroreserva.unit.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.EditarAvaliacaoInterface;
import com.grupo19.gastroreserva.application.usecases.avaliacao.EditarAvaliacao;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EditarAvaliacaoTest {
    private EditarAvaliacaoInterface editarAvaliacaoInterface;
    private EditarAvaliacao editarAvaliacao;

    @BeforeEach
    public void setUp() {
        editarAvaliacaoInterface = mock(EditarAvaliacaoInterface.class);
        editarAvaliacao = new EditarAvaliacao(editarAvaliacaoInterface);
    }

    @Test
    public void testEditarAvaliacao() {

        Avaliacao avaliacaoEsperada = new Avaliacao();

        when(editarAvaliacaoInterface.editarAvaliacao(any(Avaliacao.class))).thenReturn(avaliacaoEsperada);
        Avaliacao resultado = editarAvaliacao.editarAvaliacao(avaliacaoEsperada);
        verify(editarAvaliacaoInterface, times(1)).editarAvaliacao(any(Avaliacao.class));


        assertEquals(avaliacaoEsperada, resultado);
    }
}
