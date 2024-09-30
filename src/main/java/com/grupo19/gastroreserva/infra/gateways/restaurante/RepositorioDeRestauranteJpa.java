package com.grupo19.gastroreserva.infra.gateways.restaurante;

import com.grupo19.gastroreserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoRepository;
import com.grupo19.gastroreserva.infra.persistence.horariodefuncionamento.HorarioDeFuncionamentoRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeRestauranteJpa implements AlterarEnderecoRestauranteInterface,
        CadastrarRestauranteInterface, ExcluirRestauranteInterface, ListarRestaurantesInterface {

    private final RestauranteRepository restauranteRepository;
    private final EnderecoRepository enderecoRepository;
    private final HorarioDeFuncionamentoRepository horarioDeFuncionamentoRepository;
    private final RestauranteMapper restauranteMapper;

    public RepositorioDeRestauranteJpa(RestauranteRepository restauranteRepository,
                                       EnderecoRepository enderecoRepository,
                                       RestauranteMapper restauranteMapper,
                                       HorarioDeFuncionamentoRepository horarioDeFuncionamentoRepository) {
        this.restauranteRepository = restauranteRepository;
        this.enderecoRepository = enderecoRepository;
        this.restauranteMapper = restauranteMapper;
        this.horarioDeFuncionamentoRepository = horarioDeFuncionamentoRepository;
    }

    @Override
    public Restaurante alterarEnderecoRestaurante(Restaurante restaurante) {
        RestauranteEntity entity = restauranteMapper.toEntity(restaurante);
        enderecoRepository.save(entity.getEndereco());
        horarioDeFuncionamentoRepository.save(entity.getHorarioDeFuncionamento());
        restauranteRepository.save(entity);
        return restauranteMapper.toDomain(entity);
    }

    @Override
    public Restaurante cadastrarRestaurante(Restaurante restaurante) {
        RestauranteEntity entity = restauranteMapper.toEntity(restaurante);
        enderecoRepository.save(entity.getEndereco());
        horarioDeFuncionamentoRepository.save(entity.getHorarioDeFuncionamento());
        restauranteRepository.save(entity);
        return restauranteMapper.toDomain(entity);
    }

    @Override
    public void excluirRestaurante(Restaurante restaurante) {
        RestauranteEntity entity = restauranteMapper.toEntity(restaurante);
        restauranteRepository.delete(entity);
    }

    @Override
    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll()
                .stream()
                .map(restauranteMapper::toDomain)
                .collect(Collectors.toList());
    }
}
