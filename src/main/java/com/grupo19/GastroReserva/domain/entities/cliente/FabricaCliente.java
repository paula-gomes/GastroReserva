package com.grupo19.GastroReserva.domain.entities.cliente;

public class FabricaCliente {

    private Cliente cliente;

    public Cliente comNomeCpfEmail(String nome, String cpf, String email) {
        cliente = new Cliente(cpf, nome, email);
        return cliente;
    }

    public Cliente comCpfNomeEmail(String cpf, String nome, String email) {
        cliente = new Cliente(cpf, nome, email);
        return cliente;
    }
}
