package com.example.demo.modelo.dto.requisicao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class LoginDto {

    @NotBlank(message = "Email não pode ser nulo ou vazio!")
    @Email
    private String email;

    @NotBlank(message = "Senha não pode ser nula ou vazia!")
    private String senha;

    @Override
    public String toString() {
        return "DadosLogin{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
