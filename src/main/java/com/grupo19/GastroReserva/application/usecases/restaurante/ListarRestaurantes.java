package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

import java.util.List;

public class ListarRestaurantes {

    private final ListarRestaurantesInterface listarRestaurantesInterface;

    public ListarRestaurantes(ListarRestaurantesInterface listarRestaurantesInterface) {
        this.listarRestaurantesInterface = listarRestaurantesInterface;
    }

    public List<Restaurante> listarRestaurantes() {
        return listarRestaurantesInterface.listarRestaurantes();
    }
}
