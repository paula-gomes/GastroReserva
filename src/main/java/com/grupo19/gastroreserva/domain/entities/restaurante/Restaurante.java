package com.grupo19.gastroreserva.domain.entities.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;

public class Restaurante {
    private Long id;
    private String nome;
    private Endereco endereco;
    private String tipoDeCozinha;
    private HorarioDeFuncionamento horarioDeFuncionamento;
    private Integer capacidade;
    private Integer cadeirasDisponiveis;

    public Restaurante(String nome, Endereco endereco, String tipoDeCozinha, HorarioDeFuncionamento horarioDeFuncionamento, Integer capacidade) {

        if(capacidade <= 0){
            throw new IllegalArgumentException("Capacidade negativa ou igual a zero não pode ser aceita");
        }

        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = capacidade;
    }

    public Restaurante() {

    }

    public Restaurante(Long id, String nome, Endereco endereco, String tipoDeCozinha, HorarioDeFuncionamento horarioDeFuncionamento, Integer capacidade, Integer cadeirasDisponiveis) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = cadeirasDisponiveis;
    }

    public Restaurante(String nome, Endereco endereco, String tipoDeCozinha, HorarioDeFuncionamento horarioDeFuncionamento, Integer capacidade, Integer cadeirasDisponiveis) {
        this.nome = nome;
        this.endereco = endereco;
        this.tipoDeCozinha = tipoDeCozinha;
        this.horarioDeFuncionamento = horarioDeFuncionamento;
        this.capacidade = capacidade;
        this.cadeirasDisponiveis = cadeirasDisponiveis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTipoDeCozinha() {
        return tipoDeCozinha;
    }

    public void setTipoDeCozinha(String tipoDeCozinha) {
        this.tipoDeCozinha = tipoDeCozinha;
    }

    public HorarioDeFuncionamento getHorarioDeFuncionamento() {
        return horarioDeFuncionamento;
    }

    public void setHorarioDeFuncionamento(HorarioDeFuncionamento horarioDeFuncionamento) {
        this.horarioDeFuncionamento = horarioDeFuncionamento;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {

        this.capacidade = capacidade;
        this.cadeirasDisponiveis = capacidade;
    }

    public Integer getCadeirasDisponiveis() {
        return cadeirasDisponiveis;
    }


    public void setCadeirasDisponiveis(Integer cadeirasOcupadas) {
        this.cadeirasDisponiveis = cadeirasDisponiveis - cadeirasOcupadas;
    }
    public void ocuparCadeiras(Integer cadeirasOcupadas) {
        if (cadeirasOcupadas < 0 || cadeirasOcupadas > cadeirasDisponiveis) {
            throw new IllegalArgumentException("Número inválido de cadeiras ocupadas");
        }
        this.cadeirasDisponiveis -= cadeirasOcupadas;
    }
}