package br.com.zupacademy.wallyson.transacao.transacoes.novatransacao;

import br.com.zupacademy.wallyson.transacao.cartao.Cartao;
import br.com.zupacademy.wallyson.transacao.cartao.CartaoRepository;

import javax.validation.constraints.Email;

public class CartaoMessageRequest {

    private String id;

    @Email
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel(CartaoRepository cartaoRepository) {
        return cartaoRepository.findByNumero(id)
                .orElse(new Cartao(id, email));
    }
}
