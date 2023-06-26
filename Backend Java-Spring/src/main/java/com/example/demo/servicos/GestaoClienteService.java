package com.example.demo.servicos;


import com.example.demo.modelo.auxiliares.ConjuntoDadosCadastrados;
import com.example.demo.modelo.auxiliares.ConjuntoDadosTransferencia;
import com.example.demo.modelo.dto.requisicao.TranferenciaDto;
import com.example.demo.modelo.entidades.*;
import com.example.demo.modelo.dto.resposta.DadosLoginDto;
import com.example.demo.modelo.dto.requisicao.LoginDto;
import com.example.demo.servicos.execoes.LoginException;
import com.example.demo.servicos.execoes.SaldoInsufienteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GestaoClienteService {

    @Autowired
    private final ClienteService clienteService;
    private final OperadorService operadorService;
    private final ContaService contaService;
    private final TransferenciaService transferenciaService;

    public GestaoClienteService(ClienteService clienteService, OperadorService operadorService, ContaService contaService, TransferenciaService transferenciaService) {
        this.clienteService = clienteService;
        this.contaService = contaService;
        this.operadorService = operadorService;
        this.transferenciaService = transferenciaService;
    }


    public DadosLoginDto bucarOperadorParaLogar(LoginDto login){
        Operador operador = operadorService.buscarOperadorPorEmail(login.getEmail());
        if (!login.getSenha().equals(operador.getSenha()) || !operador.getStatus()){
            throw new LoginException("Login inválido, verifique as credenciais ou se sua conta está ativa!");
        }
        return new DadosLoginDto(operador);
    }


    public ConjuntoDadosCadastrados criarClienteContaOperadorNoBanco(Cliente cliente, Conta conta, Operador operador) {

            clienteService.verificarNumeroDocumento(cliente);
            operadorService.verificarEmail(operador);
            contaService.verificarConta(conta);


            clienteService.salvarClienteNoBanco(cliente);
            contaService.salvarContaNoBanco(conta);
            operadorService.salvarOperadorNoBanco(operador);


        return new ConjuntoDadosCadastrados(cliente, operador, conta) ;
    }


    public ConjuntoDadosTransferencia realizarTranseferencia(TranferenciaDto transferencia){
        Operador pagador = operadorService.buscarOperadorPorId(transferencia.getId());
        Conta contaPagador = contaService.buscarSaldoPeloOperador(transferencia.getId());
        Conta contaRecebedor = contaService.buscarConta(transferencia.getNumeroConta(), transferencia.getAgencia());

        if(contaPagador.getSaldo() <= 0.0 || transferencia.getValor() > contaPagador.getSaldo()){
            throw new SaldoInsufienteException("Saldo insuficiente!");
        }

        contaPagador.setSaldo(contaPagador.getSaldo() - transferencia.getValor());
        contaRecebedor.setSaldo(contaRecebedor.getSaldo() + transferencia.getValor());

        Transferencia novaTrans = new Transferencia(transferencia.getValor(), transferencia.getDescricao(), contaRecebedor, pagador);

        transferenciaService.salvarTransferencia(novaTrans);

        return new ConjuntoDadosTransferencia(novaTrans, contaRecebedor);
    }


    public Double bucarSaldoPeloOperador(UUID id) {
        Conta conta = contaService.buscarSaldoPeloOperador(id);
        return conta.getSaldo();
    }
}
