package br.com.zupacademy.wallyson.transacao.transacoes.consultatransacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoResponse {

    private UUID id;
    private String  numero;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(UUID id, String numero, BigDecimal valor, EstabelecimentoResponse estabelecimento,
                             LocalDateTime efetivadaEm) {
        this.id = id;
        this.numero = numero;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public UUID getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
