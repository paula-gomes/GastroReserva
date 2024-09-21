package com.grupo19.GastroReserva.infra.gateways.reserva;

import com.grupo19.GastroReserva.application.gateways.reserva.AlterarDataReservaInterface;
import com.grupo19.GastroReserva.application.gateways.reserva.AlterarHorarioReservaInterface;
import com.grupo19.GastroReserva.application.gateways.reserva.CancelarReservaInterface;
import com.grupo19.GastroReserva.application.gateways.reserva.RealizarReservaInterface;
import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import com.grupo19.GastroReserva.infra.persistence.reserva.ReservaRepository;

public class RepositorioDeReservaJpa implements AlterarDataReservaInterface, AlterarHorarioReservaInterface, CancelarReservaInterface, RealizarReservaInterface {

    private final ReservaRepository reservaRepository;

    public RepositorioDeReservaJpa(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva alterarDataReserva(Reserva reserva) {
        reservaRepository.save(reserva);
        return reserva;
    }

    @Override
    public Reserva alterarHorarioReserva(Reserva reserva) {
        reservaRepository.save(reserva);
        return reserva;
    }

    @Override
    public void cancelarReserva(Reserva reserva) {
        reservaRepository.delete(reserva.getId());
    }

    @Override
    public Reserva realizarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
        return reserva;
    }
}
