package com.example.demo.modelo.auxiliares;

import com.example.demo.modelo.entidades.Conta;
import com.example.demo.modelo.entidades.Transferencia;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class ConjuntoDadosTransferencia{

    private UUID id;
    private LocalDateTime dataTransferencia;
    private String numeroConta;
    private Integer agencia;
    private String banco;
    private String nomeRecebedor;
    private Double valor;
    private String descricao;

    public ConjuntoDadosTransferencia(Transferencia novaTrans, Conta contaRecebedor) {
        this.dataTransferencia = novaTrans.getDataTransferencia();
        this.valor = novaTrans.getValor();
        this.descricao = novaTrans.getDescricao();
        this.nomeRecebedor = contaRecebedor.getCliente().getNome();
        this.banco = contaRecebedor.getBanco();
        this.agencia = contaRecebedor.getAgencia();
        this.numeroConta = contaRecebedor.getNumeroConta();
    }

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
