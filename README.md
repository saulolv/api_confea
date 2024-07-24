# Documentação do Projeto API CONFEA

## Visão Geral

Este projeto é uma aplicação Spring Boot desenvolvida para a gestão profissional dos títulos, carteiras e universidades no contexto do CONFEA (Conselho Federal de Engenharia e Agronomia). A aplicação permite o cadastro, atualização, remoção e consulta de informações relacionadas a cursos, títulos acadêmicos, carteiras profissionais e universidades.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.3.2
- Gradle
- Spring Data JPA
- Spring Security
- OAuth2
- Swagger para documentação da API
- Lombok
- PostgreSQL

## Configuração do Projeto

### Pré-requisitos

- JDK 21
- Gradle
- PostgreSQL

### Passos para Configuração

1. Clone o repositório do projeto.
2. Configure o PostgreSQL criando um banco de dados para o projeto.
3. Atualize o arquivo `src/main/resources/application.properties` com as configurações do seu banco de dados (URL, usuário e senha).
4. Execute o comando `gradle bootRun` para iniciar a aplicação.

## Estrutura do Projeto

O projeto está organizado nas seguintes pacotes principais:

- `model`: Contém as classes de entidade que representam as tabelas do banco de dados.
- `repository`: Contém as interfaces do Spring Data JPA para operações CRUD nas entidades.
- `service`: Contém a lógica de negócio e a interação com os repositórios.
- `controller`: Contém os controladores que expõem endpoints da API REST.

## Endpoints da API

A documentação detalhada dos endpoints da API está disponível através do Swagger, acessível em `http://localhost:8080/swagger-ui.html` após iniciar a aplicação.

## Segurança

A aplicação utiliza Spring Security e OAuth2 para autenticação e autorização, garantindo que apenas usuários autenticados possam acessar determinados endpoints.
