package com.example.cadastro_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.cadastro_pessoas.model.CompraModel;
import com.example.cadastro_pessoas.servicer.CompraService;
@RestController
@RequestMapping("/api/compra")
public class CompraController {

    @Autowired
    private CompraService service;

    @GetMapping
    public List<CompraModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompraModel salvar(@RequestBody CompraModel compraModel) {
        return service.salvar(compraModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompraModel> atualizar(@PathVariable Long id, @RequestBody CompraModel compraModel) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        compraModel.setId(id);
        return ResponseEntity.ok(service.salvar(compraModel));
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
