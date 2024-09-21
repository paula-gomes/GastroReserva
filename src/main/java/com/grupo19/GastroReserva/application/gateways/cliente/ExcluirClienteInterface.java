package com.grupo19.GastroReserva.application.gateways.cliente;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ExcluirClienteInterface {

    void excluirCliente(Cliente cliente);
}
