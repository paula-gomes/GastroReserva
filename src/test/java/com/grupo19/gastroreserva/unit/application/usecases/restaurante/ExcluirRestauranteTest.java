package com.grupo19.gastroreserva.unit.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.gastroreserva.application.usecases.restaurante.ExcluirRestaurante;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ExcluirRestauranteTest {
    @Test
    void deveExcluirRestaurante() {
        ExcluirRestauranteInterface excluirRestauranteInterface = mock(ExcluirRestauranteInterface.class);
        ExcluirRestaurante excluirRestaurante = new ExcluirRestaurante(excluirRestauranteInterface);
        Restaurante restaurante = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);

        excluirRestaurante.excluirRestaurante(restaurante);

        verify(excluirRestauranteInterface, times(1)).excluirRestaurante(restaurante);
    }
}
