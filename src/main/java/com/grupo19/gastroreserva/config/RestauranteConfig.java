package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.gateways.restaurante.AlterarEnderecoRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.CadastrarRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.ExcluirRestauranteInterface;
import com.grupo19.gastroreserva.application.gateways.restaurante.ListarRestaurantesInterface;
import com.grupo19.gastroreserva.application.usecases.restaurante.AlterarEnderecoRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.CadastrarRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ExcluirRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ListarRestaurantes;
import com.grupo19.gastroreserva.infra.gateways.EnderecoMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RepositorioDeRestauranteJpa;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoRepository;
import com.grupo19.gastroreserva.infra.persistence.horarioDeFuncionamento.HorarioDeFuncionamentoRepository;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteConfig {

    @Bean
    AlterarEnderecoRestaurante alterarEnderecoRestaurante(AlterarEnderecoRestauranteInterface alterarEnderecoRestauranteInterface) {
        return new AlterarEnderecoRestaurante(alterarEnderecoRestauranteInterface);
    }

    @Bean
    CadastrarRestaurante cadastrarRestaurante(CadastrarRestauranteInterface cadastrarRestauranteInterface) {
        return new CadastrarRestaurante(cadastrarRestauranteInterface);
    }

    @Bean
    ExcluirRestaurante excluirRestaurante(ExcluirRestauranteInterface excluirRestauranteInterface) {
        return new ExcluirRestaurante(excluirRestauranteInterface);
    }

    @Bean
    ListarRestaurantes listarRestaurantes(ListarRestaurantesInterface listarRestaurantesInterface) {
        return new ListarRestaurantes(listarRestaurantesInterface);
    }

    @Bean
    RepositorioDeRestauranteJpa criaRepositorioDeRestauranteJpa(RestauranteRepository restauranteRepository,
                                                                EnderecoRepository enderecoRepository,
                                                                RestauranteMapper restauranteMapper,
                                                                HorarioDeFuncionamentoRepository horarioDeFuncionamentoRepository) {
        return new RepositorioDeRestauranteJpa(restauranteRepository, enderecoRepository, restauranteMapper, horarioDeFuncionamentoRepository);
    }

    @Bean
    RestauranteMapper criaRestauranteMapper() { return new RestauranteMapper(); }


}
