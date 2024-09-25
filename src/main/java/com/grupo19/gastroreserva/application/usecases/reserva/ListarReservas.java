package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.ListarReservasInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;

import java.util.List;

public class ListarReservas {

    private final RepositorioDeReservaJpa repositorioDeReservaJpa;

    public ListarReservas(RepositorioDeReservaJpa repositorioDeReservaJpa) {
        this.repositorioDeReservaJpa = repositorioDeReservaJpa;
    }

    public List<Reserva> listarReservas(Cliente cliente) {
        return repositorioDeReservaJpa.listarReservas(cliente);
    }
}
