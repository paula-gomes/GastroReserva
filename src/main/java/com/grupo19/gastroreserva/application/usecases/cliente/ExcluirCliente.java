package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.springframework.stereotype.Service;


public class ExcluirCliente implements ExcluirClienteInterface {

    private final ExcluirClienteInterface excluirClienteInterface;

    public ExcluirCliente(ExcluirClienteInterface excluirClienteInterface) {
        this.excluirClienteInterface = excluirClienteInterface;
    }

    public void excluirCliente(Cliente cliente) {
       excluirClienteInterface.excluirCliente(cliente);
    }
}
