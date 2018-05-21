package br.rafael.example.webservice.service;

import br.rafael.example.webservice.domain.Cliente;
import br.rafael.example.webservice.exception.ClienteJaCadastradoException;
import br.rafael.example.webservice.gerenciador.GerenciadorClientes;
import br.rafael.example.webservice.exception.ClienteNaoEncontadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço que realiza a lógica de negócio do controller
 */
@Service
public class ClienteService {

    /**
     * Injeta o gerenciador de clientes
     */
    @Autowired
    private GerenciadorClientes gerenciadorClientes;

    /**
     * Consulta todos os clientes
     * @return lista com clientes
     */
    public List buscarTodos(){
        return this.gerenciadorClientes.getTodosClientes();
    }

    /**
     * Busca um cliente com aquele CPF
     * @param cpf
     * @return
     * @throws ClienteNaoEncontadoException
     */
    public Cliente buscarPeloCpf(String cpf) throws ClienteNaoEncontadoException {
        Cliente cliente = this.gerenciadorClientes.getClientePeloCPF(cpf);
        if(cliente == null){
            throw new ClienteNaoEncontadoException();
        }
        return cliente;
    }

    /**
     * Salva um novo cliente, caso o cpf seja novo
     * @param cliente
     */
    public void salvarCliente(Cliente cliente) throws ClienteJaCadastradoException {
        if(exiteClienteComAqueleCPF(cliente.getCpf())){
            throw new ClienteJaCadastradoException();
        }
        this.gerenciadorClientes.addCliente(cliente);
    }

    /**
     * verifica se existe um cliente com aquele cpf
     * @param cpf
     * @return
     */
    private boolean exiteClienteComAqueleCPF(String cpf){
        if(this.gerenciadorClientes.getClientePeloCPF(cpf) != null){
            return true;
        }
        return false;
    }

}
