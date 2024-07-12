package com.example.estoque.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.estoque.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
}

