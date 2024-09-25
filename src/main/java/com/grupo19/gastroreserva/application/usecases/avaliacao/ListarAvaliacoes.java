package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ListarAvaliacoesInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.RepositorioDeAvaliacaoJpa;

import java.util.List;

public class ListarAvaliacoes {

    private final RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa;

    public ListarAvaliacoes(RepositorioDeAvaliacaoJpa repositorioDeAvaliacaoJpa) {
        this.repositorioDeAvaliacaoJpa = repositorioDeAvaliacaoJpa;
    }

    public List<Avaliacao> listarAvaliacoes(Cliente cliente) {
        return repositorioDeAvaliacaoJpa.listarAvaliacoes(cliente);
    }
}
