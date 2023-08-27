package com.melon.lanchonete.controller;

import com.melon.lanchonete.repository.ClientRepository;
import com.melon.lanchonete.model.Cliente;
import com.melon.lanchonete.service.CadastroClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CadastroClienteService cadastroClienteService;

    @GetMapping
    public List<Cliente> listar(){
        return clientRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public Cliente buscar(@PathVariable Long clientId){
        return clientRepository.findById((clientId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar (@RequestBody Cliente cliente){
        return cadastroClienteService.salvar(cliente);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long clientId){
        cadastroClienteService.remover(clientId);
    }
}