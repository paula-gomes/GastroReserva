package com.grupo19.gastroreserva.infra.gateways.cliente;

import com.grupo19.gastroreserva.application.gateways.cliente.AlterarEmailClienteInterface;
import com.grupo19.gastroreserva.application.gateways.cliente.CadastrarClienteInterface;
import com.grupo19.gastroreserva.application.gateways.cliente.ExcluirClienteInterface;
import com.grupo19.gastroreserva.application.gateways.cliente.ListarClientesInterface;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteEntity;
import com.grupo19.gastroreserva.infra.persistence.cliente.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDeClienteJpa implements AlterarEmailClienteInterface, CadastrarClienteInterface, ExcluirClienteInterface, ListarClientesInterface {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    public RepositorioDeClienteJpa(ClienteRepository clienteRepository, ClienteMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }


    @Override
    public Cliente alterarEmailCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        clienteRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        clienteRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public void excluirCliente(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        clienteRepository.delete(entity);
    }

    @Override
    public List<Cliente> listarClientes() {
        List<ClienteEntity> entities = clienteRepository.findAll();
        List<Cliente> domains = new ArrayList<>();
        entities.forEach(entity -> domains.add(mapper.toDomain(entity)));
        return domains;
    }
}
