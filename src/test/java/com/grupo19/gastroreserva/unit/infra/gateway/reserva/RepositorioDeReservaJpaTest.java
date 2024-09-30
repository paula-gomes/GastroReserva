package com.grupo19.gastroreserva.unit.infra.gateway.reserva;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;
import com.grupo19.gastroreserva.infra.gateways.reserva.ReservaMapper;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaEntity;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RepositorioDeReservaJpaTest {
    private ReservaRepository reservaRepository;
    private ReservaMapper reservaMapper;
    private RepositorioDeReservaJpa repositorioDeReservaJpa;
    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(horaAbertura, horaFechamento);

        restaurante = new Restaurante("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);
        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restaurante));

        reservaRepository = mock(ReservaRepository.class);
        reservaMapper = mock(ReservaMapper.class);
        repositorioDeReservaJpa = new RepositorioDeReservaJpa(reservaRepository, reservaMapper);
    }

    @Test
    void testAlterarDataReserva() {
        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restaurante));
        Reserva reserva = new Reserva(cliente, restaurante, LocalTime.of(16, 0), LocalDate.now(), 2);
        ReservaEntity reservaEntity = new ReservaEntity();

        when(reservaMapper.toEntity(reserva)).thenReturn(reservaEntity);
        when(reservaRepository.save(reservaEntity)).thenReturn(reservaEntity);
        when(reservaMapper.toDomain(reservaEntity)).thenReturn(reserva);

        Reserva result = repositorioDeReservaJpa.alterarDataReserva(reserva);

        verify(reservaRepository, times(1)).save(reservaEntity);
        assertEquals(reserva, result);
    }

    @Test
    void testAlterarHorarioReserva() {
        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restaurante));
        Reserva reserva = new Reserva(cliente, restaurante, LocalTime.of(16, 0), LocalDate.now(), 2);
        ReservaEntity reservaEntity = new ReservaEntity();

        when(reservaMapper.toEntity(reserva)).thenReturn(reservaEntity);
        when(reservaRepository.save(reservaEntity)).thenReturn(reservaEntity);
        when(reservaMapper.toDomain(reservaEntity)).thenReturn(reserva);

        Reserva result = repositorioDeReservaJpa.alterarHorarioReserva(reserva);

        verify(reservaRepository, times(1)).save(reservaEntity);
        assertEquals(reserva, result);
    }

    @Test
    void testCancelarReserva() {
        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restaurante));
        Reserva reserva = new Reserva(cliente, restaurante, LocalTime.of(16, 0), LocalDate.now(), 2);
        ReservaEntity reservaEntity = new ReservaEntity();

        when(reservaMapper.toEntity(reserva)).thenReturn(reservaEntity);

        repositorioDeReservaJpa.cancelarReserva(reserva);

        verify(reservaRepository, times(1)).delete(reservaEntity);
    }

    @Test
    void testRealizarReserva() {
        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restaurante));
        Reserva reserva = new Reserva(cliente, restaurante, LocalTime.of(16, 0), LocalDate.now(), 2);
        ReservaEntity reservaEntity = new ReservaEntity();

        when(reservaMapper.toEntity(reserva)).thenReturn(reservaEntity);
        when(reservaRepository.save(reservaEntity)).thenReturn(reservaEntity);
        when(reservaMapper.toDomain(reservaEntity)).thenReturn(reserva);

        Reserva result = repositorioDeReservaJpa.realizarReserva(reserva);

        verify(reservaRepository, times(1)).save(reservaEntity);
        assertEquals(reserva, result);
    }

    @Test
    void testListarReservas() {
        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com", Collections.singletonList(restaurante));
        ReservaEntity reservaEntity = new ReservaEntity();
        List<ReservaEntity> listaEntidades = Collections.singletonList(reservaEntity);
        when(reservaRepository.findAll()).thenReturn(listaEntidades);
        when(reservaMapper.toDomain(reservaEntity)).thenReturn(new Reserva(cliente, restaurante, LocalTime.of(16, 0), LocalDate.now(), 2));

        List<Reserva> result = repositorioDeReservaJpa.listarReservas(cliente);

        assertEquals(1, result.size());
    }
}
