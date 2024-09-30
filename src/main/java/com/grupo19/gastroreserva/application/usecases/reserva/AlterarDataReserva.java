package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.AlterarDataReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

public class AlterarDataReserva {

    private final AlterarDataReservaInterface alterarDataReservaInterface;

    public AlterarDataReserva(AlterarDataReservaInterface alterarDataReservaInterface) {
        this.alterarDataReservaInterface = alterarDataReservaInterface;
    }

    public Reserva alterarDataReserva(Reserva reserva) {
        return alterarDataReservaInterface.alterarDataReserva(reserva);
    }
}
