package com.grupo19.gastroreserva.application.gateways.reserva;

import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class CancelarReservaInterfaceTest {
    @Mock
    private CancelarReservaInterface cancelarReservaInterface;

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
    public void deveChamarCancelarReserva() {
        Reserva reserva = new Reserva();

        cancelarReservaInterface.cancelarReserva(reserva);

        verify(cancelarReservaInterface).cancelarReserva(reserva);
    }
}
