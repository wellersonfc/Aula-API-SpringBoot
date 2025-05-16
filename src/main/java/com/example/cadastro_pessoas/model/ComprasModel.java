package com.example.cadastro_pessoas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name = "compras")
@AllArgsConstructor @NoArgsConstructor
public class ComprasModel {

    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "data_compra", nullable = false)
    private LocalDateTime DataHora;

    @OneToMany
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id")
    private PessoasModel pessoaId;

}
