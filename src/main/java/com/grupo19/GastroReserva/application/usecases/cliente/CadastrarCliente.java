package com.grupo19.GastroReserva.application.usecases.cliente;

import com.grupo19.GastroReserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.springframework.stereotype.Service;

@Service
public class CadastrarCliente implements CadastrarClienteInterface {


    public Cliente cadastrarCliente(Cliente cliente){
        return cliente;
    }
}
