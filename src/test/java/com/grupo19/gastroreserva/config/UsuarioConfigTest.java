package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.usecases.cliente.AlterarEmailCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.CadastrarCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ExcluirCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ListarClientes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UsuarioConfigTest {
    @Autowired
    private AlterarEmailCliente alterarEmailCliente;

    @Autowired
    private CadastrarCliente cadastrarCliente;

    @Autowired
    private ExcluirCliente excluirCliente;

    @Autowired
    private ListarClientes listarClientes;

    @Test
    void contextLoads() {
        // Verifica se os beans foram injetados corretamente
        assertNotNull(alterarEmailCliente, "AlterarEmailCliente não foi criado.");
        assertNotNull(cadastrarCliente, "CadastrarCliente não foi criado.");
        assertNotNull(excluirCliente, "ExcluirCliente não foi criado.");
        assertNotNull(listarClientes, "ListarClientes não foi criado.");
    }
}
