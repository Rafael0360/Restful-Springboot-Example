package br.rafael.example.webservice.service;

import br.rafael.example.webservice.domain.Cliente;
import br.rafael.example.webservice.domain.GerenciadorClientes;
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

    public Cliente buscarPeloCpf(String cpf){
        return this.gerenciadorClientes.getClientePorCpf(cpf);
    }

    public void salvarCliente(Cliente cliente){
        this.gerenciadorClientes.addCliente(cliente);
    }

}
