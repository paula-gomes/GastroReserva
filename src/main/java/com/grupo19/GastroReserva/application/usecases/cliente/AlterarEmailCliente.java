package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public class AlterarEmailCliente implements AlterarEmailClienteInterface{


    public Cliente alterarEmailCliente(Cliente cliente) {
        return cliente;
    }
}
