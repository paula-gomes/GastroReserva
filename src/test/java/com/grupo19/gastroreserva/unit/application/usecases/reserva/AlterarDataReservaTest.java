package com.grupo19.gastroreserva.unit.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.AlterarDataReservaInterface;
import com.grupo19.gastroreserva.application.usecases.reserva.AlterarDataReserva;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AlterarDataReservaTest {
    @Test
    void deveAlterarDataReserva() {
        AlterarDataReservaInterface mockInterface = mock(AlterarDataReservaInterface.class);
        Reserva reserva = new Reserva();
        reserva.setData(LocalDate.of(2023, 10, 10));

        when(mockInterface.alterarDataReserva(reserva)).thenReturn(reserva);

        AlterarDataReserva alterarDataReserva = new AlterarDataReserva(mockInterface);
        Reserva result = alterarDataReserva.alterarDataReserva(reserva);

        assertNotNull(result);
        assertEquals(LocalDate.of(2023, 10, 10), result.getData());
    }
}
