package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.gateways.reserva.*;
import com.grupo19.gastroreserva.application.usecases.reserva.*;
import com.grupo19.gastroreserva.infra.gateways.reserva.RepositorioDeReservaJpa;
import com.grupo19.gastroreserva.infra.gateways.reserva.ReservaMapper;
import com.grupo19.gastroreserva.infra.persistence.reserva.ReservaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaConfig {

    @Bean
    AlterarDataReserva alterarDataReserva(AlterarDataReservaInterface alterarDataReservaInterface) {
        return new AlterarDataReserva(alterarDataReservaInterface);
    }

    @Bean
    AlterarHorarioReserva alterarHorarioReserva(AlterarHorarioReservaInterface alterarHorarioReservaInterface) {
        return new AlterarHorarioReserva(alterarHorarioReservaInterface);
    }

    @Bean
    CancelarReserva cancelarReserva(CancelarReservaInterface cancelarReservaInterface) {
        return new CancelarReserva(cancelarReservaInterface);
    }

    @Bean
    ListarReservas listarReservas(ListarReservasInterface listarReservasInterface) {
        return new ListarReservas(listarReservasInterface);
    }

    @Bean
    RealizarReserva realizarReserva(RealizarReservaInterface realizarReservaInterface) {
        return new RealizarReserva(realizarReservaInterface);
    }

    @Bean
    RepositorioDeReservaJpa criaRepositorioDeReserva(ReservaRepository repositorioDeReserva, ReservaMapper mapper) {
        return new RepositorioDeReservaJpa(repositorioDeReserva, mapper);
    }

    @Bean
    ReservaMapper criarMapper(){ return new ReservaMapper(); }
}
