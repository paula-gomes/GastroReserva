package com.grupo19.GastroReserva.application.usecases.reserva;

import com.grupo19.GastroReserva.application.gateways.reserva.CancelarReservaInterface;
import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;

public class CancelarReserva {

    private final CancelarReservaInterface cancelarReservaInterface;

    public CancelarReserva(CancelarReservaInterface cancelarReservaInterface) {
        this.cancelarReservaInterface = cancelarReservaInterface;
    }

    public void cancelarReserva(Reserva reserva) {
        cancelarReservaInterface.cancelarReserva(reserva);
    }
}
