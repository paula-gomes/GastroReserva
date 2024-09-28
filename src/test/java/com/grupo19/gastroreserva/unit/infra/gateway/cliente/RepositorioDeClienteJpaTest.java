package com.grupo19.gastroreserva.unit.infra.gateway.cliente;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.cliente.RepositorioDeClienteJpa;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import com.grupo19.gastroreserva.infra.persistence.horarioDeFuncionamento.HorarioDeFuncionamentoEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RepositorioDeClienteJpaTest {
    @InjectMocks
    private RepositorioDeClienteJpa repositorio;

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper mapper;

    private Cliente cliente;
    private ClienteEntity clienteEntity;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        EnderecoEntity enderecoEntity = new EnderecoEntity("11111-654", "logradouro", "numero", "bairro", "cidade", "SP");
       RestauranteEntity restauranteEntity = new RestauranteEntity("Restaurante A", enderecoEntity, "Italiana", new HorarioDeFuncionamentoEntity(),100, 50);
        cliente = new Cliente("123.456.789-10", "João", "joao@email.com");
        clienteEntity = new ClienteEntity("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restauranteEntity));
    }

    @Test
    public void testCadastrarCliente() {
        when(mapper.toEntity(cliente)).thenReturn(clienteEntity);
        when(clienteRepository.save(clienteEntity)).thenReturn(clienteEntity);
        when(mapper.toDomain(clienteEntity)).thenReturn(cliente);

        Cliente result = repositorio.cadastrarCliente(cliente);

        assertEquals(cliente.getCpf(), result.getCpf());
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getEmail(), result.getEmail());
    }

    @Test
    public void testAlterarEmailCliente() {
        when(mapper.toEntity(cliente)).thenReturn(clienteEntity);
        when(clienteRepository.save(clienteEntity)).thenReturn(clienteEntity);
        when(mapper.toDomain(clienteEntity)).thenReturn(cliente);

        Cliente result = repositorio.alterarEmailCliente(cliente);

        assertEquals(cliente.getEmail(), result.getEmail());
    }

    @Test
    public void testExcluirCliente() {
        when(mapper.toEntity(cliente)).thenReturn(clienteEntity);

        repositorio.excluirCliente(cliente);

        verify(clienteRepository, times(1)).delete(clienteEntity);
    }

    @Test
    public void testListarClientes() {
        when(clienteRepository.findAll()).thenReturn(Collections.singletonList(clienteEntity));
        when(mapper.toDomain(clienteEntity)).thenReturn(cliente);

        List<Cliente> result = repositorio.listarClientes();

        assertEquals(1, result.size());
        assertEquals(cliente.getCpf(), result.get(0).getCpf());
    }
}
