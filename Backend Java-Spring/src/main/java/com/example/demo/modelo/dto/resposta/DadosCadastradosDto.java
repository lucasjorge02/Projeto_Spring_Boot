package com.example.demo.modelo.dto.resposta;

import com.example.demo.modelo.auxiliares.ConjuntoDadosCadastrados;
import com.example.demo.modelo.auxiliares.TipoDocumento;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class DadosCadastradosDto {

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



    public DadosCadastradosDto(ConjuntoDadosCadastrados dados) {
        this.nome = dados.getNome();
        this.ddd = dados.getDdd();
        this.telefone = dados.getTelefone();
        this.tipoDocumento = dados.getTipoDocumento();
        this.numeroDocumento = dados.getNumeroDocumento();
        this.nomePerfil = dados.getNomePerfil();
        this.email = dados.getEmail();
        this.senha = dados.getSenha();
        this.agencia = dados.getAgencia();
        this.numeroConta = dados.getNumeroConta();
    }

    @Override
    public String toString() {
        return "DadosCadastradosDto{" +
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
