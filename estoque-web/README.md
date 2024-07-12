# Projeto de Estoque - React TypeScript

Este é um projeto de exemplo de uma aplicação de estoque utilizando React com TypeScript.

## Requisitos

Antes de começar, certifique-se de ter o Node.js e npm (ou yarn) instalados em sua máquina.

- [Node.js](https://nodejs.org/)
- [npm](https://www.npmjs.com/) ou [yarn](https://yarnpkg.com/)

## Instalação

Instale as dependências do projeto : npm install (ou yarn install)

## Variáveis de Ambiente

Crie um arquivo .env na raiz do projeto e adicione suas variáveis de ambiente conforme necessário. Aqui está um exemplo:

REACT_APP_API_URL=http://localhost:8081/api

Para iniciar a aplicação em modo de desenvolvimento, execute o comando npm start (ou yarn start)

## APIs
Esta aplicação consome uma API REST para gerenciar produtos. Certifique-se de que o backend esteja configurado e em execução. Aqui está um exemplo de endpoint esperado:

GET /api/produtos: Retorna uma lista paginada de produtos.
