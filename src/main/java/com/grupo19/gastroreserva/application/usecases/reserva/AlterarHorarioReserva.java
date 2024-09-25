package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.AlterarHorarioReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;

public class AlterarHorarioReserva {

    private final RepositorioDeReservaJpa repositorioDeReservaJpa;

    public AlterarHorarioReserva(RepositorioDeReservaJpa repositorioDeReservaJpa) {
        this.repositorioDeReservaJpa = repositorioDeReservaJpa;
    }

    public Reserva alterarHorarioReserva(Reserva reserva) {
        return repositorioDeReservaJpa.alterarHorarioReserva(reserva);
    }
}
