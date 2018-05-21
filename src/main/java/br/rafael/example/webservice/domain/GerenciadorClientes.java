package br.rafael.example.webservice.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GerenciadorClientes {

    private List<Cliente> clientes;

    public GerenciadorClientes(){
        clientes = new ArrayList<Cliente>();
    }

    public void addCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void rmCliente(Cliente cliente){
        this.clientes.remove(cliente);
    }

    public Cliente getClientePorCpf(String cpf){
        for(Cliente c : this.clientes){
            if(c != null && c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public List getTodosClientes(){
        return this.clientes;
    }

}
