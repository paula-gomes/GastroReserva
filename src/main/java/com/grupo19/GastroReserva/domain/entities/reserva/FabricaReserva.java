package com.grupo19.GastroReserva.domain.entities.reserva;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import com.grupo19.GastroReserva.domain.entities.restaurante.Restaurante;

import java.time.LocalDate;
import java.time.LocalTime;

public class FabricaReserva {

    private Reserva reserva;

    public Reserva fazerReserva(Cliente cliente, Restaurante restaurante, LocalTime horario, LocalDate data, Integer quantidade){
        reserva = new Reserva(cliente, restaurante, horario, data, quantidade);
        reserva.getRestaurante().setCadeirasDisponiveis(quantidade);
        reserva.getCliente().addRestaurante(restaurante);
        return reserva;
    }

    public Reserva alterarHorario(LocalTime horario){
        reserva.setHorario(horario);
        return reserva;
    }

    public Reserva alterarData(LocalDate data){
        reserva.setData(data);
        return reserva;
    }

    public Reserva alterarQuantidade(Integer quantidade){
        reserva.setQuantidade(quantidade);
        return reserva;
    }

    public Reserva cancelarReserva(){
        reserva = null;
        return reserva;
    }
}
