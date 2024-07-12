package com.example.estoque.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.estoque.dto.FornecedorDto;
import com.example.estoque.dto.LocalidadeDto;
import com.example.estoque.model.Fornecedor;
import com.example.estoque.service.FornecedorService;
import com.example.estoque.service.LocalidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FornecedorControllerTest {

    @Mock
    private FornecedorService fornecedorService;

    @InjectMocks
    private FornecedorController fornecedorController;

    @Mock
    private LocalidadeService localidadeService;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private FornecedorDto fornecedor1;
    private Fornecedor fornecedorInsert;
    private Fornecedor fornecedorUpdate;
    private Fornecedor fornecedorDelete;
    private LocalidadeDto localidadeDto1;
    private LocalidadeDto localidadeDto2;

    UUID idFornecedorExistente = UUID.fromString("e89823f8-cc14-4317-9d33-59c89b2686d9");
    UUID idFornecedorUpdate = UUID.fromString("d68304ac-650a-4a65-bcd9-ecfb6f0272a0");
    UUID idFornecedorDelete = UUID.fromString("7d24a681-e32d-4d63-ad2f-abdeba951cbd");

    @BeforeEach
    public void setup() {

        fornecedorInsert = new Fornecedor();
        fornecedorInsert.setNome("Fornecedor Novo 4");
        fornecedorInsert.setCodigoPais("BR");

        fornecedorUpdate = new Fornecedor();
        fornecedorUpdate.setId(idFornecedorUpdate);
        fornecedorUpdate.setNome("Fornecedor Atualizadoo");
        fornecedorUpdate.setCodigoPais("BR");

        fornecedorDelete = new Fornecedor();
        fornecedorDelete.setId(idFornecedorDelete);

        localidadeDto1 = new LocalidadeDto();
        localidadeDto1.setCca2("BR");
        LocalidadeDto.Translation translation1 = new LocalidadeDto.Translation();
        translation1.setCommon("Brasil");
        localidadeDto1.setTranslations(Map.of("por", translation1));
        LocalidadeDto.Flag flag1 = new LocalidadeDto.Flag();
        flag1.setPng("https://flagcdn.com/w320/br.png");
        localidadeDto1.setFlags(flag1);

        localidadeDto2 = new LocalidadeDto();
        localidadeDto2.setCca2("US");
        LocalidadeDto.Translation translation2 = new LocalidadeDto.Translation();
        translation2.setCommon("Estados Unidos");
        localidadeDto2.setTranslations(Map.of("por", translation2));
        LocalidadeDto.Flag flag2 = new LocalidadeDto.Flag();
        flag2.setPng("https://flagcdn.com/w320/us.png");
        localidadeDto2.setFlags(flag2);

        fornecedor1 = new FornecedorDto(idFornecedorExistente, "Fornecedor Exemplo", "BR", translation1.getCommon(),
                flag1.getPng());

        List<LocalidadeDto> countries = Arrays.asList(localidadeDto1, localidadeDto2);

        Mockito.lenient().when(localidadeService.getCountriesByCodes(ArgumentMatchers.anyList()))
                .thenReturn(countries);
    }

    @Test
    public void testGetCountriesByCodes() {
        List<LocalidadeDto> result = localidadeService.getCountriesByCodes(Arrays.asList("BR", "US"));

        assertEquals(2, result.size());
        assertEquals("BR", result.get(0).getCca2());
        assertEquals("Brasil", result.get(0).getTranslations().get("por").getCommon());
        assertEquals("https://flagcdn.com/w320/br.png", result.get(0).getFlags().getPng());
        assertEquals("US", result.get(1).getCca2());
        assertEquals("Estados Unidos", result.get(1).getTranslations().get("por").getCommon());
        assertEquals("https://flagcdn.com/w320/us.png", result.get(1).getFlags().getPng());
    }

    @Test
    public void testGetFornecedorById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/fornecedores/{id}", fornecedor1.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(fornecedor1.getId().toString()));
    }

    @Test
    public void testCreateFornecedor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/fornecedores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fornecedorInsert)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateFornecedor() throws Exception {
        fornecedorUpdate.setNome("Fornecedor Atualizado 2");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/fornecedores/{id}", fornecedorUpdate.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fornecedorUpdate)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Fornecedor Atualizado 2"));
    }

    @Test
    public void testDeleteFornecedor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/fornecedores/{id}", fornecedorDelete.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
