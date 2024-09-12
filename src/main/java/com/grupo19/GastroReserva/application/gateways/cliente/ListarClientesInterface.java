package com.grupo19.GastroReserva.application.gateways.cliente;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;

import java.util.List;

public interface ListarClientesInterface {

    List<Cliente> listarClientes();
}
