package com.grupo19.gastroreserva.infra.controller.restaurante;

import com.grupo19.gastroreserva.application.usecases.restaurante.AlterarEnderecoRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.CadastrarRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ExcluirRestaurante;
import com.grupo19.gastroreserva.application.usecases.restaurante.ListarRestaurantes;
import com.grupo19.gastroreserva.domain.entities.restaurante.Restaurante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final ListarRestaurantes listarRestaurantes;
    private final CadastrarRestaurante cadastrarRestaurante;
    private final AlterarEnderecoRestaurante alterarEnderecoRestaurante;
    private final ExcluirRestaurante excluirRestaurante;

    public RestauranteController(AlterarEnderecoRestaurante alterarEnderecoRestaurante, CadastrarRestaurante cadastrarRestaurante, ExcluirRestaurante excluirRestaurante, ListarRestaurantes listarRestaurantes) {
        this.alterarEnderecoRestaurante = alterarEnderecoRestaurante;
        this.cadastrarRestaurante = cadastrarRestaurante;
        this.excluirRestaurante = excluirRestaurante;
        this.listarRestaurantes = listarRestaurantes;
    }

    @GetMapping
    public List<RestauranteDTO> listarRestaurantes() {
        List<RestauranteDTO> restaurantesDTO = new ArrayList<>();
        listarRestaurantes.listarRestaurantes().forEach(restaurante -> restaurantesDTO.add(new RestauranteDTO(restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTipoDeCozinha(),
                restaurante.getHorarioDeFuncionamento(),
                restaurante.getCapacidade(),
                restaurante.getCadeirasDisponiveis())));
        return restaurantesDTO;
    }

    @PostMapping
    public RestauranteDTO cadastrarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        Restaurante salvo = cadastrarRestaurante.cadastrarRestaurante(new Restaurante(restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(),
                restauranteDTO.capacidade(),
                restauranteDTO.cadeirasDisponiveis()));

        return new RestauranteDTO(salvo.getNome(),
                salvo.getEndereco(),
                salvo.getTipoDeCozinha(),
                salvo.getHorarioDeFuncionamento(),
                salvo.getCapacidade(),
                salvo.getCadeirasDisponiveis());
    }

    @PostMapping("/endereco")
    public RestauranteDTO alterarEndereco(@RequestBody RestauranteDTO restauranteDTO) {
        Restaurante salvo = alterarEnderecoRestaurante.alterarEnderecoRestaurante(new Restaurante(restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(),
                restauranteDTO.capacidade(),
                restauranteDTO.cadeirasDisponiveis()));

        return new RestauranteDTO(salvo.getNome(),
                salvo.getEndereco(),
                salvo.getTipoDeCozinha(),
                salvo.getHorarioDeFuncionamento(),
                salvo.getCapacidade(),
                salvo.getCadeirasDisponiveis());
    }

    @DeleteMapping
    public void excluirRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        excluirRestaurante.excluirRestaurante(new Restaurante(restauranteDTO.nome(),
                restauranteDTO.endereco(),
                restauranteDTO.tipoDeCozinha(),
                restauranteDTO.horarioDeFuncionamento(),
                restauranteDTO.capacidade(),
                restauranteDTO.cadeirasDisponiveis()));
    }
}
