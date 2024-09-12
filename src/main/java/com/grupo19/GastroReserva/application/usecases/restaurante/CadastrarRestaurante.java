package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

public class CadastrarRestaurante {

    private final CadastrarRestauranteInterface cadastrarRestauranteInterface;

    public CadastrarRestaurante(CadastrarRestauranteInterface cadastrarRestauranteInterface) {
        this.cadastrarRestauranteInterface = cadastrarRestauranteInterface;
    }

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        return cadastrarRestauranteInterface.cadastrarRestaurante(restaurante);
    }
}
