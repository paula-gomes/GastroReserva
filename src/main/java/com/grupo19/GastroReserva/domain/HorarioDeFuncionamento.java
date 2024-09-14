package com.grupo19.GastroReserva.domain;

import java.time.LocalTime;

public class HorarioDeFuncionamento {
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;

    public HorarioDeFuncionamento(LocalTime horaAbertura, LocalTime horaFechamento) {
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
    }

    public HorarioDeFuncionamento() {

    }

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }
}
