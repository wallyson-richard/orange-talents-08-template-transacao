package br.com.zupacademy.wallyson.transacao.cartao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String numero;

    @Email
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }
}
