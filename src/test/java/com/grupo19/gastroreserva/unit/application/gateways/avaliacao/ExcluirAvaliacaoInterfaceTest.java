package com.grupo19.gastroreserva.unit.application.gateways.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ExcluirAvaliacaoInterfaceTest {

    @Mock
    private ExcluirAvaliacaoInterface excluirAvaliacaoInterface;
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
    public void deveExcluirAvaliacao() {
        Avaliacao avaliacao = new Avaliacao();
        excluirAvaliacaoInterface.excluirAvaliacao(avaliacao);
        verify(excluirAvaliacaoInterface, times(1)).excluirAvaliacao(avaliacao);
    }
}
