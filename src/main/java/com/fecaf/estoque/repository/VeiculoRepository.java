package com.fecaf.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fecaf.estoque.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
    // Método para permitir a busca por marca no banco de dados
    List<Veiculo> findByMarcaContainingIgnoreCase(String marca);
    
}