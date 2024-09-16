package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.GastroReserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
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

public class ListarRestaurantesTest {
    @Mock
    private ListarRestaurantesInterface listarRestauranteInterface;
    @InjectMocks
    private ListarRestaurantes listarRestaurantes;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void deveListarRestaurantes() {
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
