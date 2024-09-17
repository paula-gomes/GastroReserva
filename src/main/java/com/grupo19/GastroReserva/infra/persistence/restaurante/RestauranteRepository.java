package com.grupo19.GastroReserva.infra.persistence.restaurante;

import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {
}
