package com.grupo19.gastroreserva.infra.controller.avaliacao;

import com.grupo19.gastroreserva.application.usecases.avaliacao.EditarAvaliacao;
import com.grupo19.gastroreserva.application.usecases.avaliacao.ExcluirAvaliacao;
import com.grupo19.gastroreserva.application.usecases.avaliacao.ListarAvaliacoes;
import com.grupo19.gastroreserva.application.usecases.avaliacao.RealizarAvaliacao;
import com.grupo19.gastroreserva.domain.entities.avaliacao.Avaliacao;
import com.grupo19.gastroreserva.domain.entities.cliente.Cliente;
import com.grupo19.gastroreserva.infra.controller.cliente.ClienteDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    private final EditarAvaliacao editarAvaliacao;
    private final ExcluirAvaliacao excluirAvaliacao;
    private final RealizarAvaliacao realizarAvaliacao;
    private final ListarAvaliacoes listarAvaliacoes;

    public AvaliacaoController(EditarAvaliacao editarAvaliacao, ExcluirAvaliacao excluirAvaliacao, RealizarAvaliacao realizarAvaliacao, ListarAvaliacoes listarAvaliacoes) {
        this.editarAvaliacao = editarAvaliacao;
        this.excluirAvaliacao = excluirAvaliacao;
        this.realizarAvaliacao = realizarAvaliacao;
        this.listarAvaliacoes = listarAvaliacoes;
    }

    @GetMapping
    public List<AvaliacaoDTO> getAvaliacoes(@RequestBody ClienteDTO clienteDTO) {
        List<AvaliacaoDTO> avaliacoes = new ArrayList<>();
        listarAvaliacoes.listarAvaliacoes(new Cliente(clienteDTO.cpf(),
                        clienteDTO.nome(),
                        clienteDTO.email()))
                .forEach(v -> avaliacoes.add(new AvaliacaoDTO(
                        v.getCliente(),
                        v.getRestaurante(),
                        v.getNota(),
                        v.getComentario(),
                        v.getData())));
        return avaliacoes;
    }

    @PostMapping
    public AvaliacaoDTO realizarAvaliacao(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        Avaliacao novaAvaliacao = realizarAvaliacao.realizarAvaliacao(
                new Avaliacao(avaliacaoDTO.cliente(),
                avaliacaoDTO.restaurante(),
                avaliacaoDTO.nota(),
                avaliacaoDTO.comentario(),
                avaliacaoDTO.data()));

        return new AvaliacaoDTO(novaAvaliacao.getCliente(),
                novaAvaliacao.getRestaurante(),
                novaAvaliacao.getNota(),
                novaAvaliacao.getComentario(),
                novaAvaliacao.getData());
    }

    @PostMapping("/alterar")
    public AvaliacaoDTO editarAvaliacao(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        Avaliacao avaliacaoAlterada = editarAvaliacao.editarAvaliacao(
                new Avaliacao(avaliacaoDTO.cliente(),
                        avaliacaoDTO.restaurante(),
                        avaliacaoDTO.nota(),
                        avaliacaoDTO.comentario(),
                        avaliacaoDTO.data()));

        return new AvaliacaoDTO(avaliacaoAlterada.getCliente(),
                avaliacaoAlterada.getRestaurante(),
                avaliacaoAlterada.getNota(),
                avaliacaoAlterada.getComentario(),
                avaliacaoAlterada.getData());
    }

    @DeleteMapping
    public void excluirAvaliacao(@RequestBody AvaliacaoDTO avaliacaoDTO) {
        excluirAvaliacao.excluirAvaliacao(new Avaliacao(avaliacaoDTO.cliente(),
                avaliacaoDTO.restaurante(),
                avaliacaoDTO.nota(),
                avaliacaoDTO.comentario(),
                avaliacaoDTO.data()));
    }
}
