package com.example.demo.controlador.orientacao;

import lombok.*;
import org.springframework.validation.FieldError;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class RespostaListaErros {

    private Integer status;
    private String campo;
    private String message;

    public RespostaListaErros(Integer status, FieldError erro) {
       this.status = status;
       this.campo = erro.getField();
       this.message = erro.getDefaultMessage();
    }


}
