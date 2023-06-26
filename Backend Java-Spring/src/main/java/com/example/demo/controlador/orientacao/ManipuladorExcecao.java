package com.example.demo.controlador.orientacao;

import com.example.demo.servicos.execoes.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorExcecao {

    @ExceptionHandler(EmailOperadorException.class)
    public ResponseEntity emailOperadorException(EmailOperadorException e) {
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.UNPROCESSABLE_ENTITY.value(), e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(resposta);
    }

    @ExceptionHandler(DocumentoException.class)
    public ResponseEntity documentoException(DocumentoException e) {
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.UNPROCESSABLE_ENTITY.value(), e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(resposta);
    }

    @ExceptionHandler(ContaException.class)
    public ResponseEntity documentoException(ContaException e) {
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.UNPROCESSABLE_ENTITY.value(), e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(resposta);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErroDeNuloEBranco(MethodArgumentNotValidException e){
        var erros = e.getFieldErrors();
        List<RespostaListaErros> respostaErros = erros.stream()
                .map(erro -> new RespostaListaErros(HttpStatus.UNPROCESSABLE_ENTITY.value(), erro))
                .collect(Collectors.toList());
        return ResponseEntity.unprocessableEntity().body(respostaErros);
    }

    @ExceptionHandler(EmailNaoEncontradoException.class)
    public ResponseEntity emailNaoEncontrado(EmailNaoEncontradoException e){
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.NOT_FOUND.value(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(resposta);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity loginInvalido(LoginException e){
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.UNAUTHORIZED.value(), e);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(resposta);
    }

    @ExceptionHandler(SaldoException.class)
    public ResponseEntity saldoNaoEncontrado(SaldoException e){
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.NOT_FOUND.value(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(resposta);
    }

    @ExceptionHandler(SaldoInsufienteException.class)
    public ResponseEntity saldoNaoSuficiente(SaldoInsufienteException e){
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.UNAUTHORIZED.value(), e);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(resposta);
    }

    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity tipoDadosRecebidosInvalidos(UnexpectedException e){
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.UNPROCESSABLE_ENTITY.value(), e);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(resposta);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(EntityNotFoundException e){
        RespostaErro resposta = RespostaErro.construirExececao(HttpStatus.NOT_FOUND.value(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(resposta);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity geralException(Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body("Ocorreu um erro interno no servidor.");
//    }

}
