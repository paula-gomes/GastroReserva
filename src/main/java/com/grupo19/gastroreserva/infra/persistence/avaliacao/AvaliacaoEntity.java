package com.grupo19.gastroreserva.infra.persistence.avaliacao;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "avaliacao")
public class AvaliacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Cliente cliente;
    private Restaurante restaurante;
    private Integer nota;
    private String comentario;
    private LocalDate data;

    public AvaliacaoEntity() {}

    public AvaliacaoEntity(Cliente cliente, Restaurante restaurante, Integer nota, String comentario, LocalDate data) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }
}
