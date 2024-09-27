package com.grupo19.gastroreserva.application.gateways.restaurante;

import com.grupo19.gastroreserva.application.usecases.restaurante.AlterarEnderecoRestaurante;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AlterarEnderecoRestauranteInterfaceTest {
    @Mock
    private AlterarEnderecoRestauranteInterface alterarEnderecoRestauranteInterface;

    private AlterarEnderecoRestaurante alterarEnderecoRestaurante;

    private AutoCloseable openMocks;

    @BeforeEach
    void configurar() {
        openMocks = MockitoAnnotations.openMocks(this);
        alterarEnderecoRestaurante = new AlterarEnderecoRestaurante(alterarEnderecoRestauranteInterface);
    }

    @AfterEach
    void derrubar() throws Exception {
        if (openMocks != null) {
            openMocks.close();
        }
    }

    @Test
    void deveAlterarEnderecoDoRestauranteComSucesso() {
        Endereco enderecoOriginal = new Endereco("12345-678", "logradouro", "100", "bairro", "cidade", "SP");
        Restaurante restaurante = new Restaurante();
        restaurante.setEndereco(enderecoOriginal);

        Endereco enderecoAlterado = new Endereco("54321-987", "novoLogradouro", "200", "novoBairro", "novaCidade", "SP");

        when(alterarEnderecoRestauranteInterface.alterarEnderecoRestaurante(restaurante)).thenAnswer(invocation -> {
            Restaurante r = invocation.getArgument(0);
            r.setEndereco(enderecoAlterado);
            return r;
        });

        Restaurante restauranteAlterado = alterarEnderecoRestaurante.alterarEnderecoRestaurante(restaurante);
        assertEquals(enderecoAlterado, restauranteAlterado.getEndereco());
    }
}
