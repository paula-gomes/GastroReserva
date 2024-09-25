package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.springframework.stereotype.Service;

@Service
public class ExcluirCliente implements ExcluirClienteInterface {

    private final RepositorioDeClienteJpa repositorioDeClienteJpa;

    public ExcluirCliente(RepositorioDeClienteJpa repositorioDeClienteJpa) {
        this.repositorioDeClienteJpa = repositorioDeClienteJpa;
    }

    public void excluirCliente(Cliente cliente) {
       repositorioDeClienteJpa.excluirCliente(cliente);
    }
}
