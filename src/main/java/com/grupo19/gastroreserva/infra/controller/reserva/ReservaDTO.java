package com.grupo19.gastroreserva.infra.controller.reserva;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaDTO(
        Cliente cliente,
        Restaurante restaurante,
        LocalTime horario,
        LocalDate data,
        Integer quantidade
) {
}
