package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;

public class ExcluirCliente {

    private final ExcluirClienteInterface excluirClienteInterface;

    public ExcluirCliente(ExcluirClienteInterface excluirClienteInterface) {
        this.excluirClienteInterface = excluirClienteInterface;
    }

    public void excluirCliente(Cliente cliente) {
        excluirClienteInterface.excluirCliente(cliente);
    }
}
