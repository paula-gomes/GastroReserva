package com.grupo19.gastroreserva.unit.domain.entities.reserva;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReservaTest {

    @Test
    public void deveRealizarReserva() {

        Cliente cliente = new Cliente("123.456.789-10", "nomeCliente", "email@teste.com");
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        HorarioDeFuncionamento horarioDeFuncionamento = new HorarioDeFuncionamento(LocalTime.of(9, 0), LocalTime.of(18, 0));
        LocalTime horario = LocalTime.of(17, 30);
        Restaurante restaurante = new Restaurante("Restaurante Teste", endereco, "Italiana", horarioDeFuncionamento, 50, 100);
        LocalDate data = LocalDate.of(2024, 9, 14);
        Reserva reserva = new Reserva(cliente, restaurante, horario, data, 4);

        assertNotNull(reserva);
        assertEquals(cliente, reserva.getCliente());
        assertEquals(restaurante, reserva.getRestaurante());
        assertEquals(horario, reserva.getHorario());
        assertEquals(data, reserva.getData());
        assertEquals(4, reserva.getQuantidade());

    }
}
