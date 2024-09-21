package com.grupo19.GastroReserva.infra.persistence.restaurante;

import com.grupo19.GastroReserva.domain.Endereco;
import com.grupo19.GastroReserva.domain.HorarioDeFuncionamento;
import com.grupo19.GastroReserva.infra.persistence.EnderecoEntity;
import lombok.Data;

@Data
public class RestauranteEntity {

    private Long id;
    private String nome;
    private Endereco endereco;
    private String tipoDeCozinha;
    private HorarioDeFuncionamento horarioDeFuncionamento;
    private Integer capacidade;
    private Integer cadeirasDisponiveis;

    public RestauranteEntity() {
    }

    public RestauranteEntity(String nome, Endereco endereco,
                             String tipoDeCozinha, HorarioDeFuncionamento horarioDeFuncionamento,
                             Integer capacidade, Integer cadeirasDisponiveis) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = cadeirasDisponiveis;
    }
}
