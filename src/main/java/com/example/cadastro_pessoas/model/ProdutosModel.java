package com.example.cadastro_pessoas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "produtos")
@AllArgsConstructor @NoArgsConstructor
public class ProdutosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_produto", nullable = false, length = 100)
    private String nome;

    @Column(name = "preco_produto", nullable = false)
    private double preco;

    @Column(name = "quantidade_estoque", nullable = false)
    private int quantidade;

    @Column(name = "descricao_produto")
    private String descricao;

}
