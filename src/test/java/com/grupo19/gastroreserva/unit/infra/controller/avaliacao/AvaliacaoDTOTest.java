package com.grupo19.gastroreserva.unit.infra.controller.avaliacao;

import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.avaliacao.AvaliacaoDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvaliacaoDTOTest {
    @Test
    void testAvaliacaoDTO() {
         Cliente cliente = new Cliente("123.456.789-10", "Cliente Teste", "email@teste.com");
        Restaurante restaurante = new Restaurante("Restaurante Teste", null, "Brasileira", null, 100);
        Integer nota = 5;
        String comentario = "Ótimo!";
        LocalDate data = LocalDate.now();

        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(cliente, restaurante, nota, comentario, data);

        assertEquals(cliente, avaliacaoDTO.cliente());
        assertEquals(restaurante, avaliacaoDTO.restaurante());
        assertEquals(nota, avaliacaoDTO.nota());
        assertEquals(comentario, avaliacaoDTO.comentario());
        assertEquals(data, avaliacaoDTO.data());
    }
}
