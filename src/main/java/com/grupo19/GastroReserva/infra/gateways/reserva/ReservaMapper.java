package com.grupo19.GastroReserva.infra.gateways.reserva;

import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import com.grupo19.GastroReserva.infra.persistence.reserva.ReservaEntity;

public class ReservaMapper {

    public ReservaEntity toEntity(Reserva reserva) {
        return new ReservaEntity(reserva.getCliente(),
                reserva.getRestaurante(),
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    public Reserva toDomain(ReservaEntity reservaEntity) {
        return new Reserva(reservaEntity.getCliente(),
                reservaEntity.getRestaurante(),
                reservaEntity.getHorario(),
                reservaEntity.getData(),
                reservaEntity.getQuantidade());
    }
}
