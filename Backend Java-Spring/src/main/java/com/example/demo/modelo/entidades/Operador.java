package com.example.demo.modelo.entidades;

import com.example.demo.modelo.dto.requisicao.CadastroDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Operador")
@Table(name = "operador")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Operador {

    @Id @GeneratedValue(generator = "uuid")
    private UUID id;
    private String nomePerfil;
    private String email;
    private String senha;
    private Boolean status;
    private Boolean primeiroAcesso;

    @ManyToOne
    @JoinColumn(name = "fkCliente", referencedColumnName = "id")
    private Cliente cliente;

    @OneToMany(mappedBy = "operador")
    private List<Transferencia> listaTransferencia = new ArrayList();

    public Operador(CadastroDto operador, Cliente cliente) {
        this.nomePerfil = operador.getNomePerfil();
        this.email = operador.getEmail();
        this.status = true;
        this.senha = operador.getSenha();
        this.primeiroAcesso = true;
        this.cliente = cliente;
    }
    public Operador(String nomePerfil, String email, String senha, Cliente cliente) {
        this.nomePerfil = nomePerfil;
        this.email = email;
        this.senha = senha;
        this.status = true;
        this.primeiroAcesso = true;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nomePerfil='" + nomePerfil + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", status=" + status +
                ", primeiroAcesso=" + primeiroAcesso;

    }
}
