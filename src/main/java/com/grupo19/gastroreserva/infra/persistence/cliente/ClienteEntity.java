package com.grupo19.gastroreserva.infra.persistence.cliente;

import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cliente_entity")
public class ClienteEntity {

    @Id
    private Long id;
    private String cpf;
    private String nome;
    private String email;

    public ClienteEntity() {
    }

    public ClienteEntity(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
