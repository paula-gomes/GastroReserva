package com.grupo19.gastroreserva.infra.persistence;

import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "endereco")
public class EnderecoEntity {

    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    public EnderecoEntity(String cep, String logradouro, String numero, String bairro, String cidade, String estado) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
