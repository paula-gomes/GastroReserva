package com.grupo19.gastroreserva.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ListarClientesInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarClientes {

    private final ListarClientesInterface listarClientesInterface;

    public ListarClientes(@Qualifier("listarClientesAdapter")ListarClientesInterface listarClientesInterface) {
        this.listarClientesInterface = listarClientesInterface;
    }

    public List<Cliente> listarCliente(){
        return listarClientesInterface.listarClientes();
    }
}
