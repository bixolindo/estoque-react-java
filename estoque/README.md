# Estoque API

## Descrição

Este projeto é uma API para gerenciamento de fornecedores e suas localizações. A API permite a criação, leitura, atualização e exclusão de fornecedores, bem como a recuperação de informações de localização com base em códigos de país.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Validation
- H2 Database (para testes)
- Mockito (para testes unitários)
- JUnit 5
- RestTemplate

## Configuração do Projeto

### Pré-requisitos

- JDK 17 ou superior
- Maven 3.6 ou superior

### Clonando o Repositório

git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

### Configuração do Banco de Dados

O projeto utiliza o banco de dados em memória H2 para testes. A configuração do banco de dados está localizada no arquivo application.properties

### Executando a Aplicação
Para executar a aplicação, utilize o seguinte comando Maven:

mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

### Endpoints
# Fornecedores
GET /api/fornecedores - Retorna a lista de todos os fornecedores.
GET /api/fornecedores/{id} - Retorna um fornecedor específico por ID.
POST /api/fornecedores - Cria um novo fornecedor.
PUT /api/fornecedores/{id} - Atualiza um fornecedor existente por ID.
DELETE /api/fornecedores/{id} - Exclui um fornecedor por ID.

# Produtos 
GET /api/produtos - Retorna a lista de todos os produtos.
GET /api/produtos/{id} - Retorna um produto específico por ID.
POST /api/produtos - Cria um novo produto.
PUT /api/produtos/{id} - Atualiza um produto existente por ID.
DELETE /api/produtos/{id} - Exclui um produto por ID.

### Executando os Testes
Antes de executar os testes é indicado cadastrar alguns produtos e fornecedores e editar os arquivos de testes para IDS existentes 

Para executar os testes unitários, utilize o seguinte comando Maven:
mvn test


