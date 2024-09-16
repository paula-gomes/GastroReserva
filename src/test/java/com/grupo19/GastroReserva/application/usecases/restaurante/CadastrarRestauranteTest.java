package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CadastrarRestauranteTest {
    @Mock
    private CadastrarRestauranteInterface cadastrarRestauranteInterface;
    @InjectMocks
    private CadastrarRestaurante cadastrarRestaurante;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void deveCadastrarRestaurante() {
        Restaurante restaurante = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);
        when(cadastrarRestauranteInterface.cadastrarRestaurante(restaurante)).thenReturn(restaurante);

        Restaurante result = cadastrarRestaurante.cadastrarRestaurante(restaurante);

        assertNotNull(result);
        assertEquals("Restaurante A", result.getNome());
        verify(cadastrarRestauranteInterface, times(1)).cadastrarRestaurante(restaurante);
    }
}
