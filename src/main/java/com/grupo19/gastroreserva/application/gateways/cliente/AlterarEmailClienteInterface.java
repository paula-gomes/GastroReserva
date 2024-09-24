package com.grupo19.gastroreserva.application.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface AlterarEmailClienteInterface {

    Cliente alterarEmailCliente(Cliente cliente);
}
