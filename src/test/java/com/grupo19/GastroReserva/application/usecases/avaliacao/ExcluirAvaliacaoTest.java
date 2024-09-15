package com.grupo19.GastroReserva.application.usecases.avaliacao;

import com.grupo19.GastroReserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class ExcluirAvaliacaoTest {
    @Test
    public void deveExcluirAvaliacao() {
        ExcluirAvaliacaoInterface mockExcluirAvaliacaoInterface = mock(ExcluirAvaliacaoInterface.class);
        ExcluirAvaliacao excluirAvaliacao = new ExcluirAvaliacao(mockExcluirAvaliacaoInterface);

        Avaliacao avaliacao = new Avaliacao(new Cliente(), new Restaurante(), 4, "Bom", LocalDate.now());

        excluirAvaliacao.excluirAvaliacao(avaliacao);

        verify(mockExcluirAvaliacaoInterface, times(1)).excluirAvaliacao(avaliacao);
    }
}
