package com.example.demo.modelo.dto.requisicao;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class TranferenciaDto {

        @NotNull(message = "O id do usuário não pode ser nulo!")
        private UUID id;
        @NotBlank(message = "O numero da conta  não pode ser nulo ou vazio!")
        private String numeroConta;
        @NotNull(message = "A agência não pode ser nulo!")
        @Positive(message = "Deve ser um número positivo!")
        private Integer agencia;
        @NotBlank(message = "O nome do banconão pode ser nulo ou vazio!")
        private String banco;
        @NotNull(message = "O valor de transferencia não pode ser nulo")
        @DecimalMin(value = "0.01", message = "Valor Inválido!")
        private Double valor;
        private String descricao;



        @Override
        public String toString() {
                return "TranferenciaDto{" +
                        "id=" + id +
                        ", numeroConta='" + numeroConta + '\'' +
                        ", agencia=" + agencia +
                        ", banco='" + banco + '\'' +
                        ", valor=" + valor +
                        '}';
        }
}
