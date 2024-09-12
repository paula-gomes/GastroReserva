package com.grupo19.GastroReserva.application.usecases.restaurante;

import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

import java.util.List;

public class ListarRestaurantes {

    private final ListarRestaurantes listarRestaurantesInterface;

    public ListarRestaurantes(ListarRestaurantes listarRestaurantesInterface) {
        this.listarRestaurantesInterface = listarRestaurantesInterface;
    }

    public List<Restaurante> ListarRestaurantes() {
        return listarRestaurantesInterface.ListarRestaurantes();
    }
}
