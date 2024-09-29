package com.grupo19.gastroreserva.integration.infra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo19.gastroreserva.application.usecases.reserva.AlterarDataReserva;
import com.grupo19.gastroreserva.application.usecases.reserva.AlterarHorarioReserva;
import com.grupo19.gastroreserva.application.usecases.reserva.ListarReservas;
import com.grupo19.gastroreserva.application.usecases.reserva.RealizarReserva;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import com.grupo19.gastroreserva.infra.controller.reserva.ReservaDTO;
import com.grupo19.gastroreserva.infra.controller.restaurante.RestauranteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReservaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ListarReservas listarReservas;
    @MockBean
    private RealizarReserva realizarReserva;
    @MockBean
    private AlterarDataReserva alterarDataReserva;
    @MockBean
    private AlterarHorarioReserva alterarHorarioReserva;


    @Test
    void deveRestornarReservas() throws Exception {
        Endereco endereco = new Endereco("11111-111", "logradouro", "10", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento(horaAbertura, horaFechamento);
        RestauranteDTO restauranteDTO = new RestauranteDTO("Restaurante A", endereco, "Italiana", horario, 50, 20);
        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-10", "João", "joao@example.com", new ArrayList<>());

        int quantidadeReservada = 4;
        Reserva reserva = new Reserva(new Cliente(clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.email()),
                new Restaurante(restauranteDTO.nome(), restauranteDTO.endereco(), restauranteDTO.tipoDeCozinha(), restauranteDTO.horarioDeFuncionamento(), restauranteDTO.capacidade(), restauranteDTO.cadeirasDisponiveis()),
                LocalTime.of(16, 0), LocalDate.now(), quantidadeReservada);

        RestauranteDTO restauranteAtualizado = new RestauranteDTO(
                restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(),
                restauranteDTO.capacidade(),
                restauranteDTO.cadeirasDisponiveis() - quantidadeReservada
        );

        List<ReservaDTO> reservasMock = Arrays.asList(new ReservaDTO(clienteDTO, restauranteAtualizado, LocalTime.of(16, 0), LocalDate.now(), quantidadeReservada));

        when(listarReservas.listarReservas(any(Cliente.class))).thenReturn(Arrays.asList(reserva));

        mockMvc.perform(get("/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clienteDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(reservasMock)));
    }





    @Test
    void deveFazerReservas() throws Exception {
        Endereco endereco = new Endereco("11111-111", "logradouro", "10", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento(horaAbertura, horaFechamento);
        RestauranteDTO restauranteDTO = new RestauranteDTO("Restaurante A", endereco, "Italiana", horario, 50, 20);
        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-10", "João", "joao@example.com", new ArrayList<>());

        int quantidadeReservada = 4;
              // Criar a reserva
        Reserva reserva = new Reserva(new Cliente(clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.email()),
                new Restaurante(restauranteDTO.nome(), restauranteDTO.endereco(), restauranteDTO.tipoDeCozinha(), restauranteDTO.horarioDeFuncionamento(), restauranteDTO.capacidade(), restauranteDTO.cadeirasDisponiveis()),
                LocalTime.of(16, 0), LocalDate.now(), quantidadeReservada);

        RestauranteDTO restauranteAtualizado = new RestauranteDTO(
                restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(),
                restauranteDTO.capacidade(),
                restauranteDTO.cadeirasDisponiveis() - quantidadeReservada
        );

        // Mockando a chamada ao serviço
        when(realizarReserva.realizarReserva(any(Reserva.class))).thenReturn(reserva);

        // Criar o DTO da reserva
        ReservaDTO reservaDTO = new ReservaDTO(clienteDTO, restauranteAtualizado, LocalTime.of(16, 0), LocalDate.now(), quantidadeReservada);

        // Executando a requisição e verificando o resultado
        mockMvc.perform(post("/reservas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(new ReservaDTO(
                        clienteDTO,
                        new RestauranteDTO(restauranteDTO.nome(), restauranteDTO.endereco(), restauranteDTO.tipoDeCozinha(), restauranteDTO.horarioDeFuncionamento(), restauranteDTO.capacidade(), restauranteAtualizado.cadeirasDisponiveis()),
                        LocalTime.of(16, 0),
                        LocalDate.now(),
                        quantidadeReservada
                ))));
    }

    @Test
    void deveAlterarDataReserva() throws Exception {
        Endereco endereco = new Endereco("11111-111", "logradouro", "10", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento(horaAbertura, horaFechamento);
        RestauranteDTO restauranteDTO = new RestauranteDTO("Restaurante A", endereco, "Italiana", horario, 50, 20);
        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-10", "João", "joao@example.com", new ArrayList<>());

        LocalTime novaHora = LocalTime.of(17, 0);
        LocalDate novaData = LocalDate.now().plusDays(1);
        int quantidadeReservada = 20;
        Reserva reserva = new Reserva(new Cliente(clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.email()),
                new Restaurante(restauranteDTO.nome(), restauranteDTO.endereco(), restauranteDTO.tipoDeCozinha(), restauranteDTO.horarioDeFuncionamento(), restauranteDTO.capacidade(), restauranteDTO.cadeirasDisponiveis()),
                novaHora, novaData, quantidadeReservada);

        when(alterarDataReserva.alterarDataReserva(any(Reserva.class))).thenReturn(reserva);

        int cadeirasRestantes = restauranteDTO.cadeirasDisponiveis() - quantidadeReservada;
        RestauranteDTO restauranteAtualizado = new RestauranteDTO(
                restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(),
                restauranteDTO.capacidade(),
                cadeirasRestantes
        );

        ReservaDTO reservaDTO = new ReservaDTO(clienteDTO, restauranteDTO, LocalTime.of(16, 0), LocalDate.now(), restauranteDTO.cadeirasDisponiveis());

           mockMvc.perform(post("/reservas/data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(new ReservaDTO(
                        clienteDTO,
                        restauranteAtualizado,  // Use o restaurante atualizado
                        novaHora,
                        novaData,
                        quantidadeReservada
                ))));
    }

    @Test
    void deveAlterarHoraReserva() throws Exception {
        Endereco endereco = new Endereco("11111-111", "logradouro", "10", "bairro", "cidade", "SP");
        LocalTime horaAbertura = LocalTime.of(9, 0);
        LocalTime horaFechamento = LocalTime.of(18, 0);
        HorarioDeFuncionamento horario = new HorarioDeFuncionamento(horaAbertura, horaFechamento);

        int cadeirasDisponiveis = 20;
        int quantidadeReservada = 4;

        RestauranteDTO restauranteDTO = new RestauranteDTO("Restaurante A", endereco, "Italiana", horario, 50, cadeirasDisponiveis);
        ClienteDTO clienteDTO = new ClienteDTO("123.456.789-10", "João", "joao@example.com", new ArrayList<>());

        LocalTime novaHora = LocalTime.of(17, 0);
        LocalDate dataAtual = LocalDate.now();

        Restaurante restaurante = new Restaurante(
                restauranteDTO.nome(), restauranteDTO.endereco(), restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(), restauranteDTO.capacidade(), cadeirasDisponiveis
        );

        Reserva reserva = new Reserva(
                new Cliente(clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.email()),
                restaurante,
                novaHora, dataAtual, quantidadeReservada
        );

        when(alterarHorarioReserva.alterarHorarioReserva(any(Reserva.class))).thenReturn(reserva);

        int cadeirasRestantes = restauranteDTO.cadeirasDisponiveis() - quantidadeReservada;
        RestauranteDTO restauranteAtualizado = new RestauranteDTO(
                restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(),
                restauranteDTO.capacidade(),
                cadeirasRestantes
        );

        ReservaDTO reservaDTO = new ReservaDTO(clienteDTO, restauranteDTO, LocalTime.of(16, 0), dataAtual, quantidadeReservada);

        mockMvc.perform(post("/reservas/hora")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reservaDTO)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(new ReservaDTO(
                        clienteDTO,
                        restauranteAtualizado,
                        novaHora,
                        dataAtual,
                        quantidadeReservada
                ))));
    }



}