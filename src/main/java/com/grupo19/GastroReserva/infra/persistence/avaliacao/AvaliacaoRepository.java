package com.grupo19.GastroReserva.infra.persistence.avaliacao;

import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Integer> {
}
