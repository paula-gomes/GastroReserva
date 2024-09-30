package com.grupo19.gastroreserva.unit.application.gateways.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.gastroreserva.application.usecases.restaurante.ExcluirRestaurante;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class ExcluirRestauranteTest {

    @Mock
    private ExcluirRestauranteInterface excluirRestauranteInterface;
    private ExcluirRestaurante excluirRestaurante;

    private AutoCloseable openMocks;

    @BeforeEach
    void configurar() {
        openMocks = MockitoAnnotations.openMocks(this);
        excluirRestaurante = new ExcluirRestaurante(excluirRestauranteInterface);
    }

    @AfterEach
    void derrubar() throws Exception {
        if (openMocks != null) {
            openMocks.close();
        }
    }

    @Test
    void deveExcluirRestauranteComSucesso() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");

        excluirRestaurante.excluirRestaurante(restaurante);

        verify(excluirRestauranteInterface).excluirRestaurante(restaurante);
    }
}
