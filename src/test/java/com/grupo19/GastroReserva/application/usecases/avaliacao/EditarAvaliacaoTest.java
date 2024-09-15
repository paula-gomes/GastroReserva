package com.grupo19.GastroReserva.application.usecases.avaliacao;

import com.grupo19.GastroReserva.application.gateways.avaliacao.EditarAvaliacaoInterface;
import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class EditarAvaliacaoTest {
    @Test
    public void deveEditarAvaliacao() {
        EditarAvaliacaoInterface mockInterface = Mockito.mock(EditarAvaliacaoInterface.class);
        Avaliacao avaliacao = new Avaliacao(new Cliente(), new Restaurante(), 4, "Bom", LocalDate.now());
        Mockito.when(mockInterface.editarAvaliacao(avaliacao)).thenReturn(avaliacao);

        EditarAvaliacao editarAvaliacao = new EditarAvaliacao(mockInterface);
        Avaliacao result = editarAvaliacao.editarAvaliacao(avaliacao);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(avaliacao, result);
    }

    @Test
    public void deveTratarAvaliacaoQuandoNulo() {
        EditarAvaliacaoInterface mockInterface = Mockito.mock(EditarAvaliacaoInterface.class);
        Mockito.when(mockInterface.editarAvaliacao(null)).thenThrow(new IllegalArgumentException("Avaliacao nao pode ser nulo"));

        EditarAvaliacao editarAvaliacao = new EditarAvaliacao(mockInterface);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            editarAvaliacao.editarAvaliacao(null);
        });
        Assertions.assertEquals("Avaliacao nao pode ser nulo", exception.getMessage());
    }
}
