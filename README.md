# 🌟 Sistema de Moeda Estudantil

Um projeto desenvolvido com foco em organização, arquitetura limpa e modernidade. Aqui você encontra tudo sobre o sistema, desde sua arquitetura, tecnologias usadas, diagramas até instruções para rodá-lo no seu ambiente.

https://moedas-estudantis.onrender.com/login.html
---

## 👥 Equipe de Desenvolvimento

* **Cauê Afonso Moraes**
* **Thomas Ramos de Oliveira**
* **Vinicius Gomes Rodrigues**
* **Vitor Veiga Silva**

---

## 📊 Diagramas do Projeto

Acesse todos os diagramas do sistema — **classes**, **casos de uso**, **pacotes**, **componentes** e **implantação** — no link abaixo:

🔗 [**Diagramas do Projeto**](https://github.com/vitorveigas/Sistema-de-moeda-estudantil/tree/main/Diagramas)

---

## 📘 Histórias de Usuário

Veja os requisitos narrados sob a perspectiva dos usuários finais:

🔗 [**Histórias de Usuário**](https://github.com/vitorveigas/Sistema-de-moeda-estudantil/blob/main/docs/historias-de-usuario.md)

---

## 🛠️ Tecnologias Utilizadas

As principais ferramentas e linguagens utilizadas no desenvolvimento:

* **Java** — Backend principal.
* **Spring Boot** — Framework para APIs REST e aplicações web.
* **PostgreSQL** — Banco de dados relacional.
* **Maven** — Gerenciador de dependências.
* **Spring Data JPA** — Abstração para operações no banco.
* **JavaScript** — Integração entre frontend e backend.
* **HTML & CSS** — Estrutura e estilo das páginas.
* **EmailJS** — Envio de e-mails.

---

## 🧱 Arquitetura do Sistema

O sistema adota o padrão **MVC** com camadas adicionais para garantir organização e manutenibilidade.

### 📦 Camadas da Aplicação

#### **Controller**

Recebe requisições HTTP, mapeia DTOs e aciona serviços.


#### **Service**

Onde mora a lógica de negócio.

#### **Repository**

Interfaces JPA responsáveis pela comunicação com o banco.

#### **Model (Entidades)**

Mapa das tabelas do banco, representando o domínio da aplicação.

---

## 🔗 Integração com Banco de Dados

* Banco relacional PostgreSQL.
* Mapeamento usando **JPA**.
* Persistência via repositórios com CRUD completo.

---

## ✨ Benefícios da Arquitetura

* **Manutenibilidade** elevada.
* **Escalabilidade** por módulos isolados.
* **Reutilização** de serviços e DTOs.
* **Segurança** ao proteger entidades do domínio.

---

## 🧰 Ferramentas Utilizadas

* **VSCode** — Desenvolvimento.
* **Draw.io** — Criação de diagramas.
* **Astah UML** — Modelagem UML.
* **GitHub** — Controle de versão e colaboração.

---

## 🚀 Como Rodar o Projeto (Windows)

Aqui estão os passos rápidos para configurar o sistema:

### 📌 1. Preparar o Banco de Dados (PostgreSQL)

```sql
CREATE DATABASE moeda_estudantil;
CREATE USER app_user WITH PASSWORD 'senha';
GRANT ALL PRIVILEGES ON DATABASE moeda_estudantil TO app_user;
```

### 📌 2. Configurar o `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/moeda_estudantil
spring.datasource.username=app_user
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
```

### 📌 3. Rodar o Projeto

```bash
mvn clean package -DskipTests
mvn spring-boot:run
```

Ou diretamente pelo JAR:

```bash
java -jar target/*.jar
```

### 📌 4. Rodar Testes

```bash
mvn test
```

### 📌 5. Observações

* Ajuste porta, usuário e senha conforme necessário.
* Pode rodar via IDE (VSCode/IntelliJ).
* Logs e SQL serão exibidos se o `show-sql` estiver ativo.

---

## 📄 Licença

Este projeto está sob a licença **MIT**.

Você pode usar, modificar e distribuir, desde que forneça os créditos adequados ao repositório original:

🔗 [https://github.com/vitorveigas/Sistema-de-moeda-estudantil](https://github.com/vitorveigas/Sistema-de-moeda-estudantil)

Desenvolvido por:
[Cauê Afonso](https://github.com/caueafonsomoraes) • [Thomás Ramos](https://github.com/Thomasramos02) • [Vinícius Gomes](https://github.com/viniciusgomesrod) • [Vitor Veiga](https://github.com/vitorveigas)

---

✨ *Obrigado por conferir o projeto!*
