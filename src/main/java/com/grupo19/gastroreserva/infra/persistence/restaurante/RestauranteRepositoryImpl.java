package com.grupo19.gastroreserva.infra.persistence.restaurante;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepository {

    private List<RestauranteEntity> restauranteList = new ArrayList<>();


    @Override
    public Restaurante save(RestauranteEntity entity) {
        return null;
    }

    @Override
    public Optional<RestauranteEntity> findById(Long id) {
        return restauranteList.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    @Override
    public List<RestauranteEntity> findAll() {
        return new ArrayList<>(restauranteList);
    }

    @Override
    public void delete(RestauranteEntity entity) {
        restauranteList.remove(entity);
    }
}
