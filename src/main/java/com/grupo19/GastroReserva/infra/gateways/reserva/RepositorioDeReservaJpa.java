package com.grupo19.GastroReserva.infra.gateways.reserva;

import com.grupo19.GastroReserva.application.gateways.reserva.AlterarDataReservaInterface;
import com.grupo19.GastroReserva.application.gateways.reserva.AlterarHorarioReservaInterface;
import com.grupo19.GastroReserva.application.gateways.reserva.CancelarReservaInterface;
import com.grupo19.GastroReserva.application.gateways.reserva.RealizarReservaInterface;
import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import com.grupo19.GastroReserva.infra.persistence.reserva.ReservaEntity;
import com.grupo19.GastroReserva.infra.persistence.reserva.ReservaRepository;

public class RepositorioDeReservaJpa implements AlterarDataReservaInterface, AlterarHorarioReservaInterface, CancelarReservaInterface, RealizarReservaInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper mapper;

    public RepositorioDeReservaJpa(ReservaRepository reservaRepository, ReservaMapper mapper) {
        this.reservaRepository = reservaRepository;
        this.mapper = mapper;
    }

    @Override
    public Reserva alterarDataReserva(Reserva reserva) {
        ReservaEntity entity = mapper.toEntity(reserva);
        entity = reservaRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Reserva alterarHorarioReserva(Reserva reserva) {
        ReservaEntity entity = mapper.toEntity(reserva);
        entity = reservaRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public void cancelarReserva(Reserva reserva) {
        ReservaEntity entity = mapper.toEntity(reserva);
        reservaRepository.delete(entity);
    }

    @Override
    public Reserva realizarReserva(Reserva reserva) {
        ReservaEntity entity = mapper.toEntity(reserva);
        entity = reservaRepository.save(entity);
        return mapper.toDomain(entity);
    }
}
