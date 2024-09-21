package com.grupo19.GastroReserva.infra.persistence.reserva;

import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    private final List<Reserva> reservas = new ArrayList<>();

    @Override
    public void save(Reserva reserva) {
        // Verifica se o id já existe para determinar se é uma atualização ou uma nova reserva
        if (reserva.getId() == null) {
            reserva.setId((long) (reservas.size() + 1)); // Gera um id simples
            reservas.add(reserva);
        } else {
            // Atualiza a reserva existente
            reservas.removeIf(r -> r.getId().equals(reserva.getId()));
            reservas.add(reserva);
        }
    }

    @Override
    public void delete(Long id) {
        reservas.removeIf(reserva -> reserva.getId().equals(id));
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservas.stream()
                .filter(reserva -> reserva.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Reserva> findAll() {
        return new ArrayList<>(reservas);
    }
}
