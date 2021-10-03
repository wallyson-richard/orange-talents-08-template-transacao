package br.com.zupacademy.wallyson.transacao.estabelecimento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, UUID> {
    Optional<Estabelecimento> findByNomeAndCidadeAndEndereco(String nome, String cidade, String endereco);
}
