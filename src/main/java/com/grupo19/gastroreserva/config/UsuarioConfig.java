package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.usecases.cliente.AlterarEmailCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.CadastrarCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ExcluirCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ListarClientes;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    AlterarEmailCliente alterarEmailCliente(RepositorioDeClienteJpa repositorioCliente){
        return new AlterarEmailCliente(repositorioCliente);
    }

    @Bean
    CadastrarCliente cadastrarCliente(RepositorioDeClienteJpa repositorioCliente){
        return new CadastrarCliente(repositorioCliente);
    }

    @Bean
    ExcluirCliente excluirCliente(RepositorioDeClienteJpa repositorioCliente){
        return new ExcluirCliente(repositorioCliente);
    }

    @Bean
    ListarClientes listarClientes(RepositorioDeClienteJpa repositorioCliente){
        return new ListarClientes(repositorioCliente);
    }
}
