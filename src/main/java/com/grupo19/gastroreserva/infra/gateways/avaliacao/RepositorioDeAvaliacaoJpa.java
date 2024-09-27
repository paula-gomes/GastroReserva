package com.grupo19.gastroreserva.infra.gateways.avaliacao;

import com.grupo19.gastroreserva.application.gateways.avaliacao.EditarAvaliacaoInterface;
import com.grupo19.gastroreserva.application.gateways.avaliacao.ExcluirAvaliacaoInterface;
import com.grupo19.gastroreserva.application.gateways.avaliacao.ListarAvaliacoesInterface;
import com.grupo19.gastroreserva.application.gateways.avaliacao.RealizarAvaliacaoInterface;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.gateways.cliente.ClienteMapper;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoEntity;
import com.grupo19.gastroreserva.infra.persistence.avaliacao.AvaliacaoRepository;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAvaliacaoJpa implements EditarAvaliacaoInterface, ExcluirAvaliacaoInterface, RealizarAvaliacaoInterface, ListarAvaliacoesInterface {

    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoMapper mapper;
    private final ClienteMapper clienteMapper;

    public RepositorioDeAvaliacaoJpa(AvaliacaoRepository avaliacaoRepository, AvaliacaoMapper mapper, ClienteMapper clienteMapper) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.mapper = mapper;
        this.clienteMapper = clienteMapper;
    }


    @Override
    public Avaliacao editarAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity entity = mapper.toEntity(avaliacao);
        avaliacaoRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public void excluirAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity entity = mapper.toEntity(avaliacao);
        avaliacaoRepository.delete(entity);
    }

    @Override
    public Avaliacao realizarAvaliacao(Avaliacao avaliacao) {
        AvaliacaoEntity entity = mapper.toEntity(avaliacao);
        avaliacaoRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Avaliacao> listarAvaliacoes(Cliente cliente) {
        List<Avaliacao> avaliacoes = new ArrayList<>();
        ClienteEntity clienteEntity = clienteMapper.toEntity(cliente);
        List<AvaliacaoEntity> avaliacaoEntity = avaliacaoRepository.findByCliente(clienteEntity);
        avaliacaoEntity.forEach(v -> avaliacoes.add(mapper.toDomain(v)));
        return avaliacoes;
    }
}
