package com.fecaf.estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table(name = "veiculos")
@Data  
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    private String marca;
    
    private Integer ano;
    
    private String cor;
    
    private Double preco;
    
    private Integer quilometragem;
    
    private String status; // Ex: DISPONIVEL, VENDIDO
}