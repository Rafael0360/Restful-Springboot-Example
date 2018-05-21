package br.rafael.example.webservice.controller;


import br.rafael.example.webservice.domain.Cliente;
import br.rafael.example.webservice.exception.ClienteNaoEncontradoException;
import br.rafael.example.webservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Classe para mapear end-points
 */
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    /**
     * Injeção do service ClienteService
     */
    @Autowired
    private ClienteService clienteService;

    /**
     * retorna todos os clientes
     * @return lista de clientes
     */
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Cliente> getAllClientes(){
        List<Cliente> lista = this.clienteService.buscarTodos();
        return lista;
    }

    /**
     * Retorna o respectivo cliente pelo cpf
     * @param cpf
     * @return cliente
     * @throws ClienteNaoEncontradoException
     */
    @GetMapping("/{cpf}")
    @ResponseStatus(value = HttpStatus.OK)
    public Cliente getClientePorCpf(@PathVariable("cpf") String cpf)
            throws ClienteNaoEncontradoException {

        Cliente cliente = this.clienteService.buscarPeloCpf(cpf);
        return cliente;
    }

    /**
     * Adiciona um novo cliente
     * @param cliente
     * @return
     */
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void salvarCliente(@Valid @NotNull @RequestBody Cliente cliente){
        this.clienteService.salvarCliente(cliente);
    }

}
