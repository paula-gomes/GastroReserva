package com.grupo19.GastroReserva.infra.controller.cliente;

import com.grupo19.GastroReserva.application.usecases.cliente.AlterarEmailCliente;
import com.grupo19.GastroReserva.application.usecases.cliente.CadastrarCliente;
import com.grupo19.GastroReserva.application.usecases.cliente.ExcluirCliente;
import com.grupo19.GastroReserva.application.usecases.cliente.ListarClientes;
import com.grupo19.GastroReserva.domain.entities.cliente.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final AlterarEmailCliente alterarEmailCliente;
    private final CadastrarCliente cadastrarCliente;
    private final ExcluirCliente excluirCliente;
    private final ListarClientes listarClientes;

    public ClienteController(AlterarEmailCliente alterarEmailCliente, CadastrarCliente cadastrarCliente, ExcluirCliente excluirCliente, ListarClientes listarClientes) {
        this.alterarEmailCliente = alterarEmailCliente;
        this.cadastrarCliente = cadastrarCliente;
        this.excluirCliente = excluirCliente;
        this.listarClientes = listarClientes;
    }

    @PostMapping
    public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO dto) {
        Cliente salvo = cadastrarCliente.cadastrarCliente(new Cliente(dto.cpf(), dto.nome(), dto.email(), dto.restaurantes()));
        return new ClienteDTO(salvo.getCpf(), salvo.getNome(), salvo.getEmail(), salvo.getRestaurantes());
    }

    @PostMapping("/email")
    public ClienteDTO alterarEmailCliente(@RequestBody ClienteDTO dto) {
        Cliente salvo = alterarEmailCliente.alterarEmailCliente(new Cliente(dto.cpf(), dto.nome(), dto.email(), dto.restaurantes()));
        return new ClienteDTO(salvo.getCpf(), salvo.getNome(), salvo.getEmail(), salvo.getRestaurantes());
    }

    @DeleteMapping
    public void excluirCliente(@RequestBody ClienteDTO dto) {
        excluirCliente.excluirCliente(new Cliente(dto.cpf(), dto.nome(), dto.email(), dto.restaurantes()));
    }

    @GetMapping
    public List<ClienteDTO> listarClientes() {
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        listarClientes.listarCliente().forEach(v -> clientesDTO.add(new ClienteDTO(v.getCpf(), v.getNome(), v.getEmail(), v.getRestaurantes())));
        return clientesDTO;
    }
}
