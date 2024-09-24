package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ExcluirCliente implements ExcluirClienteInterface {


    public void excluirCliente(Cliente cliente) {
       excluirCliente(cliente);
    }
}
