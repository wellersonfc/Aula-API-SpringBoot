package com.example.cadastro_pessoas.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.repository.ProdutosRepository;


@Service
public class ProdutoService {
    
    @Autowired
    private ProdutosRepository repository;

    /**
     * @return 
     */
    public List<ProdutosModel> listarTodos() {
        return repository.findAll();
    }

    /**
     * @param id 
     * @return
     */
    public Optional<ProdutosModel> buscarPorId(Long id) {
        
        return repository.findById(id);
    }

    /**
     * @param produtosModal 
     * @return
     */
    public ProdutosModel salvar(ProdutosModel produtosModal) {
        return repository.save(produtosModal);
    }

    /**
     * @param id 
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}


    

