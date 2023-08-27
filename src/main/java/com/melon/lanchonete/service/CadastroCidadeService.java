package com.melon.lanchonete.service;

import com.melon.lanchonete.model.Cidade;
import com.melon.lanchonete.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade salvar(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    public void remover(Long id){
        cidadeRepository.deleteById(id);
    }
}
