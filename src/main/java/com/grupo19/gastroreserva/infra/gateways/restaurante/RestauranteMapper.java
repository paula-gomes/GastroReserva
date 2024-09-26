package com.grupo19.gastroreserva.infra.gateways.restaurante;


import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;

public class RestauranteMapper {


    public RestauranteEntity toEntity(Restaurante restaurante) {
        return new RestauranteEntity(restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoDeCozinha(),
                restaurante.getHorarioDeFuncionamento(),
                restaurante.getCapacidade(),
                restaurante.getCadeirasDisponiveis());
    }


    public Restaurante toDomain(RestauranteEntity entity) {
        return new Restaurante(entity.getNome(),
                entity.getEndereco(),
                entity.getTipoDeCozinha(),
                entity.getHorarioDeFuncionamento(),
                entity.getCapacidade(),
                entity.getCadeirasDisponiveis());
    }
}
