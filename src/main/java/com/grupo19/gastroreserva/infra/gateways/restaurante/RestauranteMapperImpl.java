package com.grupo19.gastroreserva.infra.gateways.restaurante;


import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import org.springframework.stereotype.Component;

@Component
public class RestauranteMapperImpl implements RestauranteMapper {

    @Override
    public RestauranteEntity toEntity(Restaurante restaurante) {
        if (restaurante == null) {
            return null;
        }

        RestauranteEntity entity = new RestauranteEntity();
        entity.setNome(restaurante.getNome());
        entity.setEndereco(restaurante.getEndereco());
        entity.setTipoDeCozinha(restaurante.getTipoDeCozinha());
        entity.setHorarioDeFuncionamento(restaurante.getHorarioDeFuncionamento());
        entity.setCapacidade(restaurante.getCapacidade());
        entity.setCadeirasDisponiveis(restaurante.getCadeirasDisponiveis());

        return entity;
    }

    @Override
    public Restaurante toDomain(RestauranteEntity entity) {
        if (entity == null) {
            return null;
        }

        Restaurante restaurante = new Restaurante();
        restaurante.setNome(entity.getNome());
        restaurante.setCapacidade(entity.getCapacidade());
        if (entity.getEndereco() != null) {
            restaurante.setEndereco(entity.getEndereco());
        }

        return restaurante;
    }
}
