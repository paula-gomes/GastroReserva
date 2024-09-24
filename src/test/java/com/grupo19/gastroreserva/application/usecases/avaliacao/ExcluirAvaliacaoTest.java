package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

class ExcluirAvaliacaoTest {
    @Test
    void deveExcluirAvaliacao() {
        ExcluirAvaliacaoInterface mockExcluirAvaliacaoInterface = mock(ExcluirAvaliacaoInterface.class);
        ExcluirAvaliacao excluirAvaliacao = new ExcluirAvaliacao(mockExcluirAvaliacaoInterface);


        Cliente cliente = new Cliente("12345678900", "John Doe", "john.doe@example.com");
        Restaurante restaurante = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);

        cliente.addRestaurante(restaurante);
        Avaliacao avaliacao = new Avaliacao(cliente, restaurante, 4, "Bom", LocalDate.now());


        excluirAvaliacao.excluirAvaliacao(avaliacao);


        verify(mockExcluirAvaliacaoInterface, times(1)).excluirAvaliacao(avaliacao);
    }
}
