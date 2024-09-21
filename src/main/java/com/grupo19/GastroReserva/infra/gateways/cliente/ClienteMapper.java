package com.grupo19.GastroReserva.infra.gateways.cliente;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.infra.persistence.cliente.ClienteEntity;

public class ClienteMapper {

    public ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getRestaurantes());
    }

    public Cliente toDomain(ClienteEntity entity) {
        return new Cliente(entity.getCpf(),
                entity.getNome(),
                entity.getEmail(),
                entity.getRestaurantes());
    }
}
