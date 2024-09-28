package com.grupo19.gastroreserva.unit.infra.gateway.reserva;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.gateways.reserva.ReservaMapper;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RestauranteMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import com.grupo19.gastroreserva.infra.persistence.horarioDeFuncionamento.HorarioDeFuncionamentoEntity;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservaMapperTest {
    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private RestauranteMapper restauranteMapper;

    @InjectMocks
    private ReservaMapper reservaMapper;

    @Test
    void testToEntity() {
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(horaAbertura, horaFechamento);

        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.emptyList());
        Restaurante restaurante = new Restaurante("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);
        Reserva reserva = new Reserva(cliente, restaurante, LocalTime.now(), LocalDate.now(), 2);

        ClienteEntity mockClienteEntity = mock(ClienteEntity.class);
        RestauranteEntity mockRestauranteEntity = mock(RestauranteEntity.class);

        when(clienteMapper.toEntity(cliente)).thenReturn(mockClienteEntity);
        when(restauranteMapper.toEntity(restaurante)).thenReturn(mockRestauranteEntity);

        ReservaEntity reservaEntity = reservaMapper.toEntity(reserva);

        assertEquals(mockClienteEntity, reservaEntity.getCliente());
        assertEquals(mockRestauranteEntity, reservaEntity.getRestaurante());
        assertEquals(reserva.getHorario(), reservaEntity.getHorario());
        assertEquals(reserva.getData(), reservaEntity.getData());
        assertEquals(reserva.getQuantidade(), reservaEntity.getQuantidade());
    }

    @Test
    void testToDomain() {
        EnderecoEntity enderecoEntity = new EnderecoEntity("12345-123", "logradouro", "12", "bairro", "cidade", "SP");

        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamentoEntity horarioFuncionamentoEntity = new HorarioDeFuncionamentoEntity(horaAbertura, horaFechamento);

        RestauranteEntity restauranteEntity = new RestauranteEntity("Restaurante A", enderecoEntity, "Italiana", horarioFuncionamentoEntity, 50, 50); // capacidade correta

        List<RestauranteEntity> restaurantes = new ArrayList<>();
        restaurantes.add(restauranteEntity);

        ClienteEntity clienteEntity = new ClienteEntity("123.456.789-10", "João", "joao@email.com", restaurantes);

        ReservaEntity reservaEntity = new ReservaEntity(clienteEntity, restauranteEntity, LocalTime.now(), LocalDate.now(), 4); // Quantidade <= 50



        // Criar mocks para Cliente e Restaurante
        Cliente mockCliente = mock(Cliente.class);
        Restaurante mockRestaurante = mock(Restaurante.class);

        // Configurar comportamento dos mocks
        when(mockCliente.getCpf()).thenReturn("123.456.789-10");
        when(mockCliente.getNome()).thenReturn("João");
        when(mockCliente.getEmail()).thenReturn("joao@email.com");

        when(mockRestaurante.getNome()).thenReturn("Restaurante A");
        when(mockRestaurante.getEndereco()).thenReturn(new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP"));
        when(mockRestaurante.getTipoDeCozinha()).thenReturn("Italiana");

        when(clienteMapper.toDomain(clienteEntity)).thenReturn(mockCliente);
        when(restauranteMapper.toDomain(restauranteEntity)).thenReturn(mockRestaurante);

        // Mapeamento da reserva
        Reserva reserva = reservaMapper.toDomain(reservaEntity);

        // Verificações (asserts)
        assertEquals(mockCliente.getCpf(), reserva.getCliente().getCpf());
        assertEquals(mockCliente.getNome(), reserva.getCliente().getNome());
        assertEquals(mockCliente.getEmail(), reserva.getCliente().getEmail());
        assertEquals(mockRestaurante.getNome(), reserva.getRestaurante().getNome());
        assertEquals(mockRestaurante.getEndereco().getCep(), reserva.getRestaurante().getEndereco().getCep());
        assertEquals(reservaEntity.getHorario(), reserva.getHorario());
        assertEquals(reservaEntity.getData(), reserva.getData());
        assertEquals(reservaEntity.getQuantidade(), reserva.getQuantidade());
    }

    @Test
    void testReservaExcedeCapacidade() {
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(horaAbertura, horaFechamento);

        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.emptyList());
        Restaurante restaurante = new Restaurante("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);

        // Deve lançar uma IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(cliente, restaurante, LocalTime.now(), LocalDate.now(), 200);
        });
    }
}
