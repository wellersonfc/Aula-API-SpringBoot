package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.ProdutosModel;
import com.example.cadastro_pessoas.servicer.ProdutosService;

// Anotação que define esta classe como um Controller REST
@RestController

// Caminho base para todas as requisições deste controller
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService serviceProdutos;
    
    @GetMapping
    public List<ProdutosModel> listarTodos() {
        return serviceProdutos.ListarTodosProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarPorId(@PathVariable Long id) {
        return serviceProdutos.ListarProdutoPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProdutosModel salvar(@RequestBody ProdutosModel produto) {
        return serviceProdutos.CadastrarProduto(produto);
    }



}
