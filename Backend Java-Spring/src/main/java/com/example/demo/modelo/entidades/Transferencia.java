package com.example.demo.modelo.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Transferencia")
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;
    private LocalDateTime dataTransferencia;
    private Double valor;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fkConta", referencedColumnName = "id")
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "fkOperador", referencedColumnName = "id")
    private Operador operador;

    public Transferencia(Double valor, String descricao, Conta conta, Operador operador) {
        this.dataTransferencia = LocalDateTime.now();
        this.valor = valor;
        this.descricao = descricao;
        this.conta = conta;
        this.operador = operador;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", dataTransferencia=" + dataTransferencia +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", conta=" + conta +
                ", operador=" + operador;
    }
}
