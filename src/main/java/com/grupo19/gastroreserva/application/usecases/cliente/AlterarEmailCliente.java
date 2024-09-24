package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public class AlterarEmailCliente implements AlterarEmailClienteInterface{


    public Cliente alterarEmailCliente(Cliente cliente) {
        return cliente;
    }
}
