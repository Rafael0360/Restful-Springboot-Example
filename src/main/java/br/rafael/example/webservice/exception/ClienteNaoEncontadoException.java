package br.rafael.example.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ClienteNaoEncontadoException extends Exception {

    public ClienteNaoEncontadoException() {
        super("Nenhum cliente encontrado");
    }
}
