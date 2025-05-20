package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.services.ProdutosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public List<ProdutosModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarPorId(@PathVariable long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProdutosModel criarProduto(@RequestBody ProdutosModel produtosModel) {
        return service.criar(produtosModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id){
        if (!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProdutosModel> atualizar(@PathVariable long id, @RequestBody ProdutosModel produtoNovo){
        if (!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        
        ProdutosModel produtoExistente = service.buscarPorId(id).get();
        produtoExistente.setNome(produtoNovo.getNome());
        produtoExistente.setPreco(produtoNovo.getPreco());
        produtoExistente.setQuantidade(produtoNovo.getQuantidade());
        produtoExistente.setDescricao(produtoNovo.getDescricao());

        return ResponseEntity.ok(service.atualizar(id, produtoExistente));
    }
    
    
}
