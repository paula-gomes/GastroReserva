package com.grupo19.gastroreserva.unit.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ListarAvaliacoesInterface;
import com.grupo19.gastroreserva.application.usecases.avaliacao.ListarAvaliacoes;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ListarAvaliacaoTest {
    @Mock
    private ListarAvaliacoesInterface listarAvaliacoesInterface;

    @InjectMocks
    private ListarAvaliacoes listarAvaliacoes;

    private Cliente cliente;
    private Avaliacao avaliacao1;
    private Avaliacao avaliacao2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cliente = new Cliente();
        avaliacao1 = new Avaliacao();
        avaliacao2 = new Avaliacao();
    }

    @Test
    void deveListarAvaliacoesParaCliente() {
        List<Avaliacao> avaliacoesEsperadas = Arrays.asList(avaliacao1, avaliacao2);
        when(listarAvaliacoesInterface.listarAvaliacoes(cliente)).thenReturn(avaliacoesEsperadas);

        List<Avaliacao> resultado = listarAvaliacoes.listarAvaliacoes(cliente);

        assertEquals(avaliacoesEsperadas, resultado);
    }
}
