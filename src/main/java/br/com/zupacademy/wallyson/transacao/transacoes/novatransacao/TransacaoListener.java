package br.com.zupacademy.wallyson.transacao.transacoes.novatransacao;

import br.com.zupacademy.wallyson.transacao.cartao.CartaoRepository;
import br.com.zupacademy.wallyson.transacao.estabelecimento.EstabelecimentoRepository;
import br.com.zupacademy.wallyson.transacao.transacoes.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransacaoListener{

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

    @KafkaListener(topics = "${topic.transacao}")
    @Transactional
    public void listen(TransacaoMessageRequest request) {
        try {
            var transacao = request.toModel(transacaoRepository, estabelecimentoRepository, cartaoRepository);
            transacaoRepository.save(transacao);
            logger.info("A transação com final {} foi persistida com sucesso.",
                    request.getId().substring(request.getId().length() - 4));
        } catch (Exception e) {
            logger.error("A transação com final {} não foi persistida houve um erro durante a operação.",
                    request.getId().substring(request.getId().length() - 4));
            logger.error(e.getMessage());
        }
    }
}
