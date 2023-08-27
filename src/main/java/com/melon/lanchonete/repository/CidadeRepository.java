package com.melon.lanchonete.repository;

import com.melon.lanchonete.model.Cidade;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> findAll();
    public  Cidade findById(Long id);
    public Cidade save( Cidade cidade);
    public void deleteById(Long id);

}
