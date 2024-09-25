package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.EditarAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.RepositorioDeAvaliacaoJpa;

public class EditarAvaliacao {

    private final RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa;

    public EditarAvaliacao(RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa) {
        this.repositorioDeAvaliacaoJpa = repositorioDeAvaliacaoJpa;
    }

    public Avaliacao editarAvaliacao(Avaliacao avaliacao) {
        return repositorioDeAvaliacaoJpa.editarAvaliacao(avaliacao);
    }
}
