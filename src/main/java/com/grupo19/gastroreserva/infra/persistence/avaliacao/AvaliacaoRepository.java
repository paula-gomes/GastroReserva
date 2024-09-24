package com.grupo19.gastroreserva.infra.persistence.avaliacao;

import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;

import java.util.List;

public interface AvaliacaoRepository {
    AvaliacaoEntity save(AvaliacaoEntity avaliacaoEntity);
    AvaliacaoEntity findById(Long id);
    void delete(AvaliacaoEntity avaliacaoEntity);

    List<AvaliacaoEntity> findByCliente(ClienteEntity clienteEntity);
}