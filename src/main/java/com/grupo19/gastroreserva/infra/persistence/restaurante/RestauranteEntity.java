package com.grupo19.gastroreserva.infra.persistence.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "restaurante")
public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Endereco endereco;
    private String tipoDeCozinha;
    private HorarioDeFuncionamento horarioDeFuncionamento;
    private Integer capacidade;
    private Integer cadeirasDisponiveis;

    public RestauranteEntity() {}

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