package com.grupo19.GastroReserva.application.usecases.reserva;

import com.grupo19.GastroReserva.application.gateways.reserva.AlterarDataReservaInterface;
import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;

public class AlterarDataReserva {

    private final AlterarDataReservaInterface alterarDataReservaInterface;

    public AlterarDataReserva(AlterarDataReservaInterface alterarDataReservaInterface) {
        this.alterarDataReservaInterface = alterarDataReservaInterface;
    }

    public Reserva alterarDataReserva(Reserva reserva) {
        return alterarDataReservaInterface.alterarDataReserva(reserva);
    }
}
