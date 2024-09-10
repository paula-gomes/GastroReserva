package com.grupo19.GastroReserva.domain.entities.restaurante;

import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;

public class FabricaRestaurante {
    private Restaurante restaurante;

    public Restaurante comTudoExcetoEndereco(String nome, String tipoDeCozinha,
                               HorarioDeFuncionamento horarioDeFuncionamento, Integer capacidade) {
        restaurante = new Restaurante(nome, null, tipoDeCozinha, horarioDeFuncionamento, capacidade);
        return restaurante;
    }

    public Restaurante incluirEndereco(String cep, String logradouro, String numero, String bairro, String cidade, String estado) {
        restaurante.setEndereco(new Endereco(cep, logradouro, numero, bairro, cidade, estado));
        return restaurante;
    }
}
