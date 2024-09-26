package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.ListarReservasInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;

import java.util.List;

public class ListarReservas {

    private final ListarReservasInterface listarReservasInterface;

    public ListarReservas(ListarReservasInterface listarReservasInterface) {
        this.listarReservasInterface = listarReservasInterface;
    }

    public List<Reserva> listarReservas(Cliente cliente) {
        return listarReservasInterface.listarReservas(cliente);
    }
}
