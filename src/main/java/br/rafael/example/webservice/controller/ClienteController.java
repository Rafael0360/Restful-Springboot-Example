package br.rafael.example.webservice.controller;


import br.rafael.example.webservice.domain.Cliente;
import br.rafael.example.webservice.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> lista = this.clienteService.buscarTodos();
        return new ResponseEntity<List<Cliente>>(lista, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> getClientePorCpf(@PathVariable("cpf") String cpf){
        Cliente cliente = this.clienteService.buscarPeloCpf(cpf);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity salvarCliente(Cliente cliente){
        this.clienteService.salvarCliente(cliente);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
