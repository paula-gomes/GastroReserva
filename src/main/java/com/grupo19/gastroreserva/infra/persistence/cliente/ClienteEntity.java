package com.grupo19.gastroreserva.infra.persistence.cliente;

import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class ClienteEntity implements Serializable {

    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_restaurante",
    joinColumns = @JoinColumn(name = "cliente_cpf"),
    inverseJoinColumns = @JoinColumn(name = "restaurante_id"))
    private List<RestauranteEntity> restaurante;

}

