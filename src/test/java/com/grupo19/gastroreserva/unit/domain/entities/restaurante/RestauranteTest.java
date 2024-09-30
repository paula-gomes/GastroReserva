package com.grupo19.gastroreserva.unit.domain.entities.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class
RestauranteTest {

    @Test
    public void todosCamposEstaoPresentes() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Exemplo");
        restaurante.setEndereco(new Endereco());
        restaurante.setTipoDeCozinha("Italiana");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8,0), LocalTime.of(22,0)));
        restaurante.setCapacidade(100);
        restaurante.setCadeirasDisponiveis(50);
        restaurante.ocuparCadeiras(10);

        Assertions.assertNotNull(restaurante.getNome(), "Nome não deve ser nulo");
        Assertions.assertNotNull(restaurante.getEndereco(), "Endereço não deve ser nulo");
        Assertions.assertNotNull(restaurante.getTipoDeCozinha(), "Tipo de Cozinha não deve ser nulo");
        Assertions.assertNotNull(restaurante.getHorarioDeFuncionamento(), "Horário de Funcionamento não deve ser nulo");
        Assertions.assertNotNull(restaurante.getCapacidade(), "Capacidade não deve ser nula");
        Assertions.assertNotNull(restaurante.getCadeirasDisponiveis(), "Cadeiras Disponíveis não devem ser nulas");
        Assertions.assertEquals(40, restaurante.getCadeirasDisponiveis(), "Cadeiras Disponíveis deve ser 40 após ocupar 10 cadeiras");
    }

    @Test
    public void numeroDeCadeirasOcupadasEValido() {
        Restaurante restaurante = new Restaurante("Restaurante Exemplo", new Endereco(), "Italiana", new HorarioDeFuncionamento(LocalTime.of(8,0), LocalTime.of(22,0)), 100);
        restaurante.ocuparCadeiras(10);
        Assertions.assertEquals(90, restaurante.getCadeirasDisponiveis(), "Cadeiras Disponiveis deve ser 90 apos ocupar 10 cadeiras");
    }

}
