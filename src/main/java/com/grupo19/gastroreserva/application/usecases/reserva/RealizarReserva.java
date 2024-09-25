package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.RealizarReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;

public class RealizarReserva {

    private final RepositorioDeReservaJpa repositorioDeReservaJpa;

    public RealizarReserva(RepositorioDeReservaJpa repositorioDeReservaJpa) {
        this.repositorioDeReservaJpa = repositorioDeReservaJpa;
    }

    public Reserva realizarReserva(Reserva reserva) {
        return repositorioDeReservaJpa.realizarReserva(reserva);
    }
}
