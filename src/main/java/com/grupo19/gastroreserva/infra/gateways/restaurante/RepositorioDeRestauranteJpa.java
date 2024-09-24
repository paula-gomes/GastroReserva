package com.grupo19.gastroreserva.infra.gateways.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositorioDeRestauranteJpa implements AlterarEnderecoRestauranteInterface,
        CadastrarRestauranteInterface, ExcluirRestauranteInterface, ListarRestaurantesInterface {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteMapperImpl mapper;

    public RepositorioDeRestauranteJpa(RestauranteRepository restauranteRepository, RestauranteMapperImpl mapper) {
        this.restauranteRepository = restauranteRepository;
        this.mapper = mapper;
    }

    @Override
    public Restaurante alterarEnderecoRestaurante(Restaurante restaurante) {
        RestauranteEntity entity = mapper.toEntity(restaurante);
        restauranteRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        RestauranteEntity entity = mapper.toEntity(restaurante);
        restauranteRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public void excluirRestaurante(Restaurante restaurante) {
        RestauranteEntity entity = mapper.toEntity(restaurante);
        restauranteRepository.delete(entity);
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
