package com.melon.lanchonete.controller;
import com.melon.lanchonete.model.Cidade;
import com.melon.lanchonete.repository.CidadeRepository;
import com.melon.lanchonete.service.CadastroCidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private CadastroCidadeService cadastroCidadeService;

    @GetMapping
    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }

    @GetMapping("/{cidadeId}")
    public Cidade listarPorId(@PathVariable Long cidadeId){
        return cidadeRepository.findById(cidadeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade adicionar(@RequestBody Cidade estado){
        return cadastroCidadeService.salvar(estado);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long estadoId){
        cadastroCidadeService.remover(estadoId);
    }

}
