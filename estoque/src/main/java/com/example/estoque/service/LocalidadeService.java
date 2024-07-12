package com.example.estoque.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.estoque.dto.LocalidadeDto;

@Service
public class LocalidadeService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable("countries")
    public List<LocalidadeDto> getCountryByCode(String code) {
        String url = "https://restcountries.com/v3.1/alpha/" + code;
        LocalidadeDto[] response = restTemplate.getForObject(url, LocalidadeDto[].class);
        return Arrays.asList(response);
    }

    @Cacheable("countries")
    public List<LocalidadeDto> getCountriesByCodes(List<String> codes) {
        String codesParam = String.join(",", codes);
        String url = "https://restcountries.com/v3.1/alpha?codes=" + codesParam;
        return Arrays.asList(restTemplate.getForObject(url, LocalidadeDto[].class));
    }

    @Cacheable("countries")
    public List<LocalidadeDto> getAllCountries() {
        String url = "https://restcountries.com/v3.1/all";
        return Arrays.asList(restTemplate.getForObject(url, LocalidadeDto[].class));
    }
}
