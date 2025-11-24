# Sistema-de-moeda-estudantil 🪙💵

---

# Alunos 👪

- Cauê Afonso Moraes
- Thomas Ramos de Oliveira
- Vinicius Gomes Rodrigues
- Vitor Veiga Silva

---

## Diagramas do Projeto

Clique [aqui](https://github.com/vitorveigas/Sistema-de-moeda-estudantil/tree/main/Diagramas) para acessar os diagramas do projeto, incluindo diagramas de classes, casos de uso, pacotes, componentes e implantação.

---

## Histórias de Usuário

Clique [aqui](https://github.com/vitorveigas/Sistema-de-moeda-estudantil/blob/main/docs/historias-de-usuario.md) para acessar as histórias de usuário do projeto, detalhando os requisitos e funcionalidades do sistema sob a perspectiva dos usuários finais.

---

## 🛠️ Tecnologias e Arquitetura

Este projeto foi desenvolvido utilizando as seguintes tecnologias, padrões e camadas arquiteturais:

### 🧪 Tecnologias Utilizadas

- **Java** – Linguagem de programação principal utilizada no backend.
- **Spring Boot** – Framework para criação de aplicações Java robustas, com configuração simplificada e suporte a boas práticas de desenvolvimento web e APIs REST.
- **PostgreSQL** – Banco de dados relacional utilizado para armazenar informações de usuários, pedidos, automóveis e contratos.
- **Maven** – Gerenciador de dependências e automação de build para projetos Java.
- **Spring Data JPA** – Abstração para comunicação com o banco de dados relacional, utilizando repositórios baseados em interfaces.
- **JavaScript** - Para fazer a conexão entre o back-end e o front-end.
- **HTML e CSS** - Para a estilização das páginas 
- **EmailJS** - Para o envio de e-mails.

---

### 🧱 Arquitetura do Sistema

O sistema segue o padrão **MVC (Model-View-Controller)**, complementado com as camadas de **DTO**, **Service**, **Repository** e **Facade**, promovendo uma arquitetura limpa, modular e de fácil manutenção.

#### 📦 Camadas da Aplicação

- **Controller**
  - Responsável por receber as requisições HTTP dos usuários (clientes ou agentes).
  - Converte os dados recebidos em objetos apropriados (DTOs) e delega a lógica de negócio para a camada `Service`.

- **DTO (Data Transfer Object)**
  - Objetos simples usados para transportar dados entre o frontend e o backend.
  - Evitam expor diretamente as entidades do modelo de domínio nas interfaces públicas da API.

- **Facade**
  - Camada intermediária que atua como **fachada** para orquestrar chamadas aos `Services`.
  - Centraliza fluxos mais complexos, agregando chamadas a múltiplos serviços quando necessário.

- **Service**
  - Contém a **lógica de negócio** da aplicação.
  - Realiza validações, regras de negócio e chamadas a outros serviços, se necessário.

- **Repository**
  - Interface que estende `JpaRepository` ou `CrudRepository`, fornecendo acesso ao banco de dados.
  - Responsável por executar operações de CRUD (Create, Read, Update, Delete) nas entidades.

- **Model (Entidades)**
  - Representam as tabelas do banco de dados.
  - Contêm os atributos principais de cada entidade do domínio: usuário, pedido, contrato, automóvel, etc.

---

### 🔗 Integração com o Banco de Dados

- O sistema utiliza o **PostgreSQL** como banco de dados relacional.
- As entidades do modelo são mapeadas com **JPA (Java Persistence API)**.
- As operações de persistência (inserir, atualizar, consultar e deletar) são realizadas através dos `Repositories`.

---

### 📐 Benefícios da Arquitetura

- **Manutenibilidade**: Separação clara de responsabilidades facilita alterações e testes.
- **Escalabilidade**: Facilidade para adicionar novos módulos ou fluxos complexos sem afetar outras partes do sistema.
- **Reutilização**: Serviços e DTOs podem ser reutilizados em diferentes partes da aplicação.
- **Segurança**: Exposição controlada de dados via DTOs, evitando leaks de entidades do domínio.

---

### Ferramentas Utilizadas

- **VSCode**: Editor de código leve e multiplataforma, com suporte a extensões e integração com sistemas de versionamento.
- **Drawio**: Ferramenta online para criação de diagramas, fluxogramas e modelagens visuais.
- **AstahUML**: Software para modelagem UML, auxiliando na representação de classes, casos de uso e diagramas de sequência.
- **GitHub**: Plataforma de hospedagem e versionamento de código baseada em Git, que facilita o trabalho colaborativo em equipe.

---

## Licença

Este projeto está licenciado sob a [MIT License](./LICENSE).
Você pode usar, modificar e distribuir este código, desde que os **devidos créditos sejam dados**, com link para o [original repository](https://github.com/vitorveigas/Sistema-de-moeda-estudantil/tree/main). 
Este projeto foi desenvolvido por [Caue Afonso](https://github.com/caueafonsomoraes), [Thomás Ramos](https://github.com/Thomasramos02), [Vinícius Gomes](https://github.com/viniciusgomesrod) e [Vitor Veiga](https://github.com/vitorveigas).

---

## Como rodar o projeto (Windows)

Requisitos
- Java 17+ (ou a versão exigida pelo projeto)
- Maven 3.6+
- PostgreSQL (ou Docker)
- Git (opcional)

1) Preparar o banco de dados (PostgreSQL)
- Criar database e usuário:
  - Abra o psql ou pgAdmin e execute:
    CREATE DATABASE moeda_estudantil;
    CREATE USER app_user WITH PASSWORD 'senha';
    GRANT ALL PRIVILEGES ON DATABASE moeda_estudantil TO app_user;

- Alternativa com Docker (PowerShell/CMD):
  docker run --name pg-moeda -e POSTGRES_DB=moeda_estudantil -e POSTGRES_USER=app_user -e POSTGRES_PASSWORD=senha -p 5432:5432 -d postgres:15

2) Configurar propriedades de conexão
- Edite src/main/resources/application.properties (ou defina variáveis de ambiente):
  ```properties
  spring.datasource.url=jdbc:postgresql://localhost:5432/moeda_estudantil
  spring.datasource.username=app_user
  spring.datasource.password=senha

  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true

  server.port=8080
  ```
- Como variáveis de ambiente (PowerShell):
  $env:SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/moeda_estudantil"
  $env:SPRING_DATASOURCE_USERNAME="app_user"
  $env:SPRING_DATASOURCE_PASSWORD="senha"

3) Build e execução
- Rodar diretamente com Maven:
  mvn clean package -DskipTests
  mvn spring-boot:run

- Ou executar o JAR gerado:
  java -jar target/*.jar

4) Testes
- Executar testes:
  mvn test

5) Observações
- Ajuste as propriedades (porta, usuário, senha) conforme necessário.
- Se usar uma IDE (VSCode/IntelliJ), importe o projeto como Maven e rode a classe principal Spring Boot.
- Logs e SQL aparecem conforme spring.jpa.show-sql
