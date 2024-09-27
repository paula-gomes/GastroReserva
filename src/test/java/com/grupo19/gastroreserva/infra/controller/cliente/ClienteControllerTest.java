package com.grupo19.gastroreserva.infra.controller.cliente;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo19.gastroreserva.application.usecases.cliente.AlterarEmailCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.CadastrarCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ExcluirCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ListarClientes;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private CadastrarCliente cadastrarCliente;

    @MockBean
    private AlterarEmailCliente alterarEmailCliente;

    @MockBean
    private ExcluirCliente excluirCliente;

    @MockBean
    private ListarClientes listarClientes;
    private Cliente cliente;


    @BeforeEach
    void setup() {
        cliente = new Cliente("12345678901", "João Silva", "joao@gmail.com", Collections.emptyList());
    }

    @Test
    void deveCadastrarCliente() throws Exception {
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getEmail(), cliente.getRestaurantes());

        when(cadastrarCliente.cadastrarCliente(any(Cliente.class))).thenReturn(cliente);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf").value(cliente.getCpf()))
                .andExpect(jsonPath("$.nome").value(cliente.getNome()))
                .andExpect(jsonPath("$.email").value(cliente.getEmail()));
    }

    @Test
    void deveAlterarEmailCliente() throws Exception {
        Cliente clienteAtualizado = new Cliente(cliente.getCpf(), cliente.getNome(), "novoemail@gmail.com", cliente.getRestaurantes());
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getCpf(), cliente.getNome(), "novoemail@gmail.com", cliente.getRestaurantes());

        when(alterarEmailCliente.alterarEmailCliente(any(Cliente.class))).thenReturn(clienteAtualizado);

        mockMvc.perform(post("/clientes/email")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("novoemail@gmail.com"));
    }

    @Test
    void deveExcluirCliente() throws Exception {
        ClienteDTO clienteDTO = new ClienteDTO(cliente.getCpf(), cliente.getNome(), cliente.getEmail(), cliente.getRestaurantes());

        mockMvc.perform(delete("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void deveListarClientes() throws Exception {
        when(listarClientes.listarCliente()).thenReturn(Collections.singletonList(cliente));

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].cpf").value(cliente.getCpf()))
                .andExpect(jsonPath("$[0].nome").value(cliente.getNome()))
                .andExpect(jsonPath("$[0].email").value(cliente.getEmail()));
    }
}
