package com.grupo19.gastroreserva.infra.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    private final RestauranteMapper restauranteMapper;

    public ClienteMapper(RestauranteMapper restauranteMapper) {
        this.restauranteMapper = restauranteMapper;
    }

    public ClienteEntity toEntity(Cliente cliente) {
        List<RestauranteEntity> restaurantesEntity = cliente.getRestaurantes().stream()
                .map(restauranteMapper::toEntity)
                .collect(Collectors.toList());
        return new ClienteEntity(cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                restaurantesEntity
        );
    }

    public Cliente toDomain(ClienteEntity entity) {
        List<Restaurante> restaurantes = entity.getRestaurante().stream()
                .map(restauranteMapper::toDomain)
                .collect(Collectors.toList());
        return new Cliente(entity.getCpf(),
                entity.getNome(),
                entity.getEmail(),
                restaurantes);
    }
}