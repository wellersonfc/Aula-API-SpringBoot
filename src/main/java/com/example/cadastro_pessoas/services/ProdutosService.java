package com.example.cadastro_pessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.repository.ProdutosRepository;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ProdutosModel> buscarPorId(long id){
        return repository.findById(id);

    }

    public ProdutosModel criar(ProdutosModel produtosModel){
        return repository.save(produtosModel);
    }
    
    public ProdutosModel atualizar(long id, ProdutosModel produtosModel){
        return repository.save(produtosModel);
    }
    

    public void deletar(long id){
        repository.deleteById(id);
    }
}
