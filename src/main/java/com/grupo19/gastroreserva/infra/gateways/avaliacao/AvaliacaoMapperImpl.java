package com.grupo19.gastroreserva.infra.gateways.avaliacao;

import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapperImpl  {


    public AvaliacaoEntity toEntity(Avaliacao avaliacao) {
        return new AvaliacaoEntity(avaliacao.getCliente(),
                avaliacao.getRestaurante(),
                avaliacao.getNota(),
                avaliacao.getComentario(),
                avaliacao.getData());
    }


    public Avaliacao toDomain(AvaliacaoEntity entity) {
        return new Avaliacao(entity.getCliente(),
                entity.getRestaurante(),
                entity.getNota(),
                entity.getComentario(),
                entity.getData());
    }
}
