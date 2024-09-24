package com.grupo19.gastroreserva.infra.gateways.restaurante;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;


public interface RestauranteMapper {
    RestauranteEntity toEntity(Restaurante restaurante);
    Restaurante toDomain(RestauranteEntity entity);
}
