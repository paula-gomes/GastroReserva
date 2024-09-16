package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ExcluirRestauranteTest {
    @Test
    public void deveExcluirRestaurante() {
        ExcluirRestauranteInterface excluirRestauranteInterface = mock(ExcluirRestauranteInterface.class);
        ExcluirRestaurante excluirRestaurante = new ExcluirRestaurante(excluirRestauranteInterface);
        Restaurante restaurante = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);

        excluirRestaurante.excluirRestaurante(restaurante);

        verify(excluirRestauranteInterface, times(1)).excluirRestaurante(restaurante);
    }
}
