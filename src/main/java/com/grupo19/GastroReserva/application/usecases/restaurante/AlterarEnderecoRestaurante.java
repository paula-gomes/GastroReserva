package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

public class AlterarEnderecoRestaurante {

    private final AlterarEnderecoRestauranteInterface alterarEnderecoRestauranteInterface;

    public AlterarEnderecoRestaurante(AlterarEnderecoRestauranteInterface alterarEnderecoRestauranteInterface) {
        this.alterarEnderecoRestauranteInterface = alterarEnderecoRestauranteInterface;
    }

    public Restaurante alterarRestaurante(Restaurante restaurante) {
        return alterarEnderecoRestauranteInterface.alterarEnderecoRestaurante(restaurante);
    }
}
