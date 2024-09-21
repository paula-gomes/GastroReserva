package com.grupo19.GastroReserva.infra.gateways.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.GastroReserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.GastroReserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.GastroReserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import com.grupo19.GastroReserva.infra.persistence.restaurante.RestauranteEntity;
import com.grupo19.GastroReserva.infra.persistence.restaurante.RestauranteRepository;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeRestauranteJpa implements AlterarEnderecoRestauranteInterface, CadastrarRestauranteInterface,
        ExcluirRestauranteInterface, ListarRestaurantesInterface {

    private final RestauranteRepository restauranteRepository;
    private final RestauranteMapper mapper;

    public RepositorioDeRestauranteJpa(RestauranteRepository restauranteRepository, RestauranteMapper mapper) {
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
        List<RestauranteEntity> entities = restauranteRepository.findAll();
        List<Restaurante> domains = new ArrayList<>();
        entities.forEach(entity -> domains.add(mapper.toDomain(entity)));
        return domains;
    }
}
