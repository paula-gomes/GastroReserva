package com.grupo19.GastroReserva.domain.entities.reserva;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;

public class FabricaReserva {

    private Reserva reserva;

    public Reserva fazerReserva(Cliente cliente, Restaurante restaurante, LocalTime horario, LocalDate data, Integer quantidade){
        reserva = new Reserva(cliente, restaurante, horario, data, quantidade);
        return reserva;
    }

    public Reserva alterarHorario(LocalTime horario){
        reserva.setHorario(horario);
        return reserva;
    }
}
