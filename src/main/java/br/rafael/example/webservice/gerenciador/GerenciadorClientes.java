package br.rafael.example.webservice.gerenciador;

import br.rafael.example.webservice.domain.Cliente;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe consultar e adicionar clientes
 */
@Component
public class GerenciadorClientes {

    /**
     * Lista que representa todos os clientes
     */
    private List<Cliente> clientes;

    public GerenciadorClientes(){
        clientes = new ArrayList<Cliente>();
    }

    /**
     * Adicionar um novo cliente
     * @param cliente
     */
    public void addCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    /**
     * Remover um cliente pelo obj
     * @param cliente
     */
    public void rmCliente(Cliente cliente){
        this.clientes.remove(cliente);
    }

    /**
     * Remover um cliente pelo cpf
     * @param cpf
     */
    public void rmCliente(String cpf){
        Cliente cliente = getClientePeloCPF(cpf);
        this.clientes.remove(cliente);
    }

    /**
     * buscar um cliente pelo CPF
     * @param cpf
     * @return objeto cliente
     */
    public Cliente getClientePeloCPF(String cpf){
        for(Cliente c : this.clientes){
            if(c!= null && c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    /**
     * Retorna todos os clientes
     * @return
     */
    public List getTodosClientes(){
        return this.clientes;
    }

}
