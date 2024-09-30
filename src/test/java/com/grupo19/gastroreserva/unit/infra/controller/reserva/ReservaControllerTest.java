package com.grupo19.gastroreserva.unit.infra.controller.reserva;

import com.grupo19.gastroreserva.application.usecases.reserva.*;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import com.grupo19.gastroreserva.infra.controller.reserva.ReservaController;
import com.grupo19.gastroreserva.infra.controller.reserva.ReservaDTO;
import com.grupo19.gastroreserva.infra.controller.restaurante.RestauranteDTO;
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

public class ReservaControllerTest {

    @Mock
    private AlterarDataReserva alterarDataReserva;

    @Mock
    private AlterarHorarioReserva alterarHorarioReserva;

    @Mock
    private CancelarReserva cancelarReserva;

    @Mock
    private RealizarReserva realizarReserva;

    @Mock
    private ListarReservas listarReservas;

    @InjectMocks
    private ReservaController reservaController;

    private ReservaDTO reservaDTO;
    private Reserva reserva;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-10", "João", "joao@email.com", null);
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horarioFuncionamento = new HorarioDeFuncionamento(horaAbertura, horaFechamento);
        RestauranteDTO restauranteDTO = new RestauranteDTO("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);
        LocalTime horario = LocalTime.of(17, 0);
        LocalDate data = LocalDate.now();
        reservaDTO = new ReservaDTO(clienteDTO, restauranteDTO, horario, data, 4);

        Cliente cliente = new Cliente("123.456.789-10", "João", "joao@email.com");
        Restaurante restaurante = new Restaurante("Restaurante A", endereco, "Italiana", horarioFuncionamento, 100, 50);
        reserva = new Reserva(cliente, restaurante, horario, data, 4);
    }

    @Test
    public void testGetReservas() {
        when(listarReservas.listarReservas(any(Cliente.class))).thenReturn(Collections.singletonList(reserva));

        List<ReservaDTO> result = reservaController.getReservas(reservaDTO.cliente());

        assertEquals(1, result.size());
        assertEquals(reservaDTO.cliente().cpf(), result.get(0).cliente().cpf());
        verify(listarReservas, times(1)).listarReservas(any(Cliente.class));
    }

    @Test
    public void testFazerReserva() {
        when(realizarReserva.realizarReserva(any(Reserva.class))).thenReturn(reserva);

        ReservaDTO result = reservaController.fazerReserva(reservaDTO);

        assertEquals(reservaDTO.cliente().cpf(), result.cliente().cpf());
        verify(realizarReserva, times(1)).realizarReserva(any(Reserva.class));
    }

    @Test
    public void testAlterarData() {
        when(alterarDataReserva.alterarDataReserva(any(Reserva.class))).thenReturn(reserva);

        ReservaDTO result = reservaController.alterarData(reservaDTO);

        assertEquals(reservaDTO.data(), result.data());
        verify(alterarDataReserva, times(1)).alterarDataReserva(any(Reserva.class));
    }

    @Test
    public void testAlterarHora() {
        when(alterarHorarioReserva.alterarHorarioReserva(any(Reserva.class))).thenReturn(reserva);

        ReservaDTO result = reservaController.alterarHora(reservaDTO);

        assertEquals(reservaDTO.horario(), result.horario());
        verify(alterarHorarioReserva, times(1)).alterarHorarioReserva(any(Reserva.class));
    }

    @Test
    public void testExcluirReserva() {
        doNothing().when(cancelarReserva).cancelarReserva(any(Reserva.class));

        reservaController.excluirReserva(reservaDTO);

        verify(cancelarReserva, times(1)).cancelarReserva(any(Reserva.class));
    }
}
