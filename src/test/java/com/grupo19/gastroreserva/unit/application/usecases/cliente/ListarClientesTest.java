package com.grupo19.gastroreserva.unit.application.usecases.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.ListarClientesInterface;
import com.grupo19.gastroreserva.application.usecases.cliente.ListarClientes;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListarClientesTest {
    @Test
    public void deveListarClientes() {
        ListarClientesInterface listarClientesInterface = Mockito.mock(ListarClientesInterface.class);
        List<Cliente> expectedClientes = Arrays.asList(new Cliente("123.456.789-10", "John Doe", "john@example.com"));
        Mockito.when(listarClientesInterface.listarClientes()).thenReturn(expectedClientes);

        ListarClientes listarClientes = new ListarClientes(listarClientesInterface);
        List<Cliente> actualClientes = listarClientes.listarCliente();

        Assertions.assertEquals(expectedClientes, actualClientes);
    }

    @Test
    public void listarClientesNaoPodeSerNulo() {
        ListarClientesInterface listarClientesInterface = Mockito.mock(ListarClientesInterface.class);
        Mockito.when(listarClientesInterface.listarClientes()).thenReturn(null);

        ListarClientes listarClientes = new ListarClientes(listarClientesInterface);
        List<Cliente> actualClientes = listarClientes.listarCliente();

        Assertions.assertNull(actualClientes);
    }
}
