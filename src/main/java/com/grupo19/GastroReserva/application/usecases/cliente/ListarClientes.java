package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.ListarClientesInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;

import java.util.List;

public class ListarClientes {

    private final ListarClientesInterface listarClientesInterface;

    public ListarClientes(ListarClientesInterface listarClientesInterface) {
        this.listarClientesInterface = listarClientesInterface;
    }

    public List<Cliente> listarCliente(){
        return listarClientesInterface.listarClientes();
    }
}
