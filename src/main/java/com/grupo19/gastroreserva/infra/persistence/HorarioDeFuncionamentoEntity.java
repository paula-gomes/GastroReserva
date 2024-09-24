package com.grupo19.gastroreserva.infra.persistence;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioDeFuncionamentoEntity {
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;
}
