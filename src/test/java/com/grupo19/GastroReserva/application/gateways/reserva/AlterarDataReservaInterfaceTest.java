package com.grupo19.GastroReserva.application.gateways.reserva;

import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AlterarDataReservaInterfaceTest {
    @Mock
    private AlterarDataReservaInterface alterarDataReservaInterface;

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
    public void deveAlterarDataReservaComSucesso() {
        Reserva reserva = new Reserva();
        reserva.setData(LocalDate.of(2024, 9, 15));

        when(alterarDataReservaInterface.alterarDataReserva(reserva)).thenAnswer(invocation -> {
            Reserva r = invocation.getArgument(0);
            r.setData(LocalDate.of(2024, 10, 1));
            return r;
        });

        Reserva reservaAlterada = alterarDataReservaInterface.alterarDataReserva(reserva);
        assertEquals(LocalDate.of(2024, 10, 1), reservaAlterada.getData());
    }
}
