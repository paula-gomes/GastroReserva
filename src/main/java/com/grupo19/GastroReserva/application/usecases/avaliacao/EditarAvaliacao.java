package com.grupo19.GastroReserva.application.usecases.avaliacao;

import com.grupo19.GastroReserva.application.gateways.avaliacao.EditarAvaliacaoInterface;
import com.grupo19.GastroReserva.domain.entities.avaliacao.Avaliacao;

public class EditarAvaliacao {

    private final EditarAvaliacaoInterface editarAvaliacaoInterface;

    public EditarAvaliacao(EditarAvaliacaoInterface editarAvaliacaoInterface) {
        this.editarAvaliacaoInterface = editarAvaliacaoInterface;
    }

    public Avaliacao editarAvaliacao(Avaliacao avaliacao) {
        return editarAvaliacaoInterface.editarAvaliacao(avaliacao);
    }
}
