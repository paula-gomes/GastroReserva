package com.grupo19.gastroreserva.config;

import com.grupo19.gastroreserva.application.usecases.restaurante.AlterarEnderecoRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.CadastrarRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ExcluirRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ListarRestaurantes;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RepositorioDeRestauranteJpa;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RestauranteConfigTest {


    @Autowired
    private CadastrarRestaurante cadastrarRestaurante;

    @Autowired
    private ExcluirRestaurante excluirRestaurante;

    @Autowired
    private ListarRestaurantes listarRestaurantes;

    @Autowired
    private AlterarEnderecoRestaurante alterarEnderecoRestaurante;

    @Test
    @Transactional
    void deveCadastrarEListarRestaurante() {
        // Arrange
        Restaurante novoRestaurante = new Restaurante();
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero("123");
        novoRestaurante.setNome("Restaurante Teste");
        novoRestaurante.setEndereco(endereco);

        // Act - Cadastrar o restaurante
        cadastrarRestaurante.cadastrarRestaurante(novoRestaurante);

        // Act - Listar todos os restaurantes
        List<Restaurante> restaurantes = listarRestaurantes.listarRestaurantes();

        // Assert
        assertFalse(restaurantes.isEmpty(), "A lista de restaurantes não deve estar vazia.");
        assertTrue(restaurantes.stream().anyMatch(r -> r.getNome().equals("Restaurante Teste")),
                "Deve encontrar o restaurante cadastrado na lista.");
    }

    @Test
    @Transactional
    void deveExcluirRestaurante() {
        // Arrange
        Restaurante novoRestaurante = new Restaurante();
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Exclusão");
        endereco.setNumero("456");
        novoRestaurante.setNome("Restaurante para Exclusão");
        novoRestaurante.setEndereco(endereco);
        cadastrarRestaurante.cadastrarRestaurante(novoRestaurante);

        excluirRestaurante.excluirRestaurante(novoRestaurante);

        List<Restaurante> restaurantes = listarRestaurantes.listarRestaurantes();

        assertFalse(restaurantes.stream().anyMatch(r -> r.getNome().equals("Restaurante para Exclusão")),
                "O restaurante excluído não deve estar presente na lista.");
    }

    @Test
    @Transactional
    void deveAlterarEnderecoDoRestaurante() {
        // Arrange
        Restaurante novoRestaurante = new Restaurante();
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Original");
        endereco.setNumero("789");
        novoRestaurante.setNome("Restaurante a Alterar");
        novoRestaurante.setEndereco(endereco);
        cadastrarRestaurante.cadastrarRestaurante(novoRestaurante);

        Endereco novoEndereco = new Endereco();
        novoEndereco.setLogradouro("Novo Rua");
        novoEndereco.setNumero("321");
        novoRestaurante.setEndereco(novoEndereco);
        alterarEnderecoRestaurante.alterarEnderecoRestaurante(novoRestaurante);

        List<Restaurante> restaurantes = listarRestaurantes.listarRestaurantes();

        assertTrue(restaurantes.stream().anyMatch(r -> r.getEndereco().getLogradouro().equals("Novo Rua")),
                "Deve encontrar o restaurante com o novo endereço.");
    }
}
