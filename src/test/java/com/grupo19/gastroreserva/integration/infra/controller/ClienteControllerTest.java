package com.grupo19.gastroreserva.integration.infra.controller;

import com.grupo19.gastroreserva.application.usecases.cliente.AlterarEmailCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.CadastrarCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ExcluirCliente;
import com.grupo19.gastroreserva.application.usecases.cliente.ListarClientes;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteController;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ClienteControllerTest {

    private MockMvc mockMvc;


    private ClienteController clienteController;

    @Mock
    private CadastrarCliente cadastrarCliente;

    @Mock
    private AlterarEmailCliente alterarEmailCliente;

    @Mock
    private ExcluirCliente excluirCliente;

    @Mock
    private ListarClientes listarClientes;


    AutoCloseable mock;


    @BeforeEach
    void setup(){
        mock = MockitoAnnotations.openMocks(this);
        clienteController = new ClienteController(alterarEmailCliente, cadastrarCliente, excluirCliente, listarClientes);
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController)
                .build();
    }
    @AfterEach
    void tearDown() throws Exception{
        mock.close();
    }

    @Test
    void devePermitirCadastrarCliente() throws Exception {
        Cliente clienteTeste = new Cliente("123.456.789-10", "Cliente Exemplo", "cliente@example.com", new ArrayList<>());
        when(cadastrarCliente.cadastrarCliente(any(Cliente.class))).thenReturn(clienteTeste);

         String clienteJson = "{ \"cpf\": \"123.456.789-10\", \"nome\": \"Cliente Exemplo\", \"email\": \"cliente@example.com\", \"restaurantes\": [] }";

          mockMvc.perform(post("/clientes")
                        .contentType("application/json")
                        .content(clienteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf").value("123.456.789-10"))
                .andExpect(jsonPath("$.nome").value("Cliente Exemplo"))
                .andExpect(jsonPath("$.email").value("cliente@example.com"));
    }


    @Test
    void devePermitirAlterarEmailCliente() throws Exception {

        String cpf = "123.456.789-00";
        String nome = "Cliente Teste";
        String novoEmail = "novoemail@test.com";
        List<Restaurante> restaurantes = new ArrayList<>();

        ClienteDTO clienteDTO = new ClienteDTO(cpf, nome, novoEmail, restaurantes);

        Cliente clienteSalvo = new Cliente(cpf, nome, novoEmail, restaurantes);

        when(alterarEmailCliente.alterarEmailCliente(any(Cliente.class))).thenReturn(clienteSalvo);

        mockMvc.perform(post("/clientes/email")
                        .contentType("application/json")
                        .content("{\"cpf\": \"" + cpf + "\", \"nome\": \"" + nome + "\", \"email\": \"" + novoEmail + "\", \"restaurantes\": []}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf").value(cpf))
                .andExpect(jsonPath("$.nome").value(nome))
                .andExpect(jsonPath("$.email").value(novoEmail));
    }


    @Test
    void devePermitirExcluirCliente() throws Exception {
        String cpf = "123.456.789-00";
        String nome = "Cliente Teste";
        String email = "email@test.com";
        List<Restaurante> restaurantes = new ArrayList<>();

        ClienteDTO clienteDTO = new ClienteDTO(cpf, nome, email, restaurantes);

        doNothing().when(excluirCliente).excluirCliente(any(Cliente.class));

        mockMvc.perform(delete("/clientes")
                        .contentType("application/json")
                        .content("{\"cpf\": \"" + cpf + "\", \"nome\": \"" + nome + "\", \"email\": \"" + email + "\", \"restaurantes\": []}"))
                .andExpect(status().isOk());

    }

    @Test
    void devePermitirListarCliente() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        String cpf1 = "123.456.789-00";
        String nome1 = "Cliente Teste 1";
        String email1 = "cliente1@test.com";

        String cpf2 = "987.654.321-00";
        String nome2 = "Cliente Teste 2";
        String email2 = "cliente2@test.com";

        clientes.add(new Cliente(cpf1, nome1, email1));
        clientes.add(new Cliente(cpf2, nome2, email2));

        when(listarClientes.listarCliente()).thenReturn(clientes);

        mockMvc.perform(get("/clientes")
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].cpf").value(cpf1))
                .andExpect(jsonPath("$[1].cpf").value(cpf2));

    }


}
