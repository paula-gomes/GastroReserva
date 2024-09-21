package com.grupo19.GastroReserva.application.gateways.cliente;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListarClientesInterface {

    List<Cliente> listarClientes();
}
