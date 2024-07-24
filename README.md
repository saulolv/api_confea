# Documentação do Projeto API CONFEA

## Visão Geral

A **API CONFEA** é uma aplicação centralizada desenvolvida com Spring JAVA para gerenciar o sistema dos CREAs (Conselhos Regionais de Engenharia e Agronomia). Esta API visa unificar e centralizar a gestão de informações relacionadas aos profissionais.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação utilizada.
- **Spring Boot 3.3.2**: Framework para desenvolvimento da aplicação.
- **Gradle**: Ferramenta de automação de construção.
- **Spring Data JPA**: ORM para interação com o banco de dados.
- **Spring Security**: Framework para segurança e autenticação.
- **OAuth2**: Protocolo de autorização para proteger recursos.
- **Swagger**: Ferramenta para documentação e testes da API.
- **Lombok**: Biblioteca para reduzir o código boilerplate.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional.
- **Docker**: Plataforma para desenvolvimento, envio e execução de aplicações em contêineres.

## Configuração do Projeto

### Pré-requisitos

- **JDK 17**: Instalado e configurado no seu ambiente.
- **Gradle**: Para construção e execução do projeto.
- **PostgreSQL**: Servidor de banco de dados para armazenar os dados da aplicação.

### Passos para Configuração

1. **Clone o Repositório**:
   ```bash
   git clone <URL-do-repositório>
    ```
2. **Acesse o Diretório**:
3. **Construa o Projeto**:
   ```bash
   gradle build
   ```
4. **Execute a Aplicação**:
   ```bash
    gradle bootRun
    ```



## Utilizando Docker para execução

Para executar o projeto API CONFEA utilizando Docker, siga os passos abaixo:

1. **Preparação do Ambiente**:
   - Certifique-se de que o Docker e o Docker Compose estão instalados em seu sistema.
   - Clone o repositório do projeto para sua máquina local.

2. **Construção da Imagem Docker**:
   - Abra um terminal e navegue até o diretório raiz do projeto.
   - Execute o comando abaixo para construir a imagem Docker do projeto:
     ```bash
     docker build -t api-confea .
     ```

3. **Execução com Docker Compose**:
   - Utilize o arquivo `docker-compose.yml` para configurar e iniciar os serviços necessários (aplicação e banco de dados).
   - No diretório raiz do projeto, execute o comando:
     ```bash
     docker-compose up
     ```
   - Este comando irá iniciar todos os serviços definidos no `docker-compose.yml`, incluindo a aplicação e o banco de dados.

4. **Acesso à Aplicação**:
   - Após os contêineres estarem em execução, a aplicação estará acessível através do navegador ou cliente HTTP no endereço configurado (por padrão, `http://localhost:8080`).

5. **Encerramento da Aplicação**:
   - Para encerrar a aplicação e os serviços associados, utilize o comando:
     ```bash
     docker-compose down
     ```
   - Este comando irá parar e remover os contêineres criados pelo Docker Compose.

### Notas Adicionais
- Para reconstruir a imagem Docker após alterações no código, repita o passo 2.
- Utilize o Docker Compose para facilitar a gestão de múltiplos contêineres e serviços.

