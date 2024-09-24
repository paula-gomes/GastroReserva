package com.grupo19.gastroreserva.infra.persistence.avaliacao;

public interface AvaliacaoRepository {
    void save(AvaliacaoEntity avaliacaoEntity);
    AvaliacaoEntity findById(Long id);
    void delete(AvaliacaoEntity avaliacaoEntity);
}