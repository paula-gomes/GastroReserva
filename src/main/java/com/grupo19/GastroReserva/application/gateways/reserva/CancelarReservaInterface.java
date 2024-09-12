package com.grupo19.GastroReserva.application.gateways.reserva;

import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;

public interface CancelarReservaInterface {

    void cancelarReserva(Reserva reserva);
}
