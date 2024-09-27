package com.grupo19.gastroreserva.infra.controller.restaurante;

import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;

public record RestauranteDTO(
        String nome,
        Endereco endereco,
        String tipoDeCozinha,
        HorarioDeFuncionamento horarioDeFuncionamento,
        Integer capacidade,
        Integer cadeirasDisponiveis
) {
}
