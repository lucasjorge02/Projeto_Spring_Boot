package com.example.demo.modelo.dto.resposta;

import com.example.demo.modelo.entidades.Conta;
import com.example.demo.modelo.entidades.Operador;
import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DadosSaldoDto {

        private Double saldo;

    @Override
    public String toString() {
        return "saldo=" + saldo;
    }

}
