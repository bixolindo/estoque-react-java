package com.example.estoque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estoque.dto.FornecedorDto;
import com.example.estoque.dto.LocalidadeDto;
import com.example.estoque.model.Fornecedor;
import com.example.estoque.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private LocalidadeService localidadeService;

    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<FornecedorDto> getAllFornecedores() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();

        // Obter lista única de códigos de país
        Set<String> codigosLocais = fornecedores.parallelStream()
                .map(Fornecedor::getCodigoPais)
                .collect(Collectors.toSet());

        // Buscar dados dos países em lotes
        List<LocalidadeDto> locais = localidadeService.getCountriesByCodes(new ArrayList<>(codigosLocais));

        // Mapear código do país para objeto Country
        Map<String, LocalidadeDto> map = locais.stream()
                .collect(Collectors.toMap(LocalidadeDto::getCca2, local -> local));

        // Mapear fornecedores para DTOs e agregar dados dos países
        List<FornecedorDto> fornecedorDTOs = fornecedores.parallelStream().map(fornecedor -> {
            LocalidadeDto country = map.get(fornecedor.getCodigoPais());
            String countryName = country.getTranslations().get("por").getCommon();
            String flagUrl = country.getFlags().getPng();
            return new FornecedorDto(fornecedor, countryName, flagUrl);
        }).collect(Collectors.toList());

        return fornecedorDTOs;
    }

    public Optional<FornecedorDto> getFornecedorById(UUID id) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if (fornecedor.isPresent()) {
            LocalidadeDto local = localidadeService.getCountryByCode(fornecedor.get().getCodigoPais()).get(0);
            return Optional.ofNullable(new FornecedorDto(fornecedor.get(),
                    local.getTranslations().get("por").getCommon(), local.getFlags().getPng()));
        }
        return null;
    }

    public void deleteFornecedor(UUID id) {
        fornecedorRepository.deleteById(id);
    }
}
