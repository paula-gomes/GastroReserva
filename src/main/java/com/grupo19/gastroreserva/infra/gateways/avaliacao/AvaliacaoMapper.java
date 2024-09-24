package com.grupo19.gastroreserva.infra.gateways.avaliacao;

import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;

public interface AvaliacaoMapper {

    AvaliacaoEntity toEntity(Avaliacao avaliacao);
    Avaliacao toDomain(AvaliacaoEntity entity);
}
