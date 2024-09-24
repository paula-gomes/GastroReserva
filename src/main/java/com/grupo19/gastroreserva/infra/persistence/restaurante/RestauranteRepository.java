package com.grupo19.gastroreserva.infra.persistence.restaurante;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository {
    RestauranteEntity save(RestauranteEntity entity);
    Optional<RestauranteEntity> findById(Long id);
    List<RestauranteEntity> findAll();
    void delete(RestauranteEntity entity);
}