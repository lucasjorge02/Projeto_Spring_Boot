package com.example.demo.modelo.dto.resposta;

import com.example.demo.modelo.entidades.Operador;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DadosLoginDto {

        private UUID id;
        private String email;
        private String senha;
        private Boolean primeiroAcesso;

    public DadosLoginDto(Operador operador) {
        this.id = operador.getId();
        this.email = operador.getEmail();
        this.senha = operador.getSenha();
        this.primeiroAcesso = operador.getPrimeiroAcesso();
    }


    @Override
    public String toString() {
        return  "id='" + id + '\'' +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", primeiroAcesso=" + primeiroAcesso;
    }
}
