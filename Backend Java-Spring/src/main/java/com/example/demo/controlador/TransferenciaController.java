package com.example.demo.controlador;

import com.example.demo.modelo.dto.requisicao.TranferenciaDto;
import com.example.demo.modelo.dto.resposta.DadosTransferenciaDto;
import com.example.demo.servicos.GestaoClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    private final GestaoClienteService gestaoClienteService;

    public TransferenciaController(GestaoClienteService gestaoClienteService){
        this.gestaoClienteService = gestaoClienteService;
    }

    @PostMapping("/transferir")
    @Transactional
    public ResponseEntity transferirDinheiro(@RequestBody @Valid TranferenciaDto transferenciaDto, UriComponentsBuilder uriBuilder){
        var dados = gestaoClienteService.realizarTranseferencia(transferenciaDto);
        var uri = uriBuilder.path("transferencia/transferir/{id}").buildAndExpand(dados.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosTransferenciaDto(dados));
    }


}
