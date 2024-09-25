package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.springframework.stereotype.Service;

@Service
public class CadastrarCliente implements CadastrarClienteInterface {

    private final RepositorioDeClienteJpa repositorioDeClienteJpa;

    public CadastrarCliente(RepositorioDeClienteJpa repositorioDeClienteJpa) {
        this.repositorioDeClienteJpa = repositorioDeClienteJpa;
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return repositorioDeClienteJpa.cadastrarCliente(cliente);
    }
}
