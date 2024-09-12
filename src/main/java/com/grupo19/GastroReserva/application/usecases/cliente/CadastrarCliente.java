package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;

public class CadastrarCliente {

    private final CadastrarClienteInterface cadastrarClienteInterface;

    public CadastrarCliente(CadastrarClienteInterface cadastrarClienteInterface) {
        this.cadastrarClienteInterface = cadastrarClienteInterface;
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return cadastrarClienteInterface.cadastrarCliente(cliente);
    }
}
