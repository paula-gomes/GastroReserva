package com.grupo19.gastroreserva.application.gateways.restaurante;

import com.grupo19.gastroreserva.application.usecases.restaurante.CadastrarRestaurante;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CadastrarRestauranteTest {

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
    void deveCadastrarRestauranteComSucesso() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco(new Endereco("12345-678", "logradouro", "100", "bairro", "cidade", "SP"));

        when(cadastrarRestauranteInterface.cadastrarRestaurante(restaurante)).thenAnswer(invocation ->
                invocation.getArgument(0)
        );

        Restaurante restauranteCadastrado = cadastrarRestaurante.cadastrarRestaurante(restaurante);
        assertEquals("Restaurante Teste", restauranteCadastrado.getNome());
    }
}
