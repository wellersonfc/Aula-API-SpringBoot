package com.example.cadastro_pessoas.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "itens_compra")
@AllArgsConstructor @NoArgsConstructor
public class ItensCompraModel {

    @Id
    @Column(name = "id_item_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    private ComprasModel compraId;

    @ManyToMany
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private ProdutosModel produtoId;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "preco_unitario")
    private double precoUnitario;
}
