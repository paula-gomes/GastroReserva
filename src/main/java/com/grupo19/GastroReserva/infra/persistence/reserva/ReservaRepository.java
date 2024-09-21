package com.grupo19.GastroReserva.infra.persistence.reserva;

import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {
}
