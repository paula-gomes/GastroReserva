package com.grupo19.GastroReserva.application.gateways.reserva;

import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RealizarReservaInterfaceTest {
    @Mock
    private RealizarReservaInterface realizarReservaInterface;

    private AutoCloseable openMocks;

    @BeforeEach
    void configurar() {
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void derrubar() throws Exception {
        if (openMocks != null) {
            openMocks.close();
        }
    }

    @Test
    public void deveRealizarReservaComSucesso() {
        Reserva reserva = new Reserva();
        reserva.setData(LocalDate.of(2024, 9, 15));
        reserva.setHorario(LocalTime.of(18, 0));

        when(realizarReservaInterface.realizarReserva(reserva)).thenReturn(reserva);

        Reserva reservaRealizada = realizarReservaInterface.realizarReserva(reserva);

        assertEquals(LocalDate.of(2024, 9, 15), reservaRealizada.getData());
        assertEquals(LocalTime.of(18, 0), reservaRealizada.getHorario());
    }
}
