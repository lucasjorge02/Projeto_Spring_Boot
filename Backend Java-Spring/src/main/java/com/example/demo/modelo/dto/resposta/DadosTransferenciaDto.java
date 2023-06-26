package com.example.demo.modelo.dto.resposta;

import com.example.demo.modelo.auxiliares.ConjuntoDadosTransferencia;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class DadosTransferenciaDto {

    private LocalDateTime dataTransferencia;
    private Double valor;
    private String descricao;
    private String nomeRecebedor;
    private String numeroConta;
    private Integer agencia;
    private String banco;
public DadosTransferenciaDto(ConjuntoDadosTransferencia cj) {
    this.dataTransferencia = cj.getDataTransferencia();
    this.valor = cj.getValor();
    this.descricao = cj.getDescricao();
    this.nomeRecebedor = cj.getNomeRecebedor();
    this.banco = cj.getBanco();
    this.agencia = cj.getAgencia();
    this.numeroConta = cj.getNumeroConta();
}

    @Override
    public String toString() {
        return  "dataTransferencia=" + dataTransferencia +
                ", valor=" + valor +
                ", nome=" + nomeRecebedor +
                ", descricao='" + descricao + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia=" + agencia +
                ", banco='" + banco;
    }
}
