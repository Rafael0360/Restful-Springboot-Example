package br.rafael.example.webservice.service;

import br.rafael.example.webservice.domain.Cliente;
import br.rafael.example.webservice.domain.GerenciadorClientes;
import br.rafael.example.webservice.exception.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private GerenciadorClientes gerenciadorClientes;

    public List buscarTodos(){
        return this.gerenciadorClientes.getTodosClientes();
    }

    public Cliente buscarPeloCpf(String cpf) throws ClienteNaoEncontradoException {
        Cliente cliente = this.gerenciadorClientes.getClientePorCpf(cpf);
        if(cliente == null){
            throw new ClienteNaoEncontradoException();
        }
        return cliente;
    }

    public void salvarCliente(Cliente cliente){
        this.gerenciadorClientes.addCliente(cliente);
    }

}
