package com.example.cadastro_pessoas.model;

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
public class ItemCompraModel {
    
@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "Compraid", referencedColumnName = "Compra", unique = false, nullable = false)
    private ItemCompraModel compraModelID;

@JoinColumn(name = "Produto_id", referencedColumnName = "produto", unique = false, nullable = false)
    private ItemCompraModel produtoID;

    @JoinColumn(name = "Quantidade", referencedColumnName = "quantidade", unique = false, nullable = false)
    private ItemCompraModel quatidadeID;



 public void setId(Long id2) {
    throw new UnsupportedOperationException("Unimplemented method 'setId'");
 }   
}
