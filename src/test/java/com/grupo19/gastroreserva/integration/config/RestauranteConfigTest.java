package com.grupo19.gastroreserva.integration.config;

import com.grupo19.gastroreserva.application.usecases.restaurante.AlterarEnderecoRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.CadastrarRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ExcluirRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ListarRestaurantes;
import com.grupo19.gastroreserva.domain.Endereco;
import com.grupo19.gastroreserva.domain.HorarioDeFuncionamento;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import com.grupo19.gastroreserva.infra.gateways.restaurante.RepositorioDeRestauranteJpa;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        Restaurante novoRestaurante = new Restaurante();
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Teste");
        endereco.setNumero("123");
        endereco.setCep("11111-111");
        endereco.setEstado("SP");
        novoRestaurante.setNome("Restaurante Teste");
        novoRestaurante.setEndereco(endereco);

        HorarioDeFuncionamento horarioDeFuncionamento = new HorarioDeFuncionamento(LocalTime.of(9, 0), LocalTime.of(18, 0));
        novoRestaurante.setHorarioDeFuncionamento(horarioDeFuncionamento);

        cadastrarRestaurante.cadastrarRestaurante(novoRestaurante);

        List<Restaurante> restaurantes = listarRestaurantes.listarRestaurantes();

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
        endereco.setCep("11111-111");
        endereco.setEstado("SP");
        novoRestaurante.setNome("Restaurante para Exclusão");
        novoRestaurante.setEndereco(endereco);

        HorarioDeFuncionamento horarioDeFuncionamento = new HorarioDeFuncionamento(LocalTime.of(9, 0), LocalTime.of(18, 0));
        novoRestaurante.setHorarioDeFuncionamento(horarioDeFuncionamento);

        // Cadastrar o restaurante
        cadastrarRestaurante.cadastrarRestaurante(novoRestaurante);

        // Verifique se o ID foi preenchido
/*        assertNotNull(novoRestaurante.getId(), "O ID do restaurante deve ser preenchido após a inserção.");*/

        // Excluir o restaurante
        excluirRestaurante.excluirRestaurante(novoRestaurante);

        // Listar todos os restaurantes
        List<Restaurante> restaurantes = listarRestaurantes.listarRestaurantes();

        // Assert
        assertFalse(restaurantes.stream().anyMatch(r -> r.getNome().equals("Restaurante para Exclusão")),
                "O restaurante excluído não deve estar presente na lista.");
    }

    @Test
    @Transactional
    void deveAlterarEnderecoDoRestaurante() {
        Restaurante novoRestaurante = new Restaurante();
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Original");
        endereco.setNumero("789");
        endereco.setCep("11111-111");
        endereco.setEstado("SP");
        novoRestaurante.setNome("Restaurante a Alterar");
        novoRestaurante.setEndereco(endereco);

        HorarioDeFuncionamento horarioDeFuncionamento = new HorarioDeFuncionamento(LocalTime.of(9, 0), LocalTime.of(18, 0));
        novoRestaurante.setHorarioDeFuncionamento(horarioDeFuncionamento);

        cadastrarRestaurante.cadastrarRestaurante(novoRestaurante);

        Endereco novoEndereco = new Endereco();
        novoEndereco.setLogradouro("Novo Rua");
        novoEndereco.setNumero("321");
        novoEndereco.setCep("11111-111");
        novoEndereco.setEstado("SP");
        novoRestaurante.setEndereco(novoEndereco);
        alterarEnderecoRestaurante.alterarEnderecoRestaurante(novoRestaurante);

        List<Restaurante> restaurantes = listarRestaurantes.listarRestaurantes();

        assertTrue(restaurantes.stream().anyMatch(r -> r.getEndereco().getLogradouro().equals("Novo Rua")),
                "Deve encontrar o restaurante com o novo endereço.");
    }
}
