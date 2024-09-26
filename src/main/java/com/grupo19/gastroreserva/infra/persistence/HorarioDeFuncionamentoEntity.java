package com.grupo19.gastroreserva.infra.persistence;

import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;

@Data
@Table(name = "endereco")
public class HorarioDeFuncionamentoEntity {
    private LocalTime horaAbertura;
    private LocalTime horaFechamento;
}
