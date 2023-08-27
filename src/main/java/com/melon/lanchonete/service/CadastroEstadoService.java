package com.melon.lanchonete.service;

import com.melon.lanchonete.exception.EntidadeNaoEncontradaException;
import com.melon.lanchonete.model.Estado;
import com.melon.lanchonete.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void remover(Long estadoID) {
        try{
            estadoRepository.deleteById(estadoID);
        }
        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro" + "de um estado com código %d", estadoID));
        }
        catch (DataIntegrityViolationException e){
            throw new com.melon.lanchonete.exception.DataIntegrityViolationException("Esse estado tem uma cidade associada, portanto não deve ser deletado!");
        }
    }
}