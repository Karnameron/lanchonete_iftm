package com.melon.lanchonete.repository;

import com.melon.lanchonete.model.Cidade;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> findAll() {
        return manager.createQuery("From Cidade",Cidade.class).getResultList();
    }

    @Override
    public Cidade findById(Long id) {
        return manager.find(Cidade.class,id);
    }

    @Override
    @Transactional
    public Cidade save(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

        System.out.println("Cidade: "+id);
        Cidade cidade = findById(id);
        manager.remove(cidade);


    }
}
