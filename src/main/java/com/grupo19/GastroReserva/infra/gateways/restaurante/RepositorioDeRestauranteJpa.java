package com.grupo19.GastroReserva.infra.gateways.restaurante;

import com.grupo19.GastroReserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.GastroReserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.GastroReserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.GastroReserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import com.grupo19.GastroReserva.infra.persistence.restaurante.RestauranteRepository;

import java.util.List;

public class RepositorioDeRestauranteJpa implements AlterarEnderecoRestauranteInterface, CadastrarRestauranteInterface,
        ExcluirRestauranteInterface, ListarRestaurantesInterface {

    private final RestauranteRepository restauranteRepository;

    public RepositorioDeRestauranteJpa(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    @Override
    public Restaurante alterarEnderecoRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public void excluirRestaurante(Restaurante restaurante) {
        restauranteRepository.delete(restaurante);
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();
    }
}
