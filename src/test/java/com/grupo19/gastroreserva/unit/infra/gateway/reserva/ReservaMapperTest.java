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
        Reserva reserva = new Reserva(cliente, restaurante, LocalTime.of(16, 0), LocalDate.now(), 4);

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
        ClienteEntity clienteEntity = new ClienteEntity("123.456.789-10", "Joao", "joao@email.com", new ArrayList<>());
        EnderecoEntity enderecoEntity = new EnderecoEntity("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        HorarioDeFuncionamentoEntity horarioFuncionamentoEntity = new HorarioDeFuncionamentoEntity(LocalTime.of(9, 0), LocalTime.of(18, 0));
        RestauranteEntity restauranteEntity = new RestauranteEntity("Restaurante A", enderecoEntity, "Italiana", horarioFuncionamentoEntity, 50, 50);
        ReservaEntity reservaEntity = new ReservaEntity(clienteEntity, restauranteEntity, LocalTime.of(16, 0), LocalDate.now(), 4);

        ClienteMapper clienteMapper = new ClienteMapper(new RestauranteMapper(null, null));
        RestauranteMapper restauranteMapper = new RestauranteMapper(null, null);
        ReservaMapper reservaMapper = new ReservaMapper(clienteMapper, restauranteMapper);

        Reserva reserva = reservaMapper.toDomain(reservaEntity);

        assertEquals(clienteEntity.getCpf(), reserva.getCliente().getCpf());
        assertEquals(restauranteEntity.getNome(), reserva.getRestaurante().getNome());
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

        Cliente cliente = new Cliente("123.456.789-10", "Joao", "joao@email.com", Collections.emptyList());
        Restaurante restaurante = new Restaurante("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);

           assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(cliente, restaurante, LocalTime.now(), LocalDate.now(), 200);
        });
    }
}
