package com.example.cadastro_pessoas.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // Interface que fornece métodos prontos para CRUD

import com.example.cadastro_pessoas.model.ProdutosModel; // Anotação para identificar como um repositório


@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
}
