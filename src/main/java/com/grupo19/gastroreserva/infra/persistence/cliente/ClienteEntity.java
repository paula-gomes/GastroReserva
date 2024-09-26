package com.grupo19.gastroreserva.infra.persistence.cliente;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String email;

    public ClienteEntity() {}

    public ClienteEntity(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
}
