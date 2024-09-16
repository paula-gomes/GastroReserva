package com.grupo19.GastroReserva.application.usecases.reserva;

import com.grupo19.GastroReserva.application.gateways.reserva.CancelarReservaInterface;
import com.grupo19.GastroReserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CancelarReservaTest {
    @Test
    public void deveCancelarResserva() {
        CancelarReservaInterface mockInterface = mock(CancelarReservaInterface.class);
        CancelarReserva cancelarReserva = new CancelarReserva(mockInterface);
        Reserva reserva = new Reserva();

        cancelarReserva.cancelarReserva(reserva);

        verify(mockInterface, times(1)).cancelarReserva(reserva);
    }
}
