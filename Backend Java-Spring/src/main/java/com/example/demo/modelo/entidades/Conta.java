package com.example.demo.modelo.entidades;

import com.example.demo.modelo.dto.requisicao.CadastroDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Conta")
@Table(name = "conta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id @GeneratedValue(generator = "uuid")
    private UUID id;
    private String numeroConta;
    private Integer agencia;
    private String banco;
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "fkCliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "conta")
    private List<Transferencia> listaTransferencia = new ArrayList();

    public Conta(CadastroDto cadastroDto, Cliente cliente) {
        this.numeroConta = cadastroDto.getNumeroConta();
        this.agencia = cadastroDto.getAgencia();
        this.banco = "Itaú";
        this.saldo = 0.00;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", numeroConta='" + numeroConta + '\'' +
                ", agencia=" + agencia +
                ", banco='" + banco + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }
}
