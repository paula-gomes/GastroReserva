package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.AlterarHorarioReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

public class AlterarHorarioReserva {

    private final AlterarHorarioReservaInterface alterarHorarioReservaInterface;

    public AlterarHorarioReserva(AlterarHorarioReservaInterface alterarHorarioReservaInterface) {
        this.alterarHorarioReservaInterface = alterarHorarioReservaInterface;
    }

    public Reserva alterarHorarioReserva(Reserva reserva) {
        return alterarHorarioReservaInterface.alterarHorarioReserva(reserva);
    }
}
