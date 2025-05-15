
package com.example.cadastro_pessoas.servicer;
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

    //Listar Produtos
    public List<ProdutosModel> ListarTodosProdutos(){
        return repository.findAll();
    }

    //Listar por ID
    public Optional<ProdutosModel> ListarProdutoPorId(Long id){
        return repository.findById(id);
    }
    
    //cadastrar
    public ProdutosModel CadastrarProduto(ProdutosModel produtos){
        return repository.save(produtos);
    }

    //deletar
    public void DeletarProduto(Long id){
        repository.deleteById(id);
    }

}
