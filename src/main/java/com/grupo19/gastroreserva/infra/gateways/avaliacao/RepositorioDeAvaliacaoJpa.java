package com.grupo19.gastroreserva.infra.gateways.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.EditarAvaliacaoInterface;
import com.grupo19.gastroreserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.gastroreserva.application.gateways.avaliacao.RealizarAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoRepository;

public class RepositorioDeAvaliacaoJpa implements EditarAvaliacaoInterface, ExcluirAvaliacaoInterface, RealizarAvaliacaoInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoMapper mapper;

    public RepositorioDeAvaliacaoJpa(AvaliacaoRepository avaliacaoRepository, AvaliacaoMapper mapper) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.mapper = mapper;
    }


    @Override
    public Avaliacao editarAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity entity = mapper.toEntity(avaliacao);
        avaliacaoRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public void excluirAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity entity = mapper.toEntity(avaliacao);
        avaliacaoRepository.delete(entity);
    }

    @Override
    public Avaliacao realizarAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity entity = mapper.toEntity(avaliacao);
        avaliacaoRepository.save(entity);
        return mapper.toDomain(entity);
    }
}
