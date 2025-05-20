package com.example.cadastro_pessoas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Getter@Setter
public class CompraModel {
    
@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private LocalDateTime dataCompra;

@ManyToOne
@JoinColumn(name = "Pessoaid", referencedColumnName = "Cliente", unique = false, nullable = false)
    private PessoasModel PessoasModelID;



 public void setId(Long id2) {
    throw new UnsupportedOperationException("Unimplemented method 'setId'");
 }   
}
