package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.RealizarAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.RepositorioDeAvaliacaoJpa;

public class RealizarAvaliacao {

    private final RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa;

    public RealizarAvaliacao(RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa) {
        this.repositorioDeAvaliacaoJpa = repositorioDeAvaliacaoJpa;
    }

    public Avaliacao realizarAvaliacao(Avaliacao avaliacao) {
        return repositorioDeAvaliacaoJpa.realizarAvaliacao(avaliacao);
    }
}
