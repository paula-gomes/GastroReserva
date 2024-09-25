package com.grupo19.gastroreserva.application.usecases.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.ListarAvaliacoesInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;

import java.util.List;

public class ListarAvaliacoes {

    private final ListarAvaliacoesInterface listarAvaliacoesInterface;

    public ListarAvaliacoes(ListarAvaliacoesInterface listarAvaliacoesInterface) {
        this.listarAvaliacoesInterface = listarAvaliacoesInterface;
    }

    public List<Avaliacao> listarAvaliacoes(Cliente cliente) {
        return listarAvaliacoesInterface.listarAvaliacoes(cliente);
    }
}
