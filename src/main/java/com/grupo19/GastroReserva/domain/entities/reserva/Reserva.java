package com.grupo19.GastroReserva.domain.entities.reserva;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;


public class Reserva {
    private Long id;
    private Cliente cliente;
    private Restaurante restaurante;
    private LocalTime horario;
    private LocalDate data;
    private Integer quantidade;

    public Reserva(Cliente cliente, Restaurante restaurante, LocalTime horario, LocalDate data, Integer quantidade) {

        if(quantidade > restaurante.getCapacidade()){
            throw new IllegalArgumentException("Quantidade excede a capacidade do restaurante");
        }

        if(horario.isBefore(restaurante.getHorarioDeFuncionamento().getHoraAbertura()) ||
                horario.isAfter(restaurante.getHorarioDeFuncionamento().getHoraFechamento())){
            throw new IllegalArgumentException("Horario incompativel com o funcionamento do restaurante");
        }

        this.cliente = cliente;
        this.restaurante = restaurante;
        this.horario = horario;
        this.data = data;
        this.quantidade = quantidade;
        this.restaurante.setCadeirasDisponiveis(quantidade);
    }

    public Reserva() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
