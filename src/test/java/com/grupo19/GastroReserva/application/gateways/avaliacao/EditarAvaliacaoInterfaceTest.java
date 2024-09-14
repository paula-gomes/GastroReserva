package com.grupo19.GastroReserva.application.gateways.avaliacao;

import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EditarAvaliacaoInterfaceTest {

    @Mock
    private EditarAvaliacaoInterface editarAvaliacaoInterface;
    AutoCloseable openMocks;

    @BeforeEach
    void configurar() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void derrubar() throws Exception {
        openMocks.close();
    }


    @Test
    public void devePermitirRegistrarEdicaoDeAvaliacao() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNota(5);

        when(editarAvaliacaoInterface.editarAvaliacao(avaliacao)).thenAnswer(invocation -> {
            Avaliacao a = invocation.getArgument(0);
            a.setNota(a.getNota() + 1);
            return a;
        });

        Avaliacao avaliacaoEditada = editarAvaliacaoInterface.editarAvaliacao(avaliacao);
        assertEquals(6, avaliacaoEditada.getNota());
    }
}
