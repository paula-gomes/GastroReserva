package com.grupo19.gastroreserva.unit.domain.entities;

import com.grupo19.gastroreserva.domain.Endereco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {
    @Test
    void deveCriarEnderecoComEnderecoValido() {
        Endereco endereco = new Endereco("12345-678", "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "SP");
        assertNotNull(endereco);
        assertEquals("12345-678", endereco.getCep());
        assertEquals("Rua Teste", endereco.getLogradouro());
        assertEquals("123", endereco.getNumero());
        assertEquals("Bairro Teste", endereco.getBairro());
        assertEquals("Cidade Teste", endereco.getCidade());
        assertEquals("SP", endereco.getEstado());
    }

    @Test
    void deveRetornarErroQuandoCEPInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Endereco("1234-5678", "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "SP");
        });
        assertEquals("CEP invalido", exception.getMessage());
    }

    @Test
    void deveRetornarErroQuandoNumeroInvalido(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            new Endereco("12345-678", "Rua Teste", "ABC", "Bairro Teste", "Cidade Teste","SP");
        });
        assertEquals("Número invalido", exception.getMessage());
    }

    @Test
    void deveRetornarErroQuandoEstadoInvalido(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            new Endereco("12345-678", "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "São Paulo");
        });
        assertEquals("Estado invalido", exception.getMessage());
    }


}