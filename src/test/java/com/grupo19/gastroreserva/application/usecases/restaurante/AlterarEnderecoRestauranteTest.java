package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AlterarEnderecoRestauranteTest {
    @Test
    void deveAlterarEnderecoRestaurante() {

        Endereco novoEndereco = new Endereco("12345-678", "Rua Nova", "123", "Cidade Nova", "Estado Novo", "SP");
        Restaurante restaurante = new Restaurante("Restaurante Teste", novoEndereco, "Italiana", new HorarioDeFuncionamento(), 50);
        AlterarEnderecoRestauranteInterface mockInterface = Mockito.mock(AlterarEnderecoRestauranteInterface.class);
        Mockito.when(mockInterface.alterarEnderecoRestaurante(restaurante)).thenReturn(restaurante);
        AlterarEnderecoRestaurante alterarEnderecoRestaurante = new AlterarEnderecoRestaurante(mockInterface);

        Restaurante resultado = alterarEnderecoRestaurante.alterarEnderecoRestaurante(restaurante);

        assertNotNull(resultado);
        assertEquals(novoEndereco, resultado.getEndereco());
    }
}
