package com.melon.lanchonete.service;

import com.melon.lanchonete.model.Cliente;
import com.melon.lanchonete.model.Estado;
import com.melon.lanchonete.repository.ClientRepository;
import com.melon.lanchonete.repository.EstadoRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClientRepository clientRepository;

    public Cliente salvar(Cliente cliente){
        return clientRepository.save(cliente);
    }

    public void remover(Long id){
        clientRepository.removeById(id);
    }

}
