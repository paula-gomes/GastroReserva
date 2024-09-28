package com.grupo19.gastroreserva.unit.application.gateways.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

class ExcluirClienteInterfaceTest {
        @Mock
        private ExcluirClienteInterface excluirClienteInterface;
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
        void deveChamarExcluirCliente() {

            Cliente cliente = new Cliente();
            cliente.setNome("NomeCliente");
            cliente.setEmail("cliente@email.com");

            excluirClienteInterface.excluirCliente(cliente);

            verify(excluirClienteInterface).excluirCliente(cliente);
        }
}

