package com.grupo19.GastroReserva.infra.gateways.restaurante;

import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import com.grupo19.GastroReserva.infra.persistence.restaurante.RestauranteEntity;

public class RestauranteMapper {

    public RestauranteEntity toEntity(Restaurante restaurante) {
        return new RestauranteEntity(restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoDeCozinha(),
                restaurante.getHorarioDeFuncionamento(),
                restaurante.getCapacidade(),
                restaurante.getCadeirasDisponiveis());
    }

    public Restaurante toDomain(RestauranteEntity restauranteEntity) {
        return new Restaurante(restauranteEntity.getNome(),
                restauranteEntity.getEndereco(),
                restauranteEntity.getTipoDeCozinha(),
                restauranteEntity.getHorarioDeFuncionamento(),
                restauranteEntity.getCapacidade());
    }
}
