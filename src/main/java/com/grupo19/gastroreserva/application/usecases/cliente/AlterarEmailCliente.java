package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.springframework.stereotype.Service;

public class AlterarEmailCliente implements AlterarEmailClienteInterface{

    private final AlterarEmailClienteInterface alterarEmailClienteInterface;

    public AlterarEmailCliente(AlterarEmailClienteInterface alterarEmailClienteInterface) {
        this.alterarEmailClienteInterface = alterarEmailClienteInterface;
    }

    public Cliente alterarEmailCliente(Cliente cliente) {
        return alterarEmailClienteInterface.alterarEmailCliente(cliente);
    }
}
