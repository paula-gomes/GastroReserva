package com.grupo19.gastroreserva.domain.entities.cliente;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;

public class FabricaCliente {

    private Cliente cliente;

    public Cliente comNomeCpfEmail(String nome, String cpf, String email) {
        cliente = new Cliente(cpf, nome, email);
        return cliente;
    }

    public Cliente incluirRestaurante(Restaurante restaurante){
        cliente.getRestaurantes().add(restaurante);
        return cliente;
    }

}
