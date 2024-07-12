package com.example.estoque.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.estoque.dto.FornecedorDto;
import com.example.estoque.model.Fornecedor;
import com.example.estoque.service.FornecedorService;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor novoFornecedor = fornecedorService.saveFornecedor(fornecedor);
        return ResponseEntity.ok(novoFornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDto>> getAllFornecedores() {
        List<FornecedorDto> fornecedores = fornecedorService.getAllFornecedores();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDto> getFornecedorById(@PathVariable UUID id) {
        Optional<FornecedorDto> fornecedor = fornecedorService.getFornecedorById(id);
        return fornecedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable UUID id, @RequestBody Fornecedor fornecedor) {
        if (!fornecedorService.getFornecedorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fornecedor.setId(id);
        Fornecedor fornecedorAtualizado = fornecedorService.saveFornecedor(fornecedor);
        return ResponseEntity.ok(fornecedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable UUID id) {
        if (!fornecedorService.getFornecedorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        fornecedorService.deleteFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
