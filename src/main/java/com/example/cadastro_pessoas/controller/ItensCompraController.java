package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro_pessoas.model.ItensCompraModel;
import com.example.cadastro_pessoas.services.ItensCompraService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/itens-compra")
public class ItensCompraController {

    @Autowired
    private ItensCompraService service;

    @GetMapping
    public List<ItensCompraModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensCompraModel> buscarPorId(@PathVariable long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ItensCompraModel criarCompra(@RequestBody ItensCompraModel itensCompraModelModel) {
        return service.criar(itensCompraModelModel);
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
    public ResponseEntity<ItensCompraModel> atualizar(@PathVariable long id, @RequestBody ItensCompraModel itensCompraModelModel) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itensCompraModelModel.setId(id);
        return ResponseEntity.ok(service.atualizar(id, itensCompraModelModel));
    }
    
    
}
