package com.grupo19.gastroreserva.utils;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.FabricaReserva;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class ReservaHelper {

    public static FabricaReserva criarReservaHelper() {
        return new FabricaReserva();
    }

    public static Reserva gerarReserva(Cliente cliente, Restaurante restaurante, LocalTime horario, LocalDate data, Integer quantidade) {
        FabricaReserva fabricaReserva = criarReservaHelper();
        return fabricaReserva.fazerReserva(cliente, restaurante, horario, data, quantidade);
    }
}