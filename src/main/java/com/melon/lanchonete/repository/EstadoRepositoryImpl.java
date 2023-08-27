package com.melon.lanchonete.repository;

import com.melon.lanchonete.model.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Estado> findAll() {return manager.createQuery("From Estado ", Estado.class).getResultList();}

    @Override
    public Estado findById(Long id) {return manager.find(Estado.class, id);}

    @Override
    @Transactional
    public Estado save(Estado estado) {
        System.out.println("Estado: "+ estado.getNome());
        return manager.merge(estado);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Estado estado = findById(id);
        manager.remove(estado);
    }
}
