package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.springframework.stereotype.Service;

@Service
public class AlterarEmailCliente implements AlterarEmailClienteInterface{

    private final RepositorioDeClienteJpa repositorioDeClienteJpa;

    public AlterarEmailCliente(RepositorioDeClienteJpa repositorioDeClienteJpa) {
        this.repositorioDeClienteJpa = repositorioDeClienteJpa;
    }

    public Cliente alterarEmailCliente(Cliente cliente) {
        return repositorioDeClienteJpa.alterarEmailCliente(cliente);
    }
}
