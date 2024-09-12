package com.grupo19.GastroReserva.application.usecases.avaliacao;

import com.grupo19.GastroReserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;

public class ExcluirAvaliacao {

    private final ExcluirAvaliacaoInterface excluirAvaliacaoInterface;

    public ExcluirAvaliacao(ExcluirAvaliacaoInterface excluirAvaliacaoInterface) {
        this.excluirAvaliacaoInterface = excluirAvaliacaoInterface;
    }

    public void excluirAvaliacao(Avaliacao avaliacao) {
        excluirAvaliacaoInterface.excluirAvaliacao(avaliacao);
    }
}
