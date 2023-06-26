package com.example.demo.modelo.auxiliares;

import com.example.demo.modelo.entidades.Cliente;
import com.example.demo.modelo.entidades.Conta;
import com.example.demo.modelo.entidades.Operador;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ConjuntoDadosCadastrados {

        private UUID id;
        private String nome;
        private String ddd;
        private String telefone;
        private TipoDocumento tipoDocumento;
        private String numeroDocumento;
        private String nomePerfil;
        private String email;
        private String senha;
        private Integer agencia;
        private String numeroConta;

        public ConjuntoDadosCadastrados(Cliente cliente, Operador operador, Conta conta) {
            this.id = cliente.getId();
            this.nome = cliente.getNome();
            this.ddd = cliente.getDdd();
            this.telefone = cliente.getTelefone();
            this.tipoDocumento = cliente.getTipoDocumento();
            this.numeroDocumento = cliente.getNumeroDocumento();
            this.nomePerfil = operador.getNomePerfil();
            this.email = operador.getEmail();
            this.senha = operador.getSenha();
            this.agencia = conta.getAgencia();
            this.numeroConta = conta.getNumeroConta();
        }

        @Override
        public String toString() {
            return "DadosCadastrados{" +
                    ", id='" + id + '\'' +
                    ", nome='" + nome + '\'' +
                    ", ddd='" + ddd + '\'' +
                    ", telefone='" + telefone + '\'' +
                    ", tipoDocumento='" + tipoDocumento + '\'' +
                    ", numeroDocumento='" + numeroDocumento + '\'' +
                    ", nomePerfil='" + nomePerfil + '\'' +
                    ", email='" + email + '\'' +
                    ", agencia=" + agencia +
                    ", conta='" + numeroConta + '\'' +
                    '}';
        }



}
