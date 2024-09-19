package com.grupo19.GastroReserva.infra.persistence.cliente;

import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;
import lombok.Data;

import java.util.List;

@Data
public class ClienteEntity {

    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private List<Restaurante> restaurantes;

    public ClienteEntity() {
    }

    public ClienteEntity(String cpf, String nome, String email, List<Restaurante> restaurantes) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.restaurantes = restaurantes;
    }
}
