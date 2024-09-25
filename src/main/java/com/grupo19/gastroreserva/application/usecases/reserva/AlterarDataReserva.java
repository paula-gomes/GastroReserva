package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.AlterarDataReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;

public class AlterarDataReserva {

    private final RepositorioDeReservaJpa repositorioDeReservaJpa;

    public AlterarDataReserva(RepositorioDeReservaJpa repositorioDeReservaJpa) {
        this.repositorioDeReservaJpa = repositorioDeReservaJpa;
    }

    public Reserva alterarDataReserva(Reserva reserva) {
        return repositorioDeReservaJpa.alterarDataReserva(reserva);
    }
}
