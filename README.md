# 🧪 API Petstore Automation

Projeto de automação de testes de API desenvolvido com **Java, Rest Assured e JUnit 5**, utilizando a API pública [Swagger Petstore](https://petstore.swagger.io/).

O objetivo do projeto é praticar automação de testes de API, validação de respostas e criação de cenários positivos e negativos.

## 🛠️ Tecnologias

- Java 21
- Rest Assured
- JUnit 5
- Hamcrest
- Maven
- Bruno
- IntelliJ IDEA

## 🔎 Cenários testados

### Usuários

- **POST /user**
    - Cadastro de usuário com dados válidos
    - Body inválido
    - Body vazio
    - Dados inválidos

- **POST /user/createWithArray**
    - Cadastro de múltiplos usuários

- **GET /user/{username}**
    - Consulta de usuário existente
    - Consulta de usuário inexistente

- **PUT /user/{username}**
    - Criação de usuário
    - Atualização dos dados
    - Consulta após atualização para validar o resultado

- **DELETE /user/{username}**
    - Exclusão de usuário existente
    - Exclusão de usuário inexistente
    - Consulta após exclusão para validar que o usuário não está mais disponível

### Autenticação

- **GET /user/login**
    - Criação de usuário
    - Login com username e password
    - Validação da resposta de login

- **GET /user/logout**
    - Validação da resposta do endpoint de logout

## 📁 Estrutura

```text
src
└── test
    └── java
        └── api_petstore
            ├── BaseTest.java
            ├── PostUserTest.java
            ├── PostUsersTest.java
            ├── GetUserTest.java
            ├── PutUserTest.java
            ├── DeleteUserTest.java
            ├── GetUserLoginTest.java
            └── GetLogoutUserTest.java

⚙️ Configuração

A classe BaseTest centraliza a configuração das requisições, incluindo:

URL base da API
Content-Type: application/json
▶️ Execução

Com o Maven instalado, execute:

mvn test

Para executar uma classe específica:

mvn test -Dtest=PostUserTest
✅ Validações

Os testes realizam validações de:

Status codes HTTP
Campos do response body
Mensagens retornadas pela API
Comportamentos esperados para cenários positivos e negativos
Estado do recurso após operações de atualização e exclusão
📌 Observação

O projeto utiliza a API pública Swagger Petstore. Por se tratar de uma API compartilhada, os dados disponíveis podem sofrer alterações externas.

👩‍💻 Sobre

Projeto desenvolvido como parte do meu portfólio de QA, com foco em testes de API e automação utilizando Java e Rest Assured.