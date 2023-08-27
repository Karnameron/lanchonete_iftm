package com.melon.lanchonete.repository;

import com.melon.lanchonete.model.Cliente;
import com.melon.lanchonete.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> findAll();
    Estado findById(Long id);
    Estado save(Estado estado);
    void deleteById(Long id);

}
