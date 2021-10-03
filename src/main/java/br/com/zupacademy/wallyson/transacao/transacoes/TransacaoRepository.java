package br.com.zupacademy.wallyson.transacao.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {
    Optional<Transacao> findByNumero(String numero);
}
