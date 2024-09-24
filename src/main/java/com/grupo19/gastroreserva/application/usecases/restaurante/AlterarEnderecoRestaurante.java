package com.grupo19.gastroreserva.application.usecases.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public class AlterarEnderecoRestaurante {

    private final AlterarEnderecoRestauranteInterface alterarEnderecoRestauranteInterface;

    public AlterarEnderecoRestaurante(AlterarEnderecoRestauranteInterface alterarEnderecoRestauranteInterface) {
        this.alterarEnderecoRestauranteInterface = alterarEnderecoRestauranteInterface;
    }

    public Restaurante alterarEnderecoRestaurante(Restaurante restaurante) {
        return alterarEnderecoRestauranteInterface.alterarEnderecoRestaurante(restaurante);
    }
}
