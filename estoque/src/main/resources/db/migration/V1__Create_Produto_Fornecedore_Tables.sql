CREATE TABLE fornecedor (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    codigo_pais VARCHAR(10) NOT NULL
);

CREATE TABLE produto (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco DECIMAL(19,2) NOT NULL,
    quantidade INTEGER NOT NULL,
    categoria VARCHAR(255),
    fornecedor_id UUID NOT NULL,
    data_criacao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT fk_produto_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor(id)
);
