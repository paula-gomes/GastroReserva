package com.grupo19.GastroReserva.application.usecases.reserva;

import com.grupo19.GastroReserva.application.gateways.reserva.RealizarReservaInterface;
import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;

public class RealizarReserva {

    private final RealizarReservaInterface realizarReservaInterface;

    public RealizarReserva(RealizarReservaInterface realizarReservaInterface) {
        this.realizarReservaInterface = realizarReservaInterface;
    }

    public Reserva realizarReserva(Reserva reserva) {
        return realizarReservaInterface.realizarReserva(reserva);
    }
}
