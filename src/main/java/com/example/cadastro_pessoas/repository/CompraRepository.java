package com.example.cadastro_pessoas.repository;

import com.example.cadastro_pessoas.model.CompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<CompraModel, Long> {
    // Não precisa de implementação, o Spring Data JPA cuida disso automaticamente
}
