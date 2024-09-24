package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CadastrarRestauranteTest {
    @Mock
    private CadastrarRestauranteInterface cadastrarRestauranteInterface;
    @InjectMocks
    private CadastrarRestaurante cadastrarRestaurante;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void deveCadastrarRestaurante() {
        Restaurante restaurante = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);
        when(cadastrarRestauranteInterface.cadastrarRestaurante(restaurante)).thenReturn(restaurante);

        Restaurante result = cadastrarRestaurante.cadastrarRestaurante(restaurante);

        assertNotNull(result);
        assertEquals("Restaurante A", result.getNome());
        verify(cadastrarRestauranteInterface, times(1)).cadastrarRestaurante(restaurante);
    }
}
