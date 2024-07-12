package com.example.estoque.controller;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.estoque.model.Produto;
import com.example.estoque.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTest {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Produto produto;
    private Produto produtoInsert;
    private Produto produtoUpdate;
    private Produto produtoDelete;

    UUID idProdutoExistente = UUID.fromString("73f36598-514f-4698-8628-125ae6656a20");
    UUID idProdutoUpdate = UUID.fromString("66fb3953-4f81-475b-be47-da2dbbc6ad9e");
    UUID idProdutoDelete = UUID.fromString("258ad585-e1fa-44d1-b78a-116ae45395b9");

    @BeforeEach
    public void setup() {
        produtoInsert = new Produto();
        produtoInsert.setNome("Produto Novo 4");
        produtoInsert.setDescricao("Descrição do Produto Novo 4");
        produtoInsert.setPreco(BigDecimal.valueOf(10.5));
        produtoInsert.setQuantidade(10);
        produtoInsert.setCategoria("Categoria Novo 4");
        produtoInsert.setFornecedor(UUID.randomUUID());

        produto = new Produto();
        produto.setId(idProdutoExistente);
        produto.setNome("Produto Atualizado 1");
        produto.setDescricao("Descrição do Produto Exemplo");
        produto.setPreco(BigDecimal.valueOf(10.5));
        produto.setQuantidade(20);
        produto.setCategoria("Categoria Exemplo");
        produto.setFornecedor(UUID.randomUUID());

        produtoUpdate = new Produto();
        produtoUpdate.setId(idProdutoUpdate);
        produtoUpdate.setNome("Produto Atualizado");
        produtoUpdate.setDescricao("Descrição do Produto Atualizado");
        produtoUpdate.setPreco(BigDecimal.valueOf(10.5));
        produtoUpdate.setQuantidade(30);
        produtoUpdate.setCategoria("Categoria Atualizado");
        produtoUpdate.setFornecedor(UUID.randomUUID());

        produtoDelete = new Produto();
        produtoDelete.setId(idProdutoDelete);
    }

    @Test
    public void testGetProdutoById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/produtos/{id}", produto.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(produto.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(produto.getNome()));
    }

    @Test
    public void testCreateProduto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produtoInsert)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value(produtoInsert.getNome()));
    }

    @Test
    public void testUpdateProduto() throws Exception {
        produtoUpdate.setNome("Produto Atualizado 1");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/produtos/{id}", produto.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produtoUpdate)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Produto Atualizado 1"));
    }

    @Test
    public void testDeleteProduto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/produtos/{id}", produtoDelete.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
