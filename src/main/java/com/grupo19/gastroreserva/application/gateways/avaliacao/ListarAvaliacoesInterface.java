package com.grupo19.gastroreserva.application.gateways.avaliacao;

import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;

import java.util.List;

public interface ListarAvaliacoesInterface {

    List<Avaliacao> listarAvaliacoes(Cliente cliente);
}
