package com.example.cadastro_pessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ItensCompraModel;
import com.example.cadastro_pessoas.repository.ItensCompraRepository;

@Service
public class ItensCompraService {

    @Autowired
    private ItensCompraRepository repository;

    public List<ItensCompraModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ItensCompraModel> buscarPorId(long id){
        return repository.findById(id);

    }

    public ItensCompraModel criar(ItensCompraModel itensCompraModel){
        return repository.save(itensCompraModel);
    }
    
    public ItensCompraModel atualizar(long id, ItensCompraModel itensCompraModel){
        return repository.save(itensCompraModel);
    }
    

    public void deletar(long id){
        repository.deleteById(id);
    }
}
