package com.grupo19.GastroReserva.infra.gateways.restaurante;

import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import com.grupo19.GastroReserva.infra.persistence.restaurante.RestauranteEntity;


public interface RestauranteMapper {
    RestauranteEntity toEntity(Restaurante restaurante);
    Restaurante toDomain(RestauranteEntity entity);
}
