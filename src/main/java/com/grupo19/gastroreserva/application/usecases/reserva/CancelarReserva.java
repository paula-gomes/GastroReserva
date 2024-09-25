package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.CancelarReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;

public class CancelarReserva {

    private final RepositorioDeReservaJpa repositorioDeReservaJpa;

    public CancelarReserva(RepositorioDeReservaJpa repositorioDeReservaJpa) {
        this.repositorioDeReservaJpa = repositorioDeReservaJpa;
    }

    public void cancelarReserva(Reserva reserva) {
        repositorioDeReservaJpa.cancelarReserva(reserva);
    }
}
