package br.com.zupacademy.wallyson.transacao.transacoes;

import br.com.zupacademy.wallyson.transacao.cartao.Cartao;
import br.com.zupacademy.wallyson.transacao.estabelecimento.Estabelecimento;
import br.com.zupacademy.wallyson.transacao.transacoes.consultatransacoes.TransacaoResponse;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String  numero;
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String numero, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
                     LocalDateTime efetivadaEm) {
        this.numero = numero;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse toDto() {
        var estabelecimento = this.estabelecimento.toDto();
        return new TransacaoResponse(id, numero, valor, estabelecimento, efetivadaEm);
    }
}
