package com.grupo19.gastroreserva.infra.persistence.reserva;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaEntity {

    private Long id;
    private Cliente cliente;
    private Restaurante restaurante;
    private LocalTime horario;
    private LocalDate data;
    private Integer quantidade;

    public ReservaEntity() {
    }

    public ReservaEntity(Cliente cliente, Restaurante restaurante, LocalTime horario, LocalDate data, Integer quantidade) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.horario = horario;
        this.data = data;
        this.quantidade = quantidade;
    }
}
