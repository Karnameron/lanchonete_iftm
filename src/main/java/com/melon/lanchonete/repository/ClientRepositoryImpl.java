package com.melon.lanchonete.repository;

import com.melon.lanchonete.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientRepositoryImpl implements ClientRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cliente> findAll(){return manager.createQuery("from Cliente",Cliente.class).getResultList();
    }
    @Override
    public Cliente findById(Long id){
        return manager.find(Cliente.class, id);
    }
    @Override
    @Transactional
    public void removeById(Long id){
        System.out.println("cliente: "+id);
        Cliente cliente = findById(id);
        manager.remove(cliente);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente){
        System.out.println("cliente: "+cliente.getId());
        return manager.merge(cliente);
    }


}
