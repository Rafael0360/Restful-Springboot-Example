package br.rafael.example.webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ClienteJaCadastradoException extends  Exception{

    public ClienteJaCadastradoException() {
        super("cliente já cadastrado com aquele cpf");
    }
}
