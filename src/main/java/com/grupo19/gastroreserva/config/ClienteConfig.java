package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.gastroreserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.application.gateways.cliente.ListarClientesInterface;
import com.grupo19.gastroreserva.application.usecases.cliente.AlterarEmailCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.CadastrarCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ExcluirCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ListarClientes;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteController;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ClienteConfig {

    @Bean
    AlterarEmailCliente alterarEmailCliente(AlterarEmailClienteInterface alterarEmailCliente){
        return new AlterarEmailCliente(alterarEmailCliente);
    }

    @Bean
    @Primary
    CadastrarCliente cadastrarCliente(CadastrarClienteInterface cadastrarCliente ){
        return new CadastrarCliente(cadastrarCliente);
    }

    @Bean
    ExcluirCliente excluirCliente(ExcluirClienteInterface excluirCliente){
        return new ExcluirCliente(excluirCliente);
    }

    @Bean
    ListarClientes listarClientes(ListarClientesInterface listarClientes){
        return new ListarClientes(listarClientes);
    }

    @Bean
    RepositorioDeClienteJpa criarRepositorioDeClienteJpa(ClienteRepository clienteRepository, ClienteMapper clienteMapper){
        return new RepositorioDeClienteJpa(clienteRepository, clienteMapper);
    }

    @Bean
    ClienteMapper criaClienteMapper(RestauranteMapper restauranteMapper) {
        return new ClienteMapper(restauranteMapper);
    }
}
