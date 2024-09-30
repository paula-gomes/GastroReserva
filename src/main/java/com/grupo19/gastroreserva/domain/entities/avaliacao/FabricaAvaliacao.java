package com.grupo19.gastroreserva.domain.entities.avaliacao;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;

public class FabricaAvaliacao {

    private Avaliacao avaliacao;

    public Avaliacao realizarAvaliacao(Cliente cliente, Restaurante restaurante, Integer nota, String comentario,
                                       LocalDate data) {
        avaliacao = new Avaliacao(cliente, restaurante, nota, comentario, data);
        return avaliacao;
    }

    public Avaliacao alterarAvaliacao(Integer nota, String comentario, LocalDate data) {
        avaliacao.setNota(nota);
        avaliacao.setComentario(comentario);
        avaliacao.setData(data);
        return avaliacao;
    }

    public Avaliacao excluirAvaliacao(){
        avaliacao = null;
        return avaliacao;
    }
}
