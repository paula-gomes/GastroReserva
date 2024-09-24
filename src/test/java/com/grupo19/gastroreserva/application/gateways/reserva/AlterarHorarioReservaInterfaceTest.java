package com.grupo19.gastroreserva.application.gateways.reserva;

import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AlterarHorarioReservaInterfaceTest {
    @Mock
    private AlterarHorarioReservaInterface alterarHorarioReservaInterface;

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
    void deveAlterarHorarioReservaComSucesso() {
        Reserva reserva = new Reserva();
        reserva.setHorario(LocalTime.of(18, 0));

        when(alterarHorarioReservaInterface.alterarHorarioReserva(reserva)).thenAnswer(invocation -> {
            Reserva r = invocation.getArgument(0);
            r.setHorario(LocalTime.of(20, 0));
            return r;
        });

        Reserva reservaAlterada = alterarHorarioReservaInterface.alterarHorarioReserva(reserva);

        assertEquals(LocalTime.of(20, 0), reservaAlterada.getHorario());
    }
}
