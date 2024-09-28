package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;


public class CadastrarCliente implements CadastrarClienteInterface {

    private final CadastrarClienteInterface cadastrarClienteInterface;


    public CadastrarCliente(CadastrarClienteInterface cadastrarClienteInterface) {
        this.cadastrarClienteInterface = cadastrarClienteInterface;
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return cadastrarClienteInterface.cadastrarCliente(cliente);
    }
}
