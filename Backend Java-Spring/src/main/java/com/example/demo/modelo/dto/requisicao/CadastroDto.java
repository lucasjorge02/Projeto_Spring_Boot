package com.example.demo.modelo.dto.requisicao;

import com.example.demo.modelo.auxiliares.TipoDocumento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;



@Data
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CadastroDto {

    @NotBlank(message = "O nome do cliente não pode estar em branco ou nulo!")
    private String nome;

    @NotBlank(message = "O ddd do cliente não pode estar em branco ou nulo!")
    @Pattern(regexp = "\\d{2}", message = "O ddd deve ter 2 dígitos!")
    private String ddd;

    @NotBlank(message = "O telefone do cliente não pode estar em branco ou nulo!")
    @Pattern(regexp = "\\d{8,9}", message = "O telefone deve conter de 8 a 9 dígitos!")
    private String telefone;

    @NotNull(message = "O tipo de documento não pode estar em branco ou nulo!")
    private TipoDocumento tipoDocumento;

    @NotBlank(message = "O número do documento não pode estar em branco ou nulo!")
    @Pattern(regexp = "\\d{11,14}", message = "O numero do documento deve ter 11 ou 14 dígitos!")
    private String numeroDocumento;

    @NotBlank(message = "O nome do perfil do cliente não pode estar em branco ou nulo!")
    private String nomePerfil;

    @NotBlank(message = "O email não pode estar em branco ou nulo!")
    @Email
    private String email;

    @NotBlank(message = "A senha não pode ser vazia ou nula!")
    private String senha;

    @NotNull(message = "O número da agência não pode estar nulo!")
    private Integer agencia;

    @NotBlank(message = "O número da conta não pode estar em branco ou nulo!")
    private String numeroConta;

    @Override
    public String toString() {
        return "CadastroDto{" +
                "nome='" + nome + '\'' +
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
