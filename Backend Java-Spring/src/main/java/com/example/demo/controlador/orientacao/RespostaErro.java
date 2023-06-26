package com.example.demo.controlador.orientacao;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class RespostaErro {

        private Integer status;
        private String message;
        public static RespostaErro construirExececao(Integer status, Exception exception) {
            RespostaErro resposta = new RespostaErro();
            resposta.setStatus(status);
            resposta.setMessage(exception.getMessage());
            return resposta;
        }



    }

