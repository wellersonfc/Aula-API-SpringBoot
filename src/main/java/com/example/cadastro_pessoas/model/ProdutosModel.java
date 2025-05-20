package com.example.cadastro_pessoas.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
public class ProdutosModel {
    
@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String name;

 @Column(nullable = false)
    private BigDecimal preço;

 @Column(nullable = false)
    private BigDecimal Quantidadeestoque; 
    
 @Column(nullable = false)
    private String descrição;

 public void setId(Long id2) {
    throw new UnsupportedOperationException("Unimplemented method 'setId'");
 }   
}
