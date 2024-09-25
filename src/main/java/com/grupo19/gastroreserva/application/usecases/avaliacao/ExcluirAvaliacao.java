package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.RepositorioDeAvaliacaoJpa;

public class ExcluirAvaliacao {

    private final RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa;

    public ExcluirAvaliacao(RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa) {
        this.repositorioDeAvaliacaoJpa = repositorioDeAvaliacaoJpa;
    }

    public void excluirAvaliacao(Avaliacao avaliacao) {
        repositorioDeAvaliacaoJpa.excluirAvaliacao(avaliacao);
    }
}
