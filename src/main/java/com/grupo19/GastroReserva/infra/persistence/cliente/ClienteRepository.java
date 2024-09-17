package com.grupo19.GastroReserva.infra.persistence.cliente;

import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
