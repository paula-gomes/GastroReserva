package com.grupo19.gastroreserva.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.CancelarReservaInterface;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CancelarReservaTest {
    @Test
    void deveCancelarResserva() {
        CancelarReservaInterface mockInterface = mock(CancelarReservaInterface.class);
        CancelarReserva cancelarReserva = new CancelarReserva(mockInterface);
        Reserva reserva = new Reserva();

        cancelarReserva.cancelarReserva(reserva);

        verify(mockInterface, times(1)).cancelarReserva(reserva);
    }
}
