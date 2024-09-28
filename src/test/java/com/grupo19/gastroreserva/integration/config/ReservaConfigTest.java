package com.grupo19.gastroreserva.integration.config;

import com.grupo19.gastroreserva.application.usecases.reserva.*;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ReservaConfigTest {
    @Autowired
    private AlterarDataReserva alterarDataReserva;

    @Autowired
    private AlterarHorarioReserva alterarHorarioReserva;

    @Autowired
    private CancelarReserva cancelarReserva;

    @Autowired
    private ListarReservas listarReservas;

    @Autowired
    private RealizarReserva realizarReserva;

    @Autowired
    private RepositorioDeReservaJpa repositorioDeReservaJpa;

    @Test
    void contextLoads() {
        assertNotNull(alterarDataReserva);
        assertNotNull(alterarHorarioReserva);
        assertNotNull(cancelarReserva);
        assertNotNull(listarReservas);
        assertNotNull(realizarReserva);
        assertNotNull(repositorioDeReservaJpa);
    }
}
