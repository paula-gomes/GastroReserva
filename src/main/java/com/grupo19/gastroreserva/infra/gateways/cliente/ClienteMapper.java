package com.grupo19.gastroreserva.infra.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail()
              );
    }

    public Cliente toDomain(ClienteEntity entity) {
        return new Cliente(entity.getCpf(),
                entity.getNome(),
                entity.getEmail());
    }
}
