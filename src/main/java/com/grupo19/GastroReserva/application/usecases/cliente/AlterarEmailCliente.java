package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;

public class AlterarEmailCliente {

    private final AlterarEmailClienteInterface alterarEmailClienteInterface;

    public AlterarEmailCliente(AlterarEmailClienteInterface alterarEmailClienteInterface) {
        this.alterarEmailClienteInterface = alterarEmailClienteInterface;
    }

    public Cliente alterarEmailCliente(Cliente cliente) {
        return alterarEmailClienteInterface.alterarEmailCliente(cliente);
    }
}
