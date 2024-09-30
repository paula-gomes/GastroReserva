package com.grupo19.gastroreserva.unit.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.AlterarHorarioReservaInterface;
import com.grupo19.gastroreserva.application.usecases.reserva.AlterarHorarioReserva;
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

class AlterarHorarioReservaTest {
    @Test
    void test_alterar_horario_reserva_success() {
        AlterarHorarioReservaInterface mockInterface = mock(AlterarHorarioReservaInterface.class);
        AlterarHorarioReserva alterarHorarioReserva = new AlterarHorarioReserva(mockInterface);

        Cliente cliente = new Cliente();
        Restaurante restaurante = new Restaurante();
        restaurante.setCapacidade(50);
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(9, 0), LocalTime.of(22, 0)));
        Reserva reserva = new Reserva(cliente, restaurante, LocalTime.of(12, 0), LocalDate.now(), 4);

        when(mockInterface.alterarHorarioReserva(reserva)).thenReturn(reserva);

        Reserva result = alterarHorarioReserva.alterarHorarioReserva(reserva);

        assertNotNull(result);
        assertEquals(reserva, result);
    }
}
