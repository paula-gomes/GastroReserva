package com.grupo19.gastroreserva.infra.controller.reserva;

import com.grupo19.gastroreserva.application.usecases.reserva.*;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final AlterarDataReserva alterarDataReserva;
    private final AlterarHorarioReserva alterarHorarioReserva;
    private final CancelarReserva cancelarReserva;
    private final RealizarReserva realizarReserva;
    private final ListarReservas listarReservas;

    public ReservaController(AlterarDataReserva alterarDataReserva, AlterarHorarioReserva alterarHorarioReserva, CancelarReserva cancelarReserva, RealizarReserva realizarReserva, ListarReservas listarReservas) {
        this.alterarDataReserva = alterarDataReserva;
        this.alterarHorarioReserva = alterarHorarioReserva;
        this.cancelarReserva = cancelarReserva;
        this.realizarReserva = realizarReserva;
        this.listarReservas = listarReservas;
    }

    @GetMapping
    public List<ReservaDTO> getReservas(@RequestBody ClienteDTO clienteDTO){
        List<ReservaDTO> reservas = new ArrayList<>();
        listarReservas.listarReservas(new Cliente(clienteDTO.cpf(), clienteDTO.nome(), clienteDTO.email()))
                .forEach(reserva -> reservas.add(new ReservaDTO(
                        reserva.getCliente(),
                        reserva.getRestaurante(),
                        reserva.getHorario(),
                        reserva.getData(),
                        reserva.getQuantidade())));

        return reservas;
    }

    @PostMapping
    public ReservaDTO fazerReserva(@RequestBody ReservaDTO reservaDTO){
        Reserva reservaFeita = realizarReserva.realizarReserva(new Reserva(reservaDTO.cliente(),
                reservaDTO.restaurante(),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
        return new ReservaDTO(reservaFeita.getCliente(),
                reservaFeita.getRestaurante(),
                reservaFeita.getHorario(),
                reservaFeita.getData(),
                reservaFeita.getQuantidade());
    }

    @PostMapping("/data")
    public ReservaDTO alterarData(@RequestBody ReservaDTO reservaDTO){
        Reserva reservaFeita = alterarDataReserva.alterarDataReserva(new Reserva(reservaDTO.cliente(),
                reservaDTO.restaurante(),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
        return new ReservaDTO(reservaFeita.getCliente(),
                reservaFeita.getRestaurante(),
                reservaFeita.getHorario(),
                reservaFeita.getData(),
                reservaFeita.getQuantidade());
    }

    @PostMapping("/hora")
    public ReservaDTO alterarHora(@RequestBody ReservaDTO reservaDTO){
        Reserva reservaFeita = alterarHorarioReserva.alterarHorarioReserva(new Reserva(reservaDTO.cliente(),
                reservaDTO.restaurante(),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
        return new ReservaDTO(reservaFeita.getCliente(),
                reservaFeita.getRestaurante(),
                reservaFeita.getHorario(),
                reservaFeita.getData(),
                reservaFeita.getQuantidade());
    }

    @DeleteMapping
    public void excluirReserva(@RequestBody ReservaDTO reservaDTO){
        cancelarReserva.cancelarReserva(new Reserva(reservaDTO.cliente(),
                reservaDTO.restaurante(),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
    }

}
