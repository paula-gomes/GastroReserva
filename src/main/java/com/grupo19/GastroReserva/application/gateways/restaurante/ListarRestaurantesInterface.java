package com.grupo19.GastroReserva.application.gateways.restaurante;

import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

import java.util.List;

public interface ListarRestaurantesInterface {

    List<Restaurante> listarRestaurantes();
}
