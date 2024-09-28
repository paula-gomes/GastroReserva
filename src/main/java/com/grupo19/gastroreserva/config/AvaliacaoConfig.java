package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.usecases.avaliacao.EditarAvaliacao;
import com.grupo19.gastroreserva.application.usecases.avaliacao.ExcluirAvaliacao;
import com.grupo19.gastroreserva.application.usecases.avaliacao.ListarAvaliacoes;
import com.grupo19.gastroreserva.application.usecases.avaliacao.RealizarAvaliacao;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.AvaliacaoMapper;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.RepositorioDeAvaliacaoJpa;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliacaoConfig {

    @Bean
    EditarAvaliacao editarAvaliacao(RepositorioDeAvaliacaoJpa editarAvaliacaoInterface){
        return new EditarAvaliacao(editarAvaliacaoInterface);
    };

    @Bean
    ExcluirAvaliacao excluirAvaliacao(RepositorioDeAvaliacaoJpa excluirAvaliacaoInterface){
        return new ExcluirAvaliacao(excluirAvaliacaoInterface);
    }

    @Bean
    ListarAvaliacoes listarAvaliacoes(RepositorioDeAvaliacaoJpa listarAvaliacoesInterface){
        return new ListarAvaliacoes(listarAvaliacoesInterface);
    }

    @Bean
    RealizarAvaliacao realizarAvaliacao(RepositorioDeAvaliacaoJpa realizarAvaliacaoInterface){
        return new RealizarAvaliacao(realizarAvaliacaoInterface);
    }

    @Bean
    RepositorioDeAvaliacaoJpa criaRepositorioDeAvaliacaoJpa(AvaliacaoRepository avaliacaoRepository,
                                                            AvaliacaoMapper avaliacaoMapper,
                                                            ClienteMapper clienteMapper){
        return new RepositorioDeAvaliacaoJpa(avaliacaoRepository, avaliacaoMapper, clienteMapper);
    }

@Bean
AvaliacaoMapper criaMapper(ClienteMapper clienteMapper, RestauranteMapper restauranteMapper) {
    return new AvaliacaoMapper(clienteMapper, restauranteMapper);
}
}
