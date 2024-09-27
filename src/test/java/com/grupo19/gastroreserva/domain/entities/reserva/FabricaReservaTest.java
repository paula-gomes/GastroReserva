package com.grupo19.gastroreserva.domain.entities.reserva;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FabricaReservaTest {

    @Test
    public void deveRealizarReservaComFabricasDeReserva(){
        FabricaReserva fabrica = new FabricaReserva();
        Cliente cliente = new Cliente("123.456.789-10", "nomeCliente", "email@teste.com");
        Endereco endereco = new Endereco("12345-123", "logradouro", "12", "bairro", "cidade", "SP");
        HorarioDeFuncionamento horarioDeFuncionamento = new HorarioDeFuncionamento(LocalTime.of(9, 0), LocalTime.of(18, 0));
        Restaurante restaurante = new Restaurante("Restaurante Teste", endereco, "Italiana", horarioDeFuncionamento, 50, 100);
        LocalTime horario = LocalTime.of(17, 30);
        LocalDate data = LocalDate.of(2024, 9, 14);

        Reserva reserva = fabrica.fazerReserva(cliente, restaurante, horario, data, 4);

        assertNotNull(reserva);
        assertEquals(cliente, reserva.getCliente());
        assertEquals(restaurante, reserva.getRestaurante());
        assertEquals(horario, reserva.getHorario());
        assertEquals(data, reserva.getData());
        assertEquals(4, reserva.getQuantidade());

    }
    @Test
    public void deveAlterarData() {
        Cliente cliente = mock(Cliente.class);
        Restaurante restaurante = mock(Restaurante.class);
        HorarioDeFuncionamento horarioDeFuncionamento = mock(HorarioDeFuncionamento.class);
        LocalTime horario = LocalTime.of(12, 0);
        LocalDate data = LocalDate.of(2023, 10, 10);
        Integer quantidade = 4;

        when(restaurante.getCapacidade()).thenReturn(10);
        when(restaurante.getHorarioDeFuncionamento()).thenReturn(horarioDeFuncionamento);
        when(horarioDeFuncionamento.getHoraAbertura()).thenReturn(LocalTime.of(9, 0));
        when(horarioDeFuncionamento.getHoraFechamento()).thenReturn(LocalTime.of(22, 0));

        FabricaReserva fabricaReserva = new FabricaReserva();
        Reserva reserva = fabricaReserva.fazerReserva(cliente, restaurante, horario, data, quantidade);

        LocalTime novoHorario = LocalTime.of(14, 0);
        Reserva reservaAlterada = fabricaReserva.alterarHorario(novoHorario);

        assertNotNull(reserva);
        assertEquals(novoHorario, reservaAlterada.getHorario());
    }

    @Test
    public void deveAlterarDataUtilizandoFabricaReserva() {
        FabricaReserva fabrica = new FabricaReserva();

        LocalDate dataReserva = LocalDate.of(2024,9,24);
        Cliente cliente = mock(Cliente.class);
        Restaurante restaurante = mock(Restaurante.class);
        HorarioDeFuncionamento horarioDeFuncionamento = mock(HorarioDeFuncionamento.class);
        LocalTime horario = LocalTime.of(12, 0);
        LocalDate data = LocalDate.of(2023, 10, 10);
        Integer quantidade = 4;


        when(restaurante.getHorarioDeFuncionamento()).thenReturn(horarioDeFuncionamento);
        when(horarioDeFuncionamento.getHoraAbertura()).thenReturn(LocalTime.of(9, 0));
        when(horarioDeFuncionamento.getHoraFechamento()).thenReturn(LocalTime.of(22, 0));
        when(restaurante.getCapacidade()).thenReturn(100);

        if (quantidade > restaurante.getCapacidade()) {
            throw new IllegalArgumentException("Quantidade excede a capacidade do restaurante");
        }

        Reserva reserva = fabrica.fazerReserva(cliente, restaurante, horario, data, quantidade);
        Reserva reservaAlterada = fabrica.alterarData(dataReserva);
        assertNotNull(reserva);
        assertEquals(dataReserva, reservaAlterada.getData());
    }

    @Test
    public void deveAlterarQuantidadeDaReserva() {
        FabricaReserva fabrica = new FabricaReserva();

        Cliente cliente = mock(Cliente.class);
        Restaurante restaurante = mock(Restaurante.class);
        HorarioDeFuncionamento horarioDeFuncionamento = mock(HorarioDeFuncionamento.class);
        LocalTime horario = LocalTime.of(12, 0);
        LocalDate data = LocalDate.of(2023, 10, 10);
        Integer quantidadeInicial = 4;
        Integer novaQuantidade = 6;

        when(restaurante.getHorarioDeFuncionamento()).thenReturn(horarioDeFuncionamento);
        when(horarioDeFuncionamento.getHoraAbertura()).thenReturn(LocalTime.of(9, 0));
        when(horarioDeFuncionamento.getHoraFechamento()).thenReturn(LocalTime.of(22, 0));
        when(restaurante.getCapacidade()).thenReturn(100);

        Reserva reserva = fabrica.fazerReserva(cliente, restaurante, horario, data, quantidadeInicial);
        Reserva reservaAlterada = fabrica.alterarQuantidade(novaQuantidade);

        assertNotNull(reserva);
        assertEquals(novaQuantidade, reservaAlterada.getQuantidade());
    }

    @Test
    public void deveCancelarReserva() {
        FabricaReserva fabrica = new FabricaReserva();

        Cliente cliente = mock(Cliente.class);
        Restaurante restaurante = mock(Restaurante.class);
        HorarioDeFuncionamento horarioDeFuncionamento = mock(HorarioDeFuncionamento.class);
        LocalTime horario = LocalTime.of(12, 0);
        LocalDate data = LocalDate.of(2023, 10, 10);
        Integer quantidade = 4;

        when(restaurante.getHorarioDeFuncionamento()).thenReturn(horarioDeFuncionamento);
        when(horarioDeFuncionamento.getHoraAbertura()).thenReturn(LocalTime.of(9, 0));
        when(horarioDeFuncionamento.getHoraFechamento()).thenReturn(LocalTime.of(22, 0));
        when(restaurante.getCapacidade()).thenReturn(100);

        Reserva reserva = fabrica.fazerReserva(cliente, restaurante, horario, data, quantidade);
        Reserva reservaCancelada = fabrica.cancelarReserva();


        assertNotNull(reserva);
        assertNull(reservaCancelada);
    }

}
