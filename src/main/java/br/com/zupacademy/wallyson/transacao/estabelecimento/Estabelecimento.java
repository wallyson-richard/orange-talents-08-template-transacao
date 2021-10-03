package br.com.zupacademy.wallyson.transacao.estabelecimento;

import br.com.zupacademy.wallyson.transacao.transacoes.consultatransacoes.EstabelecimentoResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public EstabelecimentoResponse toDto() {
        return new EstabelecimentoResponse(id, nome, cidade, endereco);
    }
}
