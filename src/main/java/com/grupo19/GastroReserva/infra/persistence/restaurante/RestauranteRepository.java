package com.grupo19.GastroReserva.infra.persistence.restaurante;

import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository {
    Restaurante save(RestauranteEntity entity);
    Optional<RestauranteEntity> findById(Long id);
    List<RestauranteEntity> findAll();
    void delete(RestauranteEntity entity);
}