package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AlterarEnderecoRestauranteTest {
    @Test
    public void deveAlterarEnderecoRestaurante() {

        Endereco novoEndereco = new Endereco("12345-678", "Rua Nova", "123", "Cidade Nova", "Estado Novo", "SP");
        Restaurante restaurante = new Restaurante("Restaurante Teste", novoEndereco, "Italiana", new HorarioDeFuncionamento(), 50);
        AlterarEnderecoRestauranteInterface mockInterface = Mockito.mock(AlterarEnderecoRestauranteInterface.class);
        Mockito.when(mockInterface.alterarEnderecoRestaurante(restaurante)).thenReturn(restaurante);
        AlterarEnderecoRestaurante alterarEnderecoRestaurante = new AlterarEnderecoRestaurante(mockInterface);

        Restaurante resultado = alterarEnderecoRestaurante.alterarRestaurante(restaurante);

        assertNotNull(resultado);
        assertEquals(novoEndereco, resultado.getEndereco());
    }
}
