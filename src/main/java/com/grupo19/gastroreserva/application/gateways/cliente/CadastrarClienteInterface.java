package com.grupo19.gastroreserva.application.gateways.cliente;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

public interface CadastrarClienteInterface {

    Cliente cadastrarCliente(Cliente cliente);
}
