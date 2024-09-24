package com.grupo19.gastroreserva.application.gateways.restaurante;

import com.grupo19.gastroreserva.application.usecases.restaurante.ListarRestaurantes;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ListarRestaurantesTest {
    @Mock
    private ListarRestaurantesInterface listarRestaurantesInterface;

    private ListarRestaurantes listarRestaurantes;

    private AutoCloseable openMocks;

    @BeforeEach
    void configurar() {
        openMocks = MockitoAnnotations.openMocks(this);
        listarRestaurantes = new ListarRestaurantes(listarRestaurantesInterface);
    }

    @AfterEach
    void derrubar() throws Exception {
        if (openMocks != null) {
            openMocks.close();
        }
    }

    @Test
    public void deveListarRestaurantesComSucesso() {
        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Restaurante A");

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Restaurante B");

        List<Restaurante> restaurantesEsperados = Arrays.asList(restaurante1, restaurante2);
        when(listarRestaurantesInterface.listarRestaurantes()).thenReturn(restaurantesEsperados);

        List<Restaurante> restaurantes = listarRestaurantes.listarRestaurantes();
        assertEquals(restaurantesEsperados, restaurantes);
    }
}
