package com.grupo19.gastroreserva.domain.entities.avaliacao;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FabricaAvaliacaoTest {


    private FabricaAvaliacao fabricaAvaliacao;
    private Cliente cliente;
    private Restaurante restaurante;
    private LocalDate data;

    @BeforeEach
    void setUp() {
        fabricaAvaliacao = new FabricaAvaliacao();
        cliente = new Cliente();
        restaurante = new Restaurante();
        data = LocalDate.now();
    }

    @Test
    void deveRealizarAvaliacao() {
        // Arrange
        Integer nota = 5;
        String comentario = "Ótimo restaurante!";

        // Act
        Avaliacao avaliacao = fabricaAvaliacao.realizarAvaliacao(cliente, restaurante, nota, comentario, data);

        // Assert
        assertEquals(cliente, avaliacao.getCliente());
        assertEquals(restaurante, avaliacao.getRestaurante());
        assertEquals(nota, avaliacao.getNota());
        assertEquals(comentario, avaliacao.getComentario());
        assertEquals(data, avaliacao.getData());
    }

    @Test
    void deveAlterarAvaliacao() {

        Integer novaNota = 4;
        String novoComentario = "Muito bom, mas com algumas falhas.";
        LocalDate novaData = LocalDate.of(2023, 9, 25);

        fabricaAvaliacao.realizarAvaliacao(cliente, restaurante, 5, "Ótimo restaurante!", data);

        Avaliacao avaliacaoAlterada = fabricaAvaliacao.alterarAvaliacao(novaNota, novoComentario, novaData);

        assertEquals(novaNota, avaliacaoAlterada.getNota());
        assertEquals(novoComentario, avaliacaoAlterada.getComentario());
        assertEquals(novaData, avaliacaoAlterada.getData());
    }

    @Test
    void deveExcluirAvaliacao() {
        fabricaAvaliacao.realizarAvaliacao(cliente, restaurante, 5, "Ótimo restaurante!", data);

        Avaliacao avaliacaoExcluida = fabricaAvaliacao.excluirAvaliacao();

        assertNull(avaliacaoExcluida);
    }
}
