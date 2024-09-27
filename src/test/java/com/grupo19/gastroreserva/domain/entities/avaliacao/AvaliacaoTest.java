package com.grupo19.gastroreserva.domain.entities.avaliacao;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvaliacaoTest {

    @Test
    public void todosCamposObrigatoriosDevemEstarPresentes(){
        Avaliacao avaliacao = new Avaliacao();

        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        Cliente cliente = new Cliente("123456789120", "nomeCliente", "email@teste.com");
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento(LocalTime.of(8,0), LocalTime.of(22,0));


        avaliacao.setCliente(cliente);
        avaliacao.setRestaurante(new Restaurante("nome restaurante", endereco, "tipo de cozinha", horario,100, 100));
        avaliacao.setNota(10);
        avaliacao.setData(LocalDate.of(2024, 9, 12));

        Assertions.assertNotNull(avaliacao.getCliente(), "Cliente nao deve ser nulo");
        Assertions.assertNotNull(avaliacao.getRestaurante(), "Restaurante nao deve ser nulo");
        Assertions.assertNotNull(avaliacao.getNota(), "Nota nao deve ser nula");
        Assertions.assertNotNull(avaliacao.getData(), "Data nao deve ser nula");
    }
}
