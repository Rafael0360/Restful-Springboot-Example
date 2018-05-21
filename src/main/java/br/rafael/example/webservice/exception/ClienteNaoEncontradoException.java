package br.rafael.example.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ClienteNaoEncontradoException extends Exception {

    public ClienteNaoEncontradoException() {
        super("Nenhum cliente encontrado");
    }
}
