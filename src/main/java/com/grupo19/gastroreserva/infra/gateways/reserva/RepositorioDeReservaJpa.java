package com.grupo19.gastroreserva.infra.gateways.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.*;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaEntity;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeReservaJpa implements AlterarDataReservaInterface, ListarReservasInterface, AlterarHorarioReservaInterface, CancelarReservaInterface, RealizarReservaInterface {

    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;

    public RepositorioDeReservaJpa(ReservaRepository reservaRepository, ReservaMapper reservaMapper) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public Reserva alterarDataReserva(Reserva reserva) {
        ReservaEntity entity = reservaMapper.toEntity(reserva);
        reservaRepository.save(entity);
        return reservaMapper.toDomain(entity);
    }

    @Override
    public Reserva alterarHorarioReserva(Reserva reserva) {
        ReservaEntity entity = reservaMapper.toEntity(reserva);
        reservaRepository.save(entity);
        return reservaMapper.toDomain(entity);
    }

    @Override
    public void cancelarReserva(Reserva reserva) {
        reservaRepository.delete(reserva.getId());
    }

    @Override
    public Reserva realizarReserva(Reserva reserva) {
        ReservaEntity entity = reservaMapper.toEntity(reserva);
        reservaRepository.save(entity);
        return reservaMapper.toDomain(entity);
    }

    @Override
    public List<Reserva> listarReservas(Cliente cliente) {
        List<Reserva> reservas = new ArrayList<>();
        reservaRepository.findAll().forEach(reserva -> reservas.add(reservaMapper.toDomain(reserva)));
        return reservas;
    }
}
