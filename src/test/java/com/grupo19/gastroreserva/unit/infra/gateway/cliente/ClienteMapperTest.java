package com.grupo19.gastroreserva.unit.infra.gateway.cliente;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import com.grupo19.gastroreserva.infra.persistence.horarioDeFuncionamento.HorarioDeFuncionamentoEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteMapperTest {

    private ClienteMapper clienteMapper;

    @BeforeEach
    public void setUp() {
        clienteMapper = new ClienteMapper();
    }

    @Test
    public void testToEntity() {
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(horaAbertura, horaFechamento);
        Restaurante restaurante = new Restaurante("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);
        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restaurante));
        ClienteEntity result = clienteMapper.toEntity(cliente);

        assertEquals(cliente.getCpf(), result.getCpf());
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getEmail(), result.getEmail());
        assertEquals(1, result.getRestaurante().size());
    }

    @Test
    public void testToDomain() {
        // Inicialize o EnderecoEntity com valores apropriados
        EnderecoEntity enderecoEntity = new EnderecoEntity("12345-123", "logradouro", "12", "bairro", "cidade", "SP");

        // Inicialize o RestauranteEntity corretamente
        RestauranteEntity restauranteEntity = new RestauranteEntity();
        restauranteEntity.setNome("Restaurante A");
        restauranteEntity.setEndereco(enderecoEntity);
        restauranteEntity.setTipoDeCozinha("Italiana");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamentoEntity horarioDeFuncionamentoEntity = new HorarioDeFuncionamentoEntity(horaAbertura, horaFechamento);
        restauranteEntity.setHorarioDeFuncionamento(horarioDeFuncionamentoEntity);
        restauranteEntity.setCapacidade(100);


        // Crie o ClienteEntity com o RestauranteEntity inicializado
        ClienteEntity clienteEntity = new ClienteEntity("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restauranteEntity));
        Cliente result = clienteMapper.toDomain(clienteEntity);

        assertEquals(clienteEntity.getCpf(), result.getCpf());
        assertEquals(clienteEntity.getNome(), result.getNome());
        assertEquals(clienteEntity.getEmail(), result.getEmail());
        assertEquals(1, result.getRestaurantes().size()); // Esta asserção deve passar agora
    }
}
