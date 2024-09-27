package com.grupo19.gastroreserva.infra.persistence.restaurante;

import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import com.grupo19.gastroreserva.infra.persistence.horarioDeFuncionamento.HorarioDeFuncionamentoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Restaurante")
public class RestauranteEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @Column(name = "tipodecozinha")
    private String tipoDeCozinha;

    @ManyToOne
    @JoinColumn(name = "horariodefuncionamento_id")
    private HorarioDeFuncionamentoEntity horarioDeFuncionamento;

    @Column(name = "capacidade")
    private Integer capacidade;

    @Column(name = "cadeirasdisponiveis")
    private Integer cadeirasDisponiveis;

    public RestauranteEntity(String nome, EnderecoEntity endereco,
                             String tipoDeCozinha, HorarioDeFuncionamentoEntity horarioDeFuncionamento,
                             Integer capacidade, Integer cadeirasDisponiveis) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = cadeirasDisponiveis;
    }
}