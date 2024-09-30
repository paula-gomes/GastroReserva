package com.grupo19.gastroreserva.infra.controller.reserva;

import com.grupo19.gastroreserva.application.usecases.reserva.*;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.domain.entities.reserva.Reserva;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import com.grupo19.gastroreserva.infra.controller.restaurante.RestauranteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservas")
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
                        new ClienteDTO(reserva.getCliente().getCpf(),
                                reserva.getCliente().getNome(),
                                reserva.getCliente().getEmail(),
                                reserva.getCliente().getRestaurantes()),
                        new RestauranteDTO(reserva.getRestaurante().getNome(),
                                reserva.getRestaurante().getEndereco(),
                                reserva.getRestaurante().getTipoDeCozinha(),
                                reserva.getRestaurante().getHorarioDeFuncionamento(),
                                reserva.getRestaurante().getCapacidade(),
                                reserva.getRestaurante().getCadeirasDisponiveis()),
                        reserva.getHorario(),
                        reserva.getData(),
                        reserva.getQuantidade())));

        return reservas;
    }

    @PostMapping
    public ReservaDTO fazerReserva(@RequestBody ReservaDTO reservaDTO){
        Reserva reserva = realizarReserva.realizarReserva(new Reserva(
                new Cliente(
                        reservaDTO.cliente().cpf(),
                        reservaDTO.cliente().nome(),
                        reservaDTO.cliente().email()),
                new Restaurante(
                        reservaDTO.restaurante().nome(),
                        reservaDTO.restaurante().endereco(),
                        reservaDTO.restaurante().tipoDeCozinha(),
                        reservaDTO.restaurante().horarioDeFuncionamento(),
                        reservaDTO.restaurante().capacidade(),
                        reservaDTO.restaurante().cadeirasDisponiveis()),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
        return new ReservaDTO(
                new ClienteDTO(
                        reserva.getCliente().getCpf(),
                        reserva.getCliente().getNome(),
                        reserva.getCliente().getEmail(),
                        reserva.getCliente().getRestaurantes()),
                new RestauranteDTO(
                        reserva.getRestaurante().getNome(),
                        reserva.getRestaurante().getEndereco(),
                        reserva.getRestaurante().getTipoDeCozinha(),
                        reserva.getRestaurante().getHorarioDeFuncionamento(),
                        reserva.getRestaurante().getCapacidade(),
                        reserva.getRestaurante().getCadeirasDisponiveis()),
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    @PostMapping("/data")
    public ReservaDTO alterarData(@RequestBody ReservaDTO reservaDTO){
        Reserva reserva = alterarDataReserva.alterarDataReserva(new Reserva(
                new Cliente(
                        reservaDTO.cliente().cpf(),
                        reservaDTO.cliente().nome(),
                        reservaDTO.cliente().email()),
                new Restaurante(
                        reservaDTO.restaurante().nome(),
                        reservaDTO.restaurante().endereco(),
                        reservaDTO.restaurante().tipoDeCozinha(),
                        reservaDTO.restaurante().horarioDeFuncionamento(),
                        reservaDTO.restaurante().capacidade(),
                        reservaDTO.restaurante().cadeirasDisponiveis()),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
        return new ReservaDTO(
                new ClienteDTO(
                        reserva.getCliente().getCpf(),
                        reserva.getCliente().getNome(),
                        reserva.getCliente().getEmail(),
                        reserva.getCliente().getRestaurantes()),
                new RestauranteDTO(
                        reserva.getRestaurante().getNome(),
                        reserva.getRestaurante().getEndereco(),
                        reserva.getRestaurante().getTipoDeCozinha(),
                        reserva.getRestaurante().getHorarioDeFuncionamento(),
                        reserva.getRestaurante().getCapacidade(),
                        reserva.getRestaurante().getCadeirasDisponiveis()),
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    @PostMapping("/hora")
    public ReservaDTO alterarHora(@RequestBody ReservaDTO reservaDTO){
        Reserva reserva = alterarHorarioReserva.alterarHorarioReserva(new Reserva(
                new Cliente(
                        reservaDTO.cliente().cpf(),
                        reservaDTO.cliente().nome(),
                        reservaDTO.cliente().email()),
                new Restaurante(
                        reservaDTO.restaurante().nome(),
                        reservaDTO.restaurante().endereco(),
                        reservaDTO.restaurante().tipoDeCozinha(),
                        reservaDTO.restaurante().horarioDeFuncionamento(),
                        reservaDTO.restaurante().capacidade(),
                        reservaDTO.restaurante().cadeirasDisponiveis()),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
        return new ReservaDTO(
                new ClienteDTO(
                        reserva.getCliente().getCpf(),
                        reserva.getCliente().getNome(),
                        reserva.getCliente().getEmail(),
                        reserva.getCliente().getRestaurantes()),
                new RestauranteDTO(
                        reserva.getRestaurante().getNome(),
                        reserva.getRestaurante().getEndereco(),
                        reserva.getRestaurante().getTipoDeCozinha(),
                        reserva.getRestaurante().getHorarioDeFuncionamento(),
                        reserva.getRestaurante().getCapacidade(),
                        reserva.getRestaurante().getCadeirasDisponiveis()),
                reserva.getHorario(),
                reserva.getData(),
                reserva.getQuantidade());
    }

    @DeleteMapping
    public void excluirReserva(@RequestBody ReservaDTO reservaDTO){
        cancelarReserva.cancelarReserva(new Reserva(
                new Cliente(
                        reservaDTO.cliente().cpf(),
                        reservaDTO.cliente().nome(),
                        reservaDTO.cliente().email()),
                new Restaurante(
                        reservaDTO.restaurante().nome(),
                        reservaDTO.restaurante().endereco(),
                        reservaDTO.restaurante().tipoDeCozinha(),
                        reservaDTO.restaurante().horarioDeFuncionamento(),
                        reservaDTO.restaurante().capacidade(),
                        reservaDTO.restaurante().cadeirasDisponiveis()),
                reservaDTO.horario(),
                reservaDTO.data(),
                reservaDTO.quantidade()));
    }

}
