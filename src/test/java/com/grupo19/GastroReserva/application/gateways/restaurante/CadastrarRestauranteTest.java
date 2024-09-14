package com.grupo19.GastroReserva.application.gateways.restaurante;

import com.grupo19.GastroReserva.application.usecases.restaurante.CadastrarRestaurante;
import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CadastrarRestauranteTest {

    @Mock
    private CadastrarRestauranteInterface cadastrarRestauranteInterface;

    private CadastrarRestaurante cadastrarRestaurante;
    private AutoCloseable openMocks;

    @BeforeEach
    void configurar() {
        openMocks = MockitoAnnotations.openMocks(this);
        cadastrarRestaurante = new CadastrarRestaurante(cadastrarRestauranteInterface);
    }

    @AfterEach
    void derrubar() throws Exception {
        if (openMocks != null) {
            openMocks.close();
        }
    }

    @Test
    public void deveCadastrarRestauranteComSucesso() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco(new Endereco("12345-678", "logradouro", "100", "bairro", "cidade", "SP"));

        when(cadastrarRestauranteInterface.cadastrarRestaurante(restaurante)).thenAnswer(invocation -> {
            Restaurante r = invocation.getArgument(0);
            return r;
        });

        Restaurante restauranteCadastrado = cadastrarRestaurante.cadastrarRestaurante(restaurante);
        assertEquals("Restaurante Teste", restauranteCadastrado.getNome());
    }
}
