package br.com.zupacademy.wallyson.transacao.transacoes.consultaulimastransacoes;

import java.util.UUID;

public class EstabelecimentoResponse {
    private UUID id;

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoResponse(UUID id, String nome, String cidade, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
