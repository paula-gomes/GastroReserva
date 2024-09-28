package com.grupo19.gastroreserva.unit.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.gastroreserva.application.usecases.restaurante.ListarRestaurantes;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ListarRestaurantesTest {
    @Mock
    private ListarRestaurantesInterface listarRestauranteInterface;
    @InjectMocks
    private ListarRestaurantes listarRestaurantes;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void deveListarRestaurantes() {
        List<Restaurante> expectedList = Arrays.asList(
                new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50),
                new Restaurante("Restaurante B", new Endereco(), "Japonesa", new HorarioDeFuncionamento(), 30)
        );
        when(listarRestauranteInterface.listarRestaurantes()).thenReturn(expectedList);

        List<Restaurante> result = listarRestaurantes.listarRestaurantes();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Restaurante A", result.get(0).getNome());
        assertEquals("Restaurante B", result.get(1).getNome());
    }

}
