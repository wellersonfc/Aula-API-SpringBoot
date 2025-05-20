package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.servicer.ProdutoService;

@RestController

@RequestMapping("/api/produtos") 
public class ProdutosController {

 @Autowired
 private ProdutoService service;

    @GetMapping
    public List<ProdutosModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                     .map(ResponseEntity::ok) 
                     .orElse(ResponseEntity.notFound().build()); 
    }

    @PostMapping
    public ProdutosModel salvar(@RequestBody ProdutosModel pessoasModel) {
        return service.salvar(pessoasModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosModel> atualizar(@PathVariable Long id, @RequestBody ProdutosModel produtosModel) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtosModel.setId(id);
        return ResponseEntity.ok(service.salvar(produtosModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        if (!service.buscarPorId(id).isPresent()) {

            return ResponseEntity.notFound().build();

        }

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}

