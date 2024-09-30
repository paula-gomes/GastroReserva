package com.grupo19.gastroreserva.unit.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.RealizarReservaInterface;
import com.grupo19.gastroreserva.application.usecases.reserva.RealizarReserva;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

 class RealizarReservaTest {
    @Test
     void deveRealizarReserva() {
        RealizarReservaInterface mockInterface = mock(RealizarReservaInterface.class);
        RealizarReserva realizarReserva = new RealizarReserva(mockInterface);

        Cliente cliente = new Cliente();
        Restaurante restaurante = new Restaurante();
        restaurante.setCapacidade(10);
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(9, 0), LocalTime.of(22, 0)));
        LocalTime horario = LocalTime.of(12, 0);
        LocalDate data = LocalDate.of(2023, 10, 10);
        Integer quantidade = 5;

        Reserva reserva = new Reserva(cliente, restaurante, horario, data, quantidade);
        when(mockInterface.realizarReserva(reserva)).thenReturn(reserva);

        Reserva result = realizarReserva.realizarReserva(reserva);

        assertNotNull(result);
        assertEquals(cliente, result.getCliente());
        assertEquals(restaurante, result.getRestaurante());
        assertEquals(horario, result.getHorario());
        assertEquals(data, result.getData());
        assertEquals(quantidade, result.getQuantidade());
    }
}
