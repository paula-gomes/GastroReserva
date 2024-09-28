package com.grupo19.gastroreserva.unit.infra.gateway.avaliacao;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.avaliacao.AvaliacaoMapper;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AvaliacaoMapperTest {
    @InjectMocks
    private AvaliacaoMapper avaliacaoMapper;

    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private RestauranteMapper restauranteMapper;

    private Cliente cliente;
    private Restaurante restaurante;
    private Avaliacao avaliacao;
    private AvaliacaoEntity avaliacaoEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente("123.456.789-10", "John Doe", "john.doe@example.com");
        restaurante = new Restaurante("Restaurante A", new Endereco(), "Italiana", new HorarioDeFuncionamento(), 50);
        cliente.addRestaurante(restaurante);
        avaliacao = new Avaliacao(cliente, restaurante, 5, "Excelente!", LocalDate.now());
        avaliacaoEntity = new AvaliacaoEntity(new ClienteEntity(), new RestauranteEntity(), 5, "Excelente!", LocalDate.now());
    }

    @Test
    public void testToEntity() {
        when(clienteMapper.toEntity(cliente)).thenReturn(new ClienteEntity());
        when(restauranteMapper.toEntity(restaurante)).thenReturn(new RestauranteEntity());

        AvaliacaoEntity result = avaliacaoMapper.toEntity(avaliacao);

        assertEquals(5, result.getNota());
        assertEquals("Excelente!", result.getComentario());
    }

    @Test
    public void testToDomain() {
        when(clienteMapper.toDomain(avaliacaoEntity.getCliente())).thenReturn(cliente);
        when(restauranteMapper.toDomain(avaliacaoEntity.getRestaurante())).thenReturn(restaurante);

        Avaliacao result = avaliacaoMapper.toDomain(avaliacaoEntity);

        assertEquals(5, result.getNota());
        assertEquals("Excelente!", result.getComentario());
    }
}
