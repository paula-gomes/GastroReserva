package com.grupo19.gastroreserva.unit.domain.entities.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.FabricaRestaurante;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FabricaRestauranteTest {


    @Test
    void enderecoDeveSerValido() {
        FabricaRestaurante fabrica = new FabricaRestaurante();
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento(LocalTime.of(9,0), LocalTime.of(18,0));
        Restaurante restaurante = fabrica.comTudoExcetoEndereco("Restaurante Teste", "Italiana", horario, 50);
        fabrica.incluirEndereco("12345-678", "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "SP");

        Endereco endereco = restaurante.getEndereco();
        assertEquals("12345-678", endereco.getCep());
        assertEquals("Rua Teste", endereco.getLogradouro());
        assertEquals("123", endereco.getNumero());
        assertEquals("Bairro Teste", endereco.getBairro());
        assertEquals("Cidade Teste", endereco.getCidade());
        assertEquals("SP", endereco.getEstado());
    }

    @Test
    void deveLancarExcecaoParaCepInvalido() {
        FabricaRestaurante fabrica = new FabricaRestaurante();
        assertThrows(IllegalArgumentException.class, () -> {
            fabrica.incluirEndereco("12345678", "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "SP");
        });
    }

}
