package com.melon.lanchonete.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Entidade em uso!")
public class EntidadeNaoEncontradaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public EntidadeNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
