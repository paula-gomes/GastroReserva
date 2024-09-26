package com.grupo19.gastroreserva.infra.gateways.restaurante;


import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.EnderecoMapper;
import com.grupo19.gastroreserva.infra.gateways.HorarioDeFuncionamentoMapper;
import com.grupo19.gastroreserva.infra.persistence.endereco.EnderecoEntity;
import com.grupo19.gastroreserva.infra.persistence.horarioDeFuncionamento.HorarioDeFuncionamentoEntity;
import com.grupo19.gastroreserva.infra.persistence.restaurante.RestauranteEntity;

public class RestauranteMapper {

    EnderecoMapper enderecoMapper = new EnderecoMapper();
    HorarioDeFuncionamentoMapper horarioMapper = new HorarioDeFuncionamentoMapper();

    public RestauranteEntity toEntity(Restaurante restaurante) {
        EnderecoEntity enderecoEntity = enderecoMapper.toEntity(restaurante.getEndereco());
        HorarioDeFuncionamentoEntity horarioDeFuncionamentoEntity = horarioMapper.toEntity(restaurante.getHorarioDeFuncionamento());
        return new RestauranteEntity(restaurante.getNome(),
                enderecoEntity,
                restaurante.getTipoDeCozinha(),
                horarioDeFuncionamentoEntity,
                restaurante.getCapacidade(),
                restaurante.getCadeirasDisponiveis());
    }


    public Restaurante toDomain(RestauranteEntity entity) {
        Endereco endereco = enderecoMapper.toDomain(entity.getEndereco());
        HorarioDeFuncionamento horario = horarioMapper.toDomain(entity.getHorarioDeFuncionamento());
        return new Restaurante(entity.getNome(),
                endereco,
                entity.getTipoDeCozinha(),
                horario,
                entity.getCapacidade(),
                entity.getCadeirasDisponiveis());
    }
}
