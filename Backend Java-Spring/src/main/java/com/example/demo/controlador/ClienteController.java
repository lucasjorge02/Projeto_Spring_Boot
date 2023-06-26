package com.example.demo.controlador;

import com.example.demo.modelo.dto.requisicao.LoginDto;
import com.example.demo.modelo.dto.requisicao.OperadorIdDto;
import com.example.demo.modelo.dto.resposta.DadosCadastradosDto;
import com.example.demo.modelo.dto.resposta.DadosSaldoDto;
import com.example.demo.modelo.entidades.Cliente;
import com.example.demo.modelo.entidades.Conta;
import com.example.demo.modelo.dto.requisicao.CadastroDto;
import com.example.demo.modelo.entidades.Operador;
import com.example.demo.servicos.GestaoClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private final GestaoClienteService gestaoClienteService;

    public ClienteController(GestaoClienteService gestaoClienteService) {
        this.gestaoClienteService = gestaoClienteService;
    }

    @GetMapping("/login")
    public ResponseEntity logarComoOperador(@RequestBody @Valid LoginDto login){
        var dados = gestaoClienteService.bucarOperadorParaLogar(login);
        return ResponseEntity.ok(dados);
    }

    @GetMapping("/saldo")
    public ResponseEntity pegarSaldoOperador(@RequestBody @Valid OperadorIdDto operadorIdDto){
        var dados = gestaoClienteService.bucarSaldoPeloOperador(operadorIdDto.getId());
        return ResponseEntity.ok(new DadosSaldoDto(dados));
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity criarClienteContaOperadorNoBanco(@RequestBody @Valid CadastroDto cadastroDto, UriComponentsBuilder uriBuilder) {

        Cliente cliente = new Cliente(cadastroDto);
        Conta conta = new Conta(cadastroDto, cliente);
        Operador operador = new Operador(cadastroDto, cliente);

        var dados = gestaoClienteService.criarClienteContaOperadorNoBanco(cliente, conta, operador);

        var uri = uriBuilder.path("cliente/cadastrar/{id}").buildAndExpand(dados.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosCadastradosDto(dados));
        }




    }


