package com.grupo19.gastroreserva.unit.infra.controller.reserva;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import com.grupo19.gastroreserva.infra.controller.reserva.ReservaDTO;
import com.grupo19.gastroreserva.infra.controller.restaurante.RestauranteDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaDTOTest {
    @Test
    public void testReservaDTOCreation() {
        ClienteDTO cliente = new ClienteDTO("12345678900", "João", "joao@email.com", null);
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        RestauranteDTO restaurante = new RestauranteDTO("Restaurante A", endereco, "Italiana", null, 100, 50);
        LocalTime horario = LocalTime.of(19, 0);
        LocalDate data = LocalDate.now();
        int quantidade = 4;

        ReservaDTO reservaDTO = new ReservaDTO(cliente, restaurante, horario, data, quantidade);

        assertEquals(cliente, reservaDTO.cliente());
        assertEquals(restaurante, reservaDTO.restaurante());
        assertEquals(horario, reservaDTO.horario());
        assertEquals(data, reservaDTO.data());
        assertEquals(quantidade, reservaDTO.quantidade());
    }
}
