package com.grupo19.GastroReserva.domain.entities;

import com.grupo19.GastroReserva.domain.Endereco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnderecoTest {
    @Test
    public void deveCriarEnderecoComEnderecoValido() {
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
    public void deveRetornarErroQuandoCEPInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Endereco("1234-5678", "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "SP");
        });
        assertEquals("CEP invalido", exception.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoNumeroInvalido(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            new Endereco("12345-678", "Rua Teste", "ABC", "Bairro Teste", "Cidade Teste","SP");
        });
        assertEquals("Número invalido", exception.getMessage());
    }

    @Test
    public void deveRetornarErroQuandoEstadoInvalido(){
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            new Endereco("12345-678", "Rua Teste", "123", "Bairro Teste", "Cidade Teste", "São Paulo");
        });
        assertEquals("Estado invalido", exception.getMessage());
    }


}