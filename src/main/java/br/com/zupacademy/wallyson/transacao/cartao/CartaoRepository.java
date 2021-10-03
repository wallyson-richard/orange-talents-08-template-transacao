package br.com.zupacademy.wallyson.transacao.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
    Optional<Cartao> findByNumero(String numero);
}
