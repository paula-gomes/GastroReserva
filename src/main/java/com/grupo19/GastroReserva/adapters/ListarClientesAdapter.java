package com.grupo19.GastroReserva.adapters;

import com.grupo19.GastroReserva.application.gateways.cliente.ListarClientesInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarClientesAdapter implements ListarClientesInterface {


    private final RepositorioDeClienteJpa repositorioDeClienteJpa;

    public ListarClientesAdapter(RepositorioDeClienteJpa repositorioDeClienteJpa) {
        this.repositorioDeClienteJpa = repositorioDeClienteJpa;
    }

    @Override
    public List<Cliente> listarClientes() {
        return repositorioDeClienteJpa.listarClientes();
    }
}
