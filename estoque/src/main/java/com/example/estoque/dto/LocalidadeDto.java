package com.example.estoque.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalidadeDto {
    private Map<String, Translation> translations;
    private Flag flags;
    private String cca2;

    @Data
    public static class Translation {
        private String common;
    }

    @Data
    public static class Flag {
        private String png;
    }

}
