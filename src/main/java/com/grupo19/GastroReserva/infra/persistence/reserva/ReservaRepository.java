package com.grupo19.GastroReserva.infra.persistence.reserva;

import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
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
