package com.grupo19.gastroreserva.infra.persistence.avaliacao;

import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, Long> {
    List<AvaliacaoEntity> findByCliente(ClienteEntity clienteEntity);

}