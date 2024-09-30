package com.grupo19.gastroreserva.infra.gateways;

import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.infra.persistence.horariodefuncionamento.HorarioDeFuncionamentoEntity;

public class HorarioDeFuncionamentoMapper {

    public HorarioDeFuncionamentoEntity toEntity(HorarioDeFuncionamento horarioDeFuncionamento) {
        return new HorarioDeFuncionamentoEntity(horarioDeFuncionamento.getHoraAbertura(),
                horarioDeFuncionamento.getHoraFechamento());
    }
    public HorarioDeFuncionamento toDomain(HorarioDeFuncionamentoEntity horarioDeFuncionamento) {
        return new HorarioDeFuncionamento(horarioDeFuncionamento.getHoraAbertura(),
                horarioDeFuncionamento.getHoraFechamento());
    }
}
