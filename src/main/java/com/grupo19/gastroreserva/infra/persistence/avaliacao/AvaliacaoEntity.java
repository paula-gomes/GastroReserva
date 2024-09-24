package com.grupo19.gastroreserva.infra.persistence.avaliacao;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AvaliacaoEntity {

    private Long id;
    private Cliente cliente;
    private Restaurante restaurante;
    private Integer nota;
    private String comentario;
    private LocalDate data;

    public AvaliacaoEntity() {
    }

    public AvaliacaoEntity(Cliente cliente, Restaurante restaurante, Integer nota, String comentario, LocalDate data) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }
}
