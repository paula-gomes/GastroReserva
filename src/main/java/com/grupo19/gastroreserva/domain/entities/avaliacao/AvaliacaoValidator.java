package com.grupo19.gastroreserva.domain.entities.avaliacao;

public class AvaliacaoValidator {

    public void validate(Avaliacao avaliacao) {
        if (avaliacao.getCliente() == null || avaliacao.getRestaurante() == null ||
                avaliacao.getNota() == null || avaliacao.getData() == null) {
            throw new IllegalArgumentException("Os campos cliente, restaurante, nota e data são obrigatórios");
        }
        if (avaliacao.getNota() < 0 || avaliacao.getNota() > 5) {
            throw new IllegalArgumentException("Nota inválida");
        }
        if (!avaliacao.getCliente().getRestaurantes().contains(avaliacao.getRestaurante())) {
            throw new IllegalArgumentException("O Cliente nunca frequentou este restaurante");
        }
    }
}
