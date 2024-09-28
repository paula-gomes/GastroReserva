package com.grupo19.gastroreserva.unit.infra.gateway.avaliacao;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.AvaliacaoMapper;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.RepositorioDeAvaliacaoJpa;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoRepository;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RepositorioDeAvaliacaoJpaTest {
    @InjectMocks
    private RepositorioDeAvaliacaoJpa repositorio;

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @Mock
    private AvaliacaoMapper mapper;

    @Mock
    private ClienteMapper clienteMapper;

    private Avaliacao avaliacao;
    private AvaliacaoEntity avaliacaoEntity;
    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(horaAbertura, horaFechamento);

        Restaurante restaurante = new Restaurante("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);
        restaurante.setId(1L);
        cliente = new Cliente("123.456.789-10", "João", "joao@email.com");
        cliente.addRestaurante(restaurante);

        avaliacao = new Avaliacao(cliente, restaurante, 5, "Excelente!", LocalDate.now());
        avaliacaoEntity = new AvaliacaoEntity(new ClienteEntity(), new RestauranteEntity(), 5, "Excelente!", LocalDate.now());

    }

    @Test
    public void testEditarAvaliacao() {
        when(mapper.toEntity(avaliacao)).thenReturn(avaliacaoEntity);
        when(avaliacaoRepository.save(avaliacaoEntity)).thenReturn(avaliacaoEntity);
        when(mapper.toDomain(avaliacaoEntity)).thenReturn(avaliacao);

        Avaliacao result = repositorio.editarAvaliacao(avaliacao);

        assertEquals(avaliacao.getNota(), result.getNota());
        assertEquals(avaliacao.getComentario(), result.getComentario());
    }

    @Test
    public void testExcluirAvaliacao() {
        when(mapper.toEntity(avaliacao)).thenReturn(avaliacaoEntity);

        repositorio.excluirAvaliacao(avaliacao);

        verify(avaliacaoRepository, times(1)).delete(avaliacaoEntity);
    }

    @Test
    public void testRealizarAvaliacao() {
        when(mapper.toEntity(avaliacao)).thenReturn(avaliacaoEntity);
        when(avaliacaoRepository.save(avaliacaoEntity)).thenReturn(avaliacaoEntity);
        when(mapper.toDomain(avaliacaoEntity)).thenReturn(avaliacao);

        Avaliacao result = repositorio.realizarAvaliacao(avaliacao);

        assertEquals(avaliacao.getNota(), result.getNota());
        assertEquals(avaliacao.getComentario(), result.getComentario());
    }

    @Test
    public void testListarAvaliacoes() {
        when(clienteMapper.toEntity(cliente)).thenReturn(new ClienteEntity());
        when(avaliacaoRepository.findByCliente(any(ClienteEntity.class))).thenReturn(Collections.singletonList(avaliacaoEntity));
        when(mapper.toDomain(avaliacaoEntity)).thenReturn(avaliacao);

        List<Avaliacao> result = repositorio.listarAvaliacoes(cliente);

        assertEquals(1, result.size());
        assertEquals(avaliacao.getNota(), result.get(0).getNota());
    }
}
