package com.fecaf.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fecaf.estoque.model.Veiculo;
import com.fecaf.estoque.repository.VeiculoRepository;

@RestController 
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*") // Permite que a interface HTML acesse a API
public class VeiculoController {

    @Autowired 
    private VeiculoRepository repository;

    // 1. LISTAR TODOS (Read)
    @GetMapping
    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    // 2. CADASTRAR NOVO (Create)
    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return repository.save(veiculo);
    }

    // 3. ATUALIZAR INFORMAÇÕES (Update) - Exigência do PDF
    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo detalhes) {
        return repository.findById(id).map(veiculo -> {
            veiculo.setPreco(detalhes.getPreco());
            veiculo.setQuilometragem(detalhes.getQuilometragem());
            veiculo.setStatus(detalhes.getStatus());
            return repository.save(veiculo);
        }).orElse(null);
    }

    // 4. DELETAR POR ID (Delete)
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
    // 5. BUSCAR POR ID
    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // 6. FILTRO POR MARCA - Exigência do PDF
    @GetMapping("/filtro")
    public List<Veiculo> filtrarPorMarca(@RequestParam String marca) {
        return repository.findByMarcaContainingIgnoreCase(marca);
    }
}