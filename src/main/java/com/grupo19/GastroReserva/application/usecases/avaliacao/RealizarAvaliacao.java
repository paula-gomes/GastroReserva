package com.grupo19.GastroReserva.application.usecases.avaliacao;

import com.grupo19.GastroReserva.application.gateways.avaliacao.RealizarAvaliacaoInterface;
import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;

public class RealizarAvaliacao {

    private final RealizarAvaliacaoInterface realizarAvaliacaoInterface;

    public RealizarAvaliacao(RealizarAvaliacaoInterface realizarAvaliacaoInterface) {
        this.realizarAvaliacaoInterface = realizarAvaliacaoInterface;
    }

    public Avaliacao realizarAvaliacao(Avaliacao avaliacao) {
        return realizarAvaliacaoInterface.realizarAvaliacao(avaliacao);
    }
}
