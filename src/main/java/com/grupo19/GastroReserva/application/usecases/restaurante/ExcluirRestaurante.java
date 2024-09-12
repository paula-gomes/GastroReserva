package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

public class ExcluirRestaurante {

    private final ExcluirRestauranteInterface excluirRestauranteInterface;

    public ExcluirRestaurante(ExcluirRestauranteInterface excluirRestauranteInterface) {
        this.excluirRestauranteInterface = excluirRestauranteInterface;
    }

    public void excluirRestaurante(Restaurante restaurante) {
        excluirRestauranteInterface.excluirRestaurante(restaurante);
    }
}
