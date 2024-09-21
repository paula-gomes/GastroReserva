package com.grupo19.GastroReserva.infra.gateways.avaliacao;

import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.GastroReserva.infra.persistence.avaliacao.AvaliacaoEntity;

public interface AvaliacaoMapper {

    AvaliacaoEntity toEntity(Avaliacao avaliacao);
    Avaliacao toDomain(AvaliacaoEntity entity);
}
