package br.com.zupacademy.wallyson.transacao.transacoes.novatransacao;

import br.com.zupacademy.wallyson.transacao.cartao.CartaoRepository;
import br.com.zupacademy.wallyson.transacao.estabelecimento.EstabelecimentoRepository;
import br.com.zupacademy.wallyson.transacao.transacoes.Transacao;
import br.com.zupacademy.wallyson.transacao.transacoes.TransacaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessageRequest {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoMessageRequest estabelecimento;
    private CartaoMessageRequest cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoMessageRequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoMessageRequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel(TransacaoRepository transacaoRepository,
                             EstabelecimentoRepository estabelecimentoRepository,
                             CartaoRepository cartaoRepository) throws IllegalArgumentException {
        transacaoRepository.findByNumero(id)
                .ifPresent(transacao -> {
                    throw new IllegalArgumentException("Transação já existe em nossa base de dados.");
                });
        var estabelecimento = this.estabelecimento.toModel(estabelecimentoRepository);
        var cartao = this.cartao.toModel(cartaoRepository);
        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }
}
