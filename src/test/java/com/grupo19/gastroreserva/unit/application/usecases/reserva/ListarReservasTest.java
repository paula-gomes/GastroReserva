package com.grupo19.gastroreserva.unit.application.usecases.reserva;

import com.grupo19.gastroreserva.application.gateways.reserva.ListarReservasInterface;
import com.grupo19.gastroreserva.application.usecases.reserva.ListarReservas;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ListarReservasTest {

    @Mock
    private ListarReservasInterface listarReservasInterface;

    @InjectMocks
    private ListarReservas listarReservas;

    private Cliente cliente;
    private Reserva reserva1;
    private Reserva reserva2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cliente = new Cliente();
        reserva1 = new Reserva();
        reserva2 = new Reserva();
    }

    @Test
    void deveListarReservasParaCliente() {
        List<Reserva> reservasEsperadas = Arrays.asList(reserva1, reserva2);
        when(listarReservasInterface.listarReservas(cliente)).thenReturn(reservasEsperadas);

        List<Reserva> resultado = listarReservas.listarReservas(cliente);

        assertEquals(reservasEsperadas, resultado);
    }
}
