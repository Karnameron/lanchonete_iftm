package com.melon.lanchonete.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Entidade associada à outra entidade!")
public class DataIntegrityViolationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public DataIntegrityViolationException(String mensagem){
        super(mensagem);
    }
}
