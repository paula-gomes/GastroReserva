package com.grupo19.gastroreserva.infra.controller.avaliacao;

import com.grupo19.gastroreserva.application.usecases.avaliacao.EditarAvaliacao;
import com.grupo19.gastroreserva.application.usecases.avaliacao.ExcluirAvaliacao;
import com.grupo19.gastroreserva.application.usecases.avaliacao.ListarAvaliacoes;
import com.grupo19.gastroreserva.application.usecases.avaliacao.RealizarAvaliacao;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AvaliacaoControllerTest {
    @Mock
    private EditarAvaliacao editarAvaliacao;

    @Mock
    private ExcluirAvaliacao excluirAvaliacao;

    @Mock
    private RealizarAvaliacao realizarAvaliacao;

    @Mock
    private ListarAvaliacoes listarAvaliacoes;

    @InjectMocks
    private AvaliacaoController avaliacaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAvaliacoes() {
        ListarAvaliacoes listarAvaliacoesMock = mock(ListarAvaliacoes.class);
        AvaliacaoController avaliacaoController = new AvaliacaoController(null, null, null, listarAvaliacoesMock);

        List<Restaurante> restaurantesFrequentados = new ArrayList<>();
        Restaurante restaurante = new Restaurante("Restaurante A", null, "Brasileira", null, 100);
        restaurantesFrequentados.add(restaurante);

        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-00", "John Doe", "john.doe@example.com", restaurantesFrequentados);
        Cliente cliente = new Cliente(clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.email(), restaurantesFrequentados);

        Avaliacao avaliacao = new Avaliacao(cliente, restaurante, 5, "Great!", LocalDate.now());
        List<Avaliacao> avaliacoesList = List.of(avaliacao);

        when(listarAvaliacoesMock.listarAvaliacoes(any(Cliente.class))).thenReturn(avaliacoesList);

        List<AvaliacaoDTO> result = avaliacaoController.getAvaliacoes(clienteDTO);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Great!", result.get(0).comentario());
        assertEquals(5, result.get(0).nota());
        assertEquals("Restaurante A", result.get(0).restaurante().getNome());
        assertEquals("John Doe", result.get(0).cliente().getNome());

        verify(listarAvaliacoesMock, times(1)).listarAvaliacoes(any(Cliente.class));
    }

    @Test
    void testRealizarAvaliacao() {

        Cliente cliente = new Cliente("123.456.789-10", "Cliente Teste", "email@teste.com");
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Exemplo");
        restaurante.setEndereco(new Endereco());
        restaurante.setTipoDeCozinha("Italiana");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8, 0), LocalTime.of(22, 0)));
        restaurante.setCapacidade(100);
        restaurante.setCadeirasDisponiveis(50);
        restaurante.ocuparCadeiras(10);

        cliente.addRestaurante(restaurante);


        Avaliacao avaliacao = new Avaliacao(cliente, restaurante, 4, "Bom", LocalDate.now());
        when(realizarAvaliacao.realizarAvaliacao(any(Avaliacao.class))).thenReturn(avaliacao);
        AvaliacaoDTO avaliacaoDTO = new AvaliacaoDTO(cliente, restaurante, 4, "Bom", LocalDate.now());
        AvaliacaoDTO result = avaliacaoController.realizarAvaliacao(avaliacaoDTO);

        assertEquals("Bom", result.comentario());
        verify(realizarAvaliacao, times(1)).realizarAvaliacao(any(Avaliacao.class));
    }
}
