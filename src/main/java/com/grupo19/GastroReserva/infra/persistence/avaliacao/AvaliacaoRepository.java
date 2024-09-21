package com.grupo19.GastroReserva.infra.persistence.avaliacao;

import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository {
    void save(AvaliacaoEntity avaliacaoEntity);
    AvaliacaoEntity findById(Long id);
    void delete(AvaliacaoEntity avaliacaoEntity);
}