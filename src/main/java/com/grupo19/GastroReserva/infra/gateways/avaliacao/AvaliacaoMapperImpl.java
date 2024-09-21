package com.grupo19.GastroReserva.infra.gateways.avaliacao;

import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.GastroReserva.infra.persistence.avaliacao.AvaliacaoEntity;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapperImpl implements AvaliacaoMapper {

    @Override
    public AvaliacaoEntity toEntity(Avaliacao avaliacao) {
        return new AvaliacaoEntity(avaliacao.getCliente(),
                avaliacao.getRestaurante(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getData());
    }

    @Override
    public Avaliacao toDomain(AvaliacaoEntity entity) {
        return new Avaliacao(entity.getCliente(),
                entity.getRestaurante(),
                entity.getNota(),
                entity.getComentario(),
                entity.getData());
    }
}
