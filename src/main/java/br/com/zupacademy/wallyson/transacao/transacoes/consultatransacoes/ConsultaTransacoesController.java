package br.com.zupacademy.wallyson.transacao.transacoes.consultatransacoes;

import br.com.zupacademy.wallyson.transacao.transacoes.Transacao;
import br.com.zupacademy.wallyson.transacao.transacoes.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ConsultaTransacoesController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cartoes/{numeroCartao}/transacoes")
    public List<TransacaoResponse> ultimasTransacoes(@PathVariable String numeroCartao) {
        var transacoes  = transacaoRepository.findTop10ByCartao_NumeroOrderByEfetivadaEmDesc(numeroCartao);

        if (transacoes.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não existe transações para o cartão informado");
        }

        return transacoes.stream()
                .map(Transacao::toDto)
                .collect(Collectors.toList());
    }
}
