package com.melon.lanchonete.repository;

import com.melon.lanchonete.model.Cliente;

import java.util.List;

public interface ClientRepository {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);
    void removeById(Long id);
}
