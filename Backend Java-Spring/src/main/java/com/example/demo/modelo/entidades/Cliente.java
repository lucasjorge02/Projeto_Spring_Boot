package com.example.demo.modelo.entidades;

import com.example.demo.modelo.auxiliares.TipoDocumento;
import com.example.demo.modelo.dto.requisicao.CadastroDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Cliente")
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(generator = "uuid")
    private UUID id;
    private String nome;
    private String ddd;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;

    @OneToMany(mappedBy = "cliente")
    private List<Conta> listaConta = new ArrayList();

    @OneToMany(mappedBy = "cliente")
    private List<Operador> listaOperador = new ArrayList();

    public Cliente(CadastroDto empresa) {
        this.nome = empresa.getNome();
        this.ddd = empresa.getDdd();
        this.telefone = empresa.getTelefone();
        this.tipoDocumento = empresa.getTipoDocumento();
        this.numeroDocumento = empresa.getNumeroDocumento();
    }

    public Cliente(UUID id, String nome, String ddd, String telefone, TipoDocumento tipoDocumento, String numeroDocumento) {
        this.id = id;
        this.nome = nome;
        this.ddd = ddd;
        this.telefone = telefone;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ddd='" + ddd + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", listaConta=" + listaConta +
                ", listaOperador=" + listaOperador +
                '}';
    }
}