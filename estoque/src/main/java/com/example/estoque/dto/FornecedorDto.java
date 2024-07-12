package com.example.estoque.dto;

import java.util.UUID;

import com.example.estoque.model.Fornecedor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FornecedorDto {

    public FornecedorDto(Fornecedor fornecedor, String countryName, String flagUrl) {
        this.id = fornecedor.getId();
        this.nome = fornecedor.getNome();
        this.codigoPais = fornecedor.getCodigoPais();
        this.nomePais = countryName;
        this.bandeiraPais = flagUrl;
    }

    private UUID id;
    private String nome;
    private String codigoPais;
    private String nomePais;
    private String bandeiraPais;

}
