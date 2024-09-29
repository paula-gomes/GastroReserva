package com.grupo19.gastroreserva.integration.infra.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo19.gastroreserva.application.usecases.reserva.ListarReservas;
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

    @Test
    void getReservas_ReturnsListOfReservas() throws Exception {
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
}