/*
package com.grupo19.gastroreserva.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.avaliacao.AvaliacaoDTO;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import com.grupo19.gastroreserva.infra.controller.restaurante.RestauranteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AvaliacaoConfigTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private AvaliacaoDTO avaliacaoDTO;

    @BeforeEach
    void setUp() {
        // Criar um cliente com dados válidos
        Cliente cliente = new Cliente("123.456.789-10", "Cliente Nome", "email@teste.com");

        // Criar um restaurante com dados válidos
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Exemplo");
        restaurante.setEndereco(new Endereco("Rua Exemplo", "123", "Bairro Exemplo", "Cidade Exemplo", "Estado Exemplo", "00000-000"));
        restaurante.setTipoDeCozinha("Italiana");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8, 0), LocalTime.of(22, 0)));
        restaurante.setCapacidade(100);
        restaurante.setCadeirasDisponiveis(50);
        restaurante.ocuparCadeiras(10); // Simulando a ocupação de 10 cadeiras

        // Configuração inicial do objeto AvaliacaoDTO
        avaliacaoDTO = new AvaliacaoDTO(cliente, restaurante, 5, "Excelente", LocalDate.parse("2024-09-26"));
    }

    @Test
    void testRealizarAvaliacao() throws Exception {
        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-10", "Cliente Nome", "email@teste.com");
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco(new Endereco());
        restaurante.setTipoDeCozinha("Italiana");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8,0), LocalTime.of(22,0)));
        restaurante.setCapacidade(100);
        restaurante.setCadeirasDisponiveis(50);


        RestauranteDTO restauranteDTO = new RestauranteDTO("Restaurante Exemplo",
                new Endereco("Rua Exemplo", "123", "Bairro Exemplo", "Cidade Exemplo", "Estado Exemplo", "00000-000"),
                "Italiana", LocalTime.of(9, 0), LocalTime.of(22, 0), 100);


        mockMvc.perform(post("/avaliacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(avaliacaoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cliente.cpf").value(avaliacaoDTO.cliente().cpf()))
                .andExpect(jsonPath("$.cliente.nome").value(avaliacaoDTO.cliente().nome()))
                .andExpect(jsonPath("$.restaurante.nome").value(avaliacaoDTO.restaurante().nome()))
                .andExpect(jsonPath("$.nota").value(avaliacaoDTO.nota()))
                .andExpect(jsonPath("$.comentario").value(avaliacaoDTO.comentario()));
    }

    @Test
    void testGetAvaliacoes() throws Exception {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco(new Endereco());
        restaurante.setTipoDeCozinha("Italiana");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8,0), LocalTime.of(22,0)));
        restaurante.setCapacidade(100);
        restaurante.setCadeirasDisponiveis(50);

        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-00", "Cliente Teste", "cliente@teste.com", List.of(restaurante));
        mockMvc.perform(get("/avaliacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testEditarAvaliacao() throws Exception {
        // Criação do Cliente
        Cliente cliente = new Cliente("123.456.789-10", "Cliente Nome", "email@teste.com");

        // Criação do Restaurante
        Restaurante restaurante = new Restaurante();
        restaurante.setNome("Restaurante Teste");
        restaurante.setEndereco(new Endereco());
        restaurante.setTipoDeCozinha("Italiana");
        restaurante.setHorarioDeFuncionamento(new HorarioDeFuncionamento(LocalTime.of(8,0), LocalTime.of(22,0)));
        restaurante.setCapacidade(100);
        restaurante.setCadeirasDisponiveis(50);

        // Criação do AvaliacaoDTO
        AvaliacaoDTO avaliacaoAlterada = new AvaliacaoDTO(cliente, restaurante, 4, "Boa", LocalDate.parse("2024-09-26"));

        // Executa a requisição
        mockMvc.perform(post("/avaliacao/alterar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(avaliacaoAlterada)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nota").value(avaliacaoAlterada.nota()))
                .andExpect(jsonPath("$.comentario").value(avaliacaoAlterada.comentario()));
    }

    @Test
    void testExcluirAvaliacao() throws Exception {
        mockMvc.perform(delete("/avaliacao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(avaliacaoDTO)))
                .andExpect(status().isOk());
    }

}
*/
