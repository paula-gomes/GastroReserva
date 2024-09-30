package com.grupo19.gastroreserva.unit.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.application.usecases.cliente.ExcluirCliente;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ExcluirClienteTest {
    @Mock
    private ExcluirClienteInterface excluirClienteInterface;

    @InjectMocks
    private ExcluirCliente excluirCliente;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
    }

    @Test
    void deveExcluirCliente() {
        excluirCliente.excluirCliente(cliente);

        verify(excluirClienteInterface, times(1)).excluirCliente(cliente);
    }
}
