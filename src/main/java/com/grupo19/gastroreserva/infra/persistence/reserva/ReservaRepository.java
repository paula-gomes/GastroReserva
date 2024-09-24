package com.grupo19.gastroreserva.infra.persistence.reserva;

import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository {
    void save(Reserva reserva);
    void delete(Long id);
    Optional<Reserva> findById(Long id);
    List<Reserva> findAll();
}
