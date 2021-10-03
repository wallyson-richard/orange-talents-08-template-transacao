package br.com.zupacademy.wallyson.transacao.transacoes.novatransacao;

import br.com.zupacademy.wallyson.transacao.estabelecimento.Estabelecimento;
import br.com.zupacademy.wallyson.transacao.estabelecimento.EstabelecimentoRepository;

public class EstabelecimentoMessageRequest {

    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(EstabelecimentoRepository estabelecimentoRepository) {
        return estabelecimentoRepository.findByNomeAndCidadeAndEndereco(nome, cidade, endereco)
                .orElse(new Estabelecimento(nome, cidade, endereco));
    }
}
