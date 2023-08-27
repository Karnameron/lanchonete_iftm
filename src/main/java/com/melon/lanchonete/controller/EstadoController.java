package com.melon.lanchonete.controller;
import com.melon.lanchonete.model.Estado;
import com.melon.lanchonete.repository.EstadoRepository;
import com.melon.lanchonete.service.CadastroEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstadoService;

    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    Estado buscar(@PathVariable Long estadoId){
        return estadoRepository.findById(estadoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado salvar(@RequestBody Estado estado){
        return cadastroEstadoService.salvar(estado);
    }

    @DeleteMapping("/{deleteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long deleteId){
        cadastroEstadoService.remover(deleteId);
    }
}