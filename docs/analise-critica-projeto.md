# 📘 Relatório de Análise Crítica do Projeto 👨‍💻

## 1. Informações do grupo
- **🎓 Curso:** Engenharia de Software
- **📘 Disciplina:** Laboratório de Desenvolvimento de Software
- **🗓 Período:** 4° Período
- **👨‍🏫 Professor(a):** Prof. Dr. João Paulo Carneiro Aramuni
- **👥 Membros do Grupo:** Cauê Afonso Moraes, Thomás Ramos Oliveira, Vinícius Gomes Rodrigues, Vitor Veiga Silva

---

## 📌 2. Identificação do Projeto
- **Nome do projeto:** _Informe aqui_
- **Integrantes do outro grupo:** Enzo Cazaes, João Vitor Filardi, Rafael Faria
- **Link do repositório:** https://github.com/RafaelFFranco/Sistema-Moeda-Estudantil
- **Pull requests submetidos pelo seu grupo:**
  
  | 👤 Integrante | 🔧 Refatoração | 🔗 Link do PR |
  |--------------|---------------|----------------|
  | :octocat: <a href="https://github.com/user1">Aluno 1</a> | Validação e Regras de Negócio | https://github.com/exemplo/projeto/pull/1 |
  | :octocat: <a href="https://github.com/user2">Aluno 2</a> | Estrutura e Eliminação de Código Duplicado | https://github.com/exemplo/projeto/pull/2 |
  | :octocat: <a href="https://github.com/user3">Aluno 3</a> | Controladores e Padronização de Endpoints | https://github.com/exemplo/projeto/pull/3 |
  | :octocat: <a href="https://github.com/user4">Aluno 4</a> | Organização de Pastas e Modularização do Backend | https://github.com/exemplo/projeto/pull/4 |

> [!NOTE]
> Os links acima são apenas exemplos. Substitua pelos PRs reais do seu grupo.

### 📝 Abrindo o Pull Request: Fluxos de Contribuição via PRs

#### 1. Opção 1 — Usando *Fork* (quando você **não é colaborador**)

1. Crie um **fork** (cópia) do repositório do outro grupo na sua conta.
2. **Clone o seu fork** localmente.
3. Crie um **branch**, faça as refatorações (commits) e envie (**push**) a branch para o seu fork.
4. No GitHub, acesse o **seu fork** e inicie o pull request clicando em **"Compare & pull request"**.
5. O PR deve propor mesclar o **seu branch** para a branch **main** do **repositório original** do outro grupo.
6. Adicione título/descrição e clique em **"Create pull request"**.

#### 2. Opção 2 — Como Membro/Colaborador (quando você **foi incluído** no repositório)

1. Peça para o outro grupo **adicionar seu usuário GitHub como colaborador**.
2. **Clone o repositório original** localmente.
3. Crie um **branch**, faça as refatorações (commits) e envie (**push**) a branch diretamente para o repositório original.
4. No GitHub, no repositório original, inicie o pull request clicando em **"Compare & pull request"**.
5. O PR deve propor mesclar o **seu branch** para a branch **main** do **mesmo repositório**.
6. Adicione título/descrição e clique em **"Create pull request"**.

> [!IMPORTANT]
> Cada integrante do grupo é responsável por enviar seu próprio pull request, contendo a refatoração que realizou.

---

## 🧱 3. Arquitetura e Tecnologias Utilizadas

O projeto utiliza uma arquitetura dividida entre backend e frontend, promovendo modularidade, separação de responsabilidades e facilidade de manutenção.

### 🏗️ Backend — Spring Boot
O backend foi desenvolvido utilizando **Spring Boot**, seguindo um padrão próximo ao **MVC**, com camadas bem definidas:

- **Controllers:** recebem requisições HTTP e encaminham para a lógica apropriada.  
- **Services:** concentram as regras de negócio e interações entre camadas.  
- **Repositories:** utilizam Spring Data JPA para acesso aos dados e persistência.  
- **Entities/Models:** representam as estruturas de dados do domínio.

Tecnologias empregadas:
- Spring Boot  
- Spring Data JPA  
- H2/PostgreSQL (dependendo do ambiente)  
- Spring Web

### 🎨 Views com Thymeleaf
A camada de apresentação do backend utiliza **Thymeleaf** para renderizar páginas HTML dinâmicas.  
Isso permite:
- Geração server-side de páginas,  
- Integração direta com modelos Java,  
- Reutilização de fragments e templates,  
- Validações e mensagens integradas com Spring.

### 🌐 Frontend — Next.js
O projeto pode complementar o backend com um frontend moderno baseado em **Next.js**, utilizado para criar interfaces reativas e componentes reutilizáveis.

Principais características:
- Renderização híbrida (**SSR** e **SSG**) para melhorar SEO e performance.  
- Componentização com React.  
- Roteamento otimizado.  
- Estilização modular (CSS Modules, Tailwind, etc., se utilizado).  
- Comunicação com o backend via APIs REST.

### 🔄 Integração entre Camadas
- O **backend expõe endpoints REST** que podem ser consumidos pelo Next.js.  
- Alternativamente, parte das páginas podem ser servidas diretamente via Thymeleaf.  
- Essa dualidade permite ao projeto combinar **renderização server-side clássica** (Thymeleaf) e **componentização moderna** (Next.js).

> [!TIP]
> Destaque se o uso combinado de Thymeleaf e Next.js trouxe benefícios (flexibilidade, compatibilidade) ou dificuldades (duplicidade de camadas de view, esforço maior de manutenção).

---

## 🗂️ 4. Organização do GitHub e Fluxo de Trabalho Colaborativo

Esta seção avalia as práticas de Engenharia de Software Colaborativa do projeto, com foco na clareza, padronização e rastreabilidade do desenvolvimento.



## 4.1 Estrutura do Repositório e Documentação



### 📁 Estrutura de Pastas

A organização do repositório segue as **convenções padrão de projetos Spring Boot**, apresentando uma separação clara entre código-fonte, arquivos de configuração e artefatos de build.

Estrutura observada:

```text
src/
 └── main/
     ├── java/
     ├── resources/
target/
pom.xml
```


## 4.2 Gerenciamento de Tarefas (Issues)

### 📝 Uso de Issues

O repositório **não utiliza o sistema de Issues do GitHub** para o gerenciamento das atividades do projeto. Não foram identificados registros formais de:

- Bugs
- Funcionalidades
- Tarefas de desenvolvimento
- Priorização do backlog

**Impacto:**  
A ausência do uso de Issues dificulta a rastreabilidade do processo de desenvolvimento, bem como o acompanhamento da evolução do projeto e das decisões tomadas ao longo do tempo.

**Recomendação:**  
A adoção do sistema de Issues permitiria:
- Organizar e priorizar tarefas;
- Documentar bugs e melhorias;
- Relacionar atividades a Pull Requests;
- Melhorar a comunicação e a colaboração entre os integrantes do grupo.

---

## 4.3 Fluxo de Trabalho (Branches e Pull Requests)

### 🌿 Branches

O projeto aparenta utilizar apenas a branch principal (`main`), não sendo identificado um fluxo de ramificação estruturado.

**Avaliação:**  
Embora funcional para projetos simples, a utilização de uma única branch reduz o controle sobre mudanças e pode dificultar o desenvolvimento colaborativo.

**Sugestão de melhoria:**  
Adotar um fluxo mínimo de branches, como:
- `main`: versão estável do sistema
- `feature/nome-da-funcionalidade`: desenvolvimento de novas funcionalidades
- `fix/descricao-do-problema`: correções de erros

Esse modelo contribui para maior organização, segurança e clareza no processo de desenvolvimento.

---

### 🔀 Pull Requests

O uso de Pull Requests é **limitado**, com poucos registros disponíveis no repositório.

Não há evidências claras de:
- Revisões de código (*code review*);
- Vinculação entre Pull Requests e Issues;
- Descrições detalhadas explicando o propósito das alterações.

**Recomendação:**  
Utilizar Pull Requests como prática obrigatória antes da integração de código à branch principal, incluindo:
- Descrições claras das mudanças realizadas;
- Referência às Issues correspondentes;
- Revisão do código por outros integrantes da equipe.

---

## 4.4 Padrões de Commits e Versionamento

### 🧾 Padrão de Commits

Não foi identificado um padrão formal para as mensagens de commit utilizadas no projeto.

**Impacto:**  
A ausência de padronização dificulta a compreensão do histórico de alterações e a identificação do tipo de modificação realizada em cada commit.

**Sugestão:**  
A adoção do padrão **Conventional Commits** (por exemplo: `feat:`, `fix:`, `refactor:`) melhoraria significativamente:
- A rastreabilidade das mudanças;
- A organização do histórico de commits;
- A futura geração automática de *changelogs*.

---

### 🏷️ Versionamento (Releases e Tags)

O projeto **não utiliza tags ou releases** para marcar versões estáveis ou marcos importantes do desenvolvimento.

**Recomendação:**  
Utilizar versionamento semântico, com tags como:
- `v1.0.0` – primeira versão estável
- `v1.1.0` – novas funcionalidades
- `v1.1.1` – correções de bugs

Essa prática facilita o controle de versões, a manutenção do sistema e a identificação de entregas relevantes.

---


---

## 🖥️ 5. Dificuldade para Configuração do Ambiente

### 5.1. Requisitos de Linguagem e Ferramentas de Build

* **Versão do Java:** O projeto exige explicitamente **Java 17**, e esta informação está claramente documentada na seção "Tecnologias" do README. O grupo não enfrentou problemas relacionados à versão do Java, pois a documentação é precisa. A aplicação não iniciaria corretamente com versões anteriores do Java devido a recursos específicos do Spring Boot 3.x que exigem Java 17+.

* **Ferramenta de Build:** O projeto utiliza **Maven** como ferramenta de build. Todas as dependências foram baixadas automaticamente sem conflitos de versão. O arquivo `pom.xml` está bem configurado com o plugin `spring-boot-maven-plugin` presente, permitindo a execução do projeto com `mvn spring-boot:run`. A aplicação não apresentou falhas de build por ausência de plugins ou dependências mal configuradas.

* **Dependências e Compatibilidade:** As dependências do **Thymeleaf** e dos módulos Spring (Web, Security, Data JPA, Mail) estão declaradas corretamente e são compatíveis entre si. O build foi executado com sucesso na primeira tentativa, sem necessidade de ajustes manuais nas versões das dependências.

### 5.2. Configuração de Persistência e Variáveis de Ambiente

* **Arquivos de Configuração:** O arquivo `application.properties` está completo e funcional por padrão. A aplicação inicia sem erros porque as configurações essenciais já estão presentes. O projeto oferece uma configuração "bateria incluída" com conexão pré-estabelecida para um banco PostgreSQL hospedado na Railway, eliminando a necessidade de configuração inicial do banco de dados.

* **Variáveis de Ambiente:** O projeto depende de variáveis de ambiente para a conexão com banco de dados e serviço de e-mail, porém:
1. **Banco de dados:** As credenciais estão pré-configuradas no `application.properties`, conectando-se automaticamente a uma instância PostgreSQL na Railway
2. **E-mail:** O modo de teste está ativado por padrão (`app.mail.enabled=false`), evitando erros por falta de configuração SMTP
3. **Documentação:** O README fornece instruções claras para configurar e-mail com Gmail quando necessário

* **Observação de segurança:** As credenciais do banco de dados estão visíveis no README, o que é aceitável para um projeto acadêmico mas exigiria ajustes (uso de variáveis de ambiente ou arquivos não versionados) para um ambiente de produção.

* **Banco de Dados Local:** Não foi necessário criar um banco PostgreSQL local manualmente. Para desenvolvimento local, o README explica como configurar o H2 em memória, que não requer instalação ou criação prévia de banco. As instruções são claras: basta descomentar a configuração do H2 no `application.properties`.

### 5.3. Aspectos a Analisar e Soluções Aplicadas

**Aspectos a Analisar:**
- **Versão do Java:** 17 (conforme documentado)
- **Ferramenta de build:** Maven 3.9+
- **Dependências:** Spring Boot 3.1.6 com todos os módulos necessários
- **Banco de Dados:** PostgreSQL na Railway (pré-configurado) com opção para H2 local
- **Arquivos de Configuração:** `application.properties` completo e funcional
- **Frontend:** Thymeleaf templates (não requer Node.js ou build separado)

**Passos para Subir:**
1. Clonar o repositório: `git clone [URL]`
2. Verificar instalação do Java 17: `java -version`
3. Executar a aplicação usando uma das opções:
   - **Opção recomendada:** Executar `run-fast.bat` (Windows) ou `./run-fast.sh` (Linux/Mac)
   - **Alternativa 1:** Executar via Maven: `mvn spring-boot:run`
   - **Alternativa 2:** Importar no VS Code e usar a configuração "Run MoedaEstudantilApplication (Fast)"
4. Acessar a aplicação em `http://localhost:8080`
5. Fazer login com um dos usuários de teste (documentados no README)

**Tempo total para execução:** Menos de 5 minutos

**Soluções Aplicadas:** O grupo não precisou aplicar correções na documentação, ajustar versões ou resolver dependências quebradas. A experiência de configuração foi extremamente simples graças a:

1. **Documentação completa:** Todas as informações necessárias estavam no README
2. **Configuração pré-estabelecida:** Conexão com banco de dados já funcional
3. **Modo de desenvolvimento otimizado:** Scripts `run-fast` com flags JVM para inicialização rápida
4. **Usuários de teste pré-cadastrados:** Permitiram testar todas as funcionalidades imediatamente
5. **Fallbacks inteligentes:** E-mail em modo de teste por padrão, evitando erros de configuração

**Conclusão:** A configuração do ambiente foi notavelmente simples e direta. O projeto serve como exemplo de boa documentação e configuração "pronta para uso", reduzindo significativamente a barreira de entrada para novos desenvolvedores ou avaliadores.

> [!WARNING]
> Caso o grupo tenha enfrentado erros por falta de documentação, versões inconsistentes ou dependências quebradas, **descreva detalhadamente cada passo necessário para a execução**, incluindo como corrigiram os problemas.

---

## 🔎 6. Análise de Qualidade do Código e Testes

### 6.1. Design e Princípios SOLID
* **Coesão e Acoplamento:** Existem classes com muitas responsabilidades (**God Class**)? O acoplamento entre módulos é alto?
* **Princípios SOLID Violados (Se aplicável):** (Ex: O Controller faz validação e acesso ao banco, violando o **S**ingle Responsibility Principle - SRP).
* **Code Smells:** Identifique a presença de **Long Method** (métodos com muitas linhas) ou **Duplicated Code** fora das áreas que vocês refatoraram.
    * **Evidência/Exemplo:** _(Cite o arquivo e a linha onde um problema foi encontrado)_

### 6.2. Testabilidade e Cobertura
* **Presença de Testes:** O projeto possui testes (Unitários, Integração, End-to-End)?
* **Cobertura (Estimada/Medida):** Qual é a cobertura de código (Se houver ferramenta para medir, cite o percentual)?
    * **Qualidade dos Testes:** Os testes focam na lógica de negócio (camada Service) ou apenas na integração do sistema (testando o Controller e persistência)?
    * **Mocking:** O uso de *mocks* e *stubs* é adequado para isolar as dependências e testar unidades de código?
    * **Evidência/Exemplo:** _(Cite o diretório de testes (`src/test`) e mencione a ausência ou presença de testes para uma funcionalidade crítica)_

### 6.3. Segurança e Tratamento de Erros (OWASP Top 10)
Avalie o projeto com base em vulnerabilidades comuns, como as citadas no OWASP Top 10. 

* **Validação de Entrada (Input Validation):** Existem validações rigorosas em todos os dados recebidos (DTOs)? Há sanitização de *input* para prevenir **Injeção de SQL/Scripting (XSS)**?
* **Tratamento de Credenciais:** O tratamento de senhas é seguro (uso de `BCrypt` ou algoritmo forte)? As credenciais de acesso ao banco estão expostas no código ou em *logs*?
* **Tratamento de Exceções:** O tratamento de exceções é adequado? A aplicação retorna mensagens de erro genéricas (status 500) ou expõe detalhes do erro e da arquitetura (vazamento de informações)?
    * **Evidência/Exemplo:** _(Cite um ponto fraco, Ex: "O campo de busca não tem sanitização, potencial XSS" ou "As senhas não estão criptografadas")_

---

## 🚀 7. Sugestões de Melhorias

Liste **entre 5 e 7 sugestões claras e prioritárias** para os autores do projeto, baseadas nas análises acima (Seções 3, 4, 5 e 6).

1. **Implementação de Testes Automatizados:** O projeto não possui testes (não há diretório src/test), o que viola princípios de testabilidade. Adicione testes unitários para serviços (ex.: AlunoService, MoedaService) usando JUnit e Mockito, visando cobertura mínima de 70%. Inclua testes de integração com @SpringBootTest para controladores e repositórios, priorizando funcionalidades críticas como transferência de moedas e autenticação.

2. **Reforço da Segurança e Tratamento de Erros:** Credenciais de banco e e-mail estão expostas no application.properties (ex.: senha do PostgreSQL visível), representando risco de OWASP Top 10 (exposição de credenciais). Migre para variáveis de ambiente ou arquivos não versionados. Habilite CSRF no SecurityConfig.java, adicione validações rigorosas em DTOs com @Valid e Bean Validation, e implemente tratamento centralizado de erros com @ControllerAdvice para evitar vazamento de informações (ex.: status 500 genérico em vez de stack traces).

3. **Padronização do Código e Ferramentas de Qualidade:** O código segue MVC básico, mas carece de ferramentas para detectar code smells (ex.: métodos longos em controladores como AlunoController). Adote Conventional Commits para mensagens de commit, integre Checkstyle ou SonarLint no Maven para análise estática, e configure Spotless para formatação automática. Isso melhorará coesão e reduzirá duplicação de código.

4. **Melhoria da Documentação e Organização do Repositório:** O README.md é detalhado, mas falta um CONTRIBUTING.md com guias de contribuição, templates de Pull Request e Issues. Padronize branches (ex.: main, develop, feature/*), configure Branch Protection no GitHub para exigir revisões em PRs, e adicione seção de troubleshooting no README para erros comuns (ex.: configuração de e-mail).

5. **Otimização de Performance e Consultas:** Há potencial para gargalos em consultas JPA (ex.: findByQuery em AlunoService pode ser ineficiente sem índices). Analise queries com spring.jpa.show-sql=true, adicione cache com @Cacheable em métodos de leitura frequente, e otimize métodos que processam dados excessivos (ex.: listagens sem paginação). Revise dependências para remover redundâncias.

6. **Integração de CI/CD e Automação:** Não há pipeline de CI/CD, o que deixa builds e testes manuais. Configure GitHub Actions para executar mvn clean test e mvn verify em cada PR, incluindo verificação de vulnerabilidades com mvn dependency-check. Isso automatizará qualidade e reduzirá regressões.

7. **Revisão de Dependências e Compatibilidade:** O pom.xml usa versões compatíveis, mas dependências como ZXing não são auditadas. Execute mvn dependency-check para detectar CVEs (ex.: possíveis vulnerabilidades em bibliotecas antigas). Atualize para versões mais recentes do Spring Boot se compatíveis.


---

## 🔧 8. Refatorações Propostas (3 partes do código)

Cada refatoração deve conter:
1. **Arquivo e localização**  
2. **Código antes**  
3. **Código depois**  
4. **Tipo de refatoração aplicada**  
5. **Justificativa técnica**  
6. **Link do Pull Request**

---

### 1️⃣ Refatoração 1 – Extração de Método (Extract Method)

**Arquivo:** `src/main/java/br/edu/moedaestudantil/service/ProfessorService.java, AlunoService.java, EmpresaService.java`
**Pull Request:** https://github.com/RafaelFFranco/Sistema-Moeda-Estudantil/pull/1 

#### 🔴 Antes
```java
// ProfessorService.java
private boolean isPasswordEncrypted(String password) {
    return password != null && (password.startsWith("$2a$") || password.startsWith("$2b$") || password.startsWith("$2y$"));
}

// AlunoService.java
private boolean isPasswordEncrypted(String password) {
    // BCrypt passwords start with $2a$, $2b$, or $2y$
    return password != null && (password.startsWith("$2a$") || password.startsWith("$2b$") || password.startsWith("$2y$"));
}

// EmpresaService.java
private boolean isPasswordEncrypted(String password) {
    return password != null && (password.startsWith("$2a$") || password.startsWith("$2b$") || password.startsWith("$2y$"));
}
```

#### 🟢 Depois
```java
// Nova classe: PasswordUtils.java
package br.edu.moedaestudantil.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtils {
    
    public boolean isPasswordEncrypted(String password) {
        return password != null && 
               (password.startsWith("$2a$") || 
                password.startsWith("$2b$") || 
                password.startsWith("$2y$"));
    }
    
    public boolean isWeakPassword(String password) {
        return password == null || password.length() < 8;
    }
}

// ProfessorService.java (e outras services)
@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordUtils passwordUtils;

    public ProfessorService(ProfessorRepository professorRepository, 
                           PasswordEncoder passwordEncoder,
                           PasswordUtils passwordUtils) {
        this.professorRepository = professorRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordUtils = passwordUtils;
    }
    
    private void handlePasswordManagement(Professor professor) {
        if (professor.getId() != null) {
            Optional<Professor> professorExistente = professorRepository.findById(professor.getId());
            if (professorExistente.isPresent()) {
                Professor professorAntigo = professorExistente.get();
                if (professor.getSenha() == null || professor.getSenha().isEmpty()) {
                    professor.setSenha(professorAntigo.getSenha());
                } else if (!passwordUtils.isPasswordEncrypted(professor.getSenha())) {
                    professor.setSenha(passwordEncoder.encode(professor.getSenha()));
                }
            }
        } else {
            if (professor.getSenha() != null && 
                !professor.getSenha().isEmpty() && 
                !passwordUtils.isPasswordEncrypted(professor.getSenha())) {
                professor.setSenha(passwordEncoder.encode(professor.getSenha()));
            }
        }
    }
}
```

#### ✔ Tipo de refatoração aplicada
- **Extract Class para utilidades de senha** 

#### 📝 Justificativa
- Eliminação de duplicação: Remove código idêntico em 3 classes diferentes
- Centralização: Todas as regras de validação de senha em um único lugar
- Manutenibilidade: Alterações em regras de senha afetam todas as services automaticamente
- Extensibilidade: Facilita adição de novas validações (ex: força da senha, regex patterns)

---

### 2️⃣ Refatoração 2 – Remoção de Código Duplicado

**Arquivo:** `src/main/java/com/example/util/StringUtils.java`  
**Pull Request:** https://github.com/exemplo/projeto/pull/2  

#### 🔴 Antes
```java
public String capitalizeName(String name) {
    return name.substring(0, 1).toUpperCase() + name.substring(1);
}

public String capitalizeCity(String city) {
    return city.substring(0, 1).toUpperCase() + city.substring(1);
}

```

#### 🟢 Depois
```java
public String capitalize(String text) {
    return text.substring(0, 1).toUpperCase() + text.substring(1);
}

public String capitalizeName(String name) {
    return capitalize(name);
}

public String capitalizeCity(String city) {
    return capitalize(city);
}
```

#### ✔ Tipo de refatoração aplicada
- **Replace Duplicated Code with Method**

#### 📝 Justificativa
Elimina duplicação e facilita manutenção.

---
**Arquivo e localização:** `src/main/java/br/edu/moedaestudantil/service/ProfessorService.java`, `AlunoService.java`, `EmpresaService.java` (método `save`)

#### 🔴 Antes

```java
// ProfessorService.java
public Professor save(Professor professor) {
    // Gerenciar senha
    if (professor.getId() != null) {
        Optional<Professor> professorExistente = professorRepository.findById(professor.getId());
        if (professorExistente.isPresent()) {
            Professor professorAntigo = professorExistente.get();
            if (professor.getSenha() == null || professor.getSenha().isEmpty()) {
                professor.setSenha(professorAntigo.getSenha());
            } else if (!isPasswordEncrypted(professor.getSenha())) {
                professor.setSenha(passwordEncoder.encode(professor.getSenha()));
            }
        }
    } else {
        if (professor.getSenha() != null && !professor.getSenha().isEmpty() && !isPasswordEncrypted(professor.getSenha())) {
            professor.setSenha(passwordEncoder.encode(professor.getSenha()));
        }
    }
    // ... resto do método
}
```

#### 🟢 Depois

**Nova classe:** `PasswordManagementUtils.java`

```java
package br.edu.moedaestudantil.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.function.Function;

@Component
public class PasswordManagementUtils {

    private final PasswordEncoder passwordEncoder;
    private final PasswordUtils passwordUtils;

    public PasswordManagementUtils(PasswordEncoder passwordEncoder, PasswordUtils passwordUtils) {
        this.passwordEncoder = passwordEncoder;
        this.passwordUtils = passwordUtils;
    }

    public <T> void handlePasswordForEntity(T entity, Long id, Function<Long, Optional<T>> findById, 
                                           Function<T, String> getSenha, 
                                           java.util.function.BiConsumer<T, String> setSenha) {
        // Implementação do método...
    }
}
```
📝 **Justificativa técnica:** Elimina duplicação da lógica complexa de gerenciamento de senha (verificação de existência, preservação de senha antiga, criptografia condicional) em 3 serviços. Usa generics para reutilização, facilitando manutenção e reduzindo bugs por inconsistências.

### 3️⃣ Refatoração 3 – Melhoria de Nomes (Rename)

**Arquivo:** `src/main/java/com/example/controller/ProductController.java`  
**Pull Request:** https://github.com/exemplo/projeto/pull/3  

#### 🔴 Antes
```java
@PostMapping("/x")
public void x(@RequestBody Product p) {
    if (p == null) return;
    service.save(p);
}
```

#### 🟢 Depois
```java
@PostMapping("/save")
public void saveProduct(@RequestBody Product product) {
    if (product == null) return;
    service.save(product);
}
```

#### ✔ Tipo de refatoração aplicada
- **Rename Method / Rename Parameter**

#### 📝 Justificativa
Melhora a clareza e expressividade do código.

---

**Arquivo e localização:** `MoedaController.java` (métodos `adicionar`, `remover`, `transferir`, `trocar`)

#### 🔴 Antes

```java
@PostMapping("/adicionar")
public String adicionar(@RequestParam Long professorId, @RequestParam Long alunoId, 
                       @RequestParam int quantidade, RedirectAttributes redirectAttributes) {
    // ...
}

@PostMapping("/remover")
public String remover(@RequestParam Long professorId, @RequestParam Long alunoId, 
                     @RequestParam int quantidade, RedirectAttributes redirectAttributes) {
    // ...
}

@PostMapping("/transferir")
public String transferir(@RequestParam Long deAlunoId, @RequestParam Long paraAlunoId, 
                        @RequestParam int quantidade, RedirectAttributes redirectAttributes) {
    // ...
}

@PostMapping("/trocar")
public String trocar(@RequestParam Long alunoId, @RequestParam Long vantagemId, 
                    RedirectAttributes redirectAttributes) {
    // ...
}
```

#### 🟢 Depois

```java
@PostMapping("/add")
public String addCoins(@RequestParam Long professorId, @RequestParam Long studentId, 
                      @RequestParam int amount, RedirectAttributes redirectAttributes) {
    // ...
}

@PostMapping("/remove")
public String removeCoins(@RequestParam Long professorId, @RequestParam Long studentId, 
                         @RequestParam int amount, RedirectAttributes redirectAttributes) {
    // ...
}

@PostMapping("/transfer")
public String transferCoins(@RequestParam Long fromStudentId, @RequestParam Long toStudentId, 
                           @RequestParam int amount, RedirectAttributes redirectAttributes) {
    // ...
}

@PostMapping("/exchange")
public String exchangeForAdvantage(@RequestParam Long studentId, @RequestParam Long advantageId, 
                                  RedirectAttributes redirectAttributes) {
    // ...
}
```
📝 **Justificativa técnica:** Nomes em português (`adicionar`, `remover`) dificultam compreensão para desenvolvedores internacionais. Renomear para inglês (`addCoins`, `removeCoins`) segue convenções Java, melhora legibilidade e facilita colaboração em equipes globais.

## 9. 📄 Conclusão

A análise crítica permitiu identificar aspectos importantes relacionados à **arquitetura**, **qualidade do código** e **organização geral do projeto**. A investigação detalhada evidenciou pontos positivos, como boas escolhas tecnológicas, mas também expôs problemas que comprometem a **manutenibilidade**, **segurança** e **performance** do sistema.

As refatorações propostas tiveram impacto direto na **melhoria da legibilidade**, **redução de duplicidade**, **aumento da coesão** e **clareza das responsabilidades**. Além disso, práticas recomendadas foram introduzidas para tornar o código mais robusto, mitigando riscos como:
- validações inconsistentes;
- trechos suscetíveis a falhas de segurança (ex.: falta de sanitização ou verificações frágeis);
- métodos extensos e difíceis de testar;
- rotinas com potencial para degradação de desempenho.

A análise também mostrou que melhorias adicionais podem ser adotadas, como:
- padronização da comunicação via **Conventional Commits**;
- reforço das práticas de **segurança** (validações mais estruturadas, tratamento de exceções, prevenção de vulnerabilidades comuns);
- otimizações de **performance**, incluindo redução de operações redundantes e melhor organização das responsabilidades do backend;
- ampliação e atualização da **documentação**, incluindo requisitos de ambiente e instruções claras de execução;
- tratamento cuidadoso das dependências utilizadas no projeto.

Por fim, o processo reforçou a importância da **refatoração contínua**, **revisão estruturada de código** e **boas práticas de engenharia**, fundamentais para manter um software sustentável, escalável e seguro ao longo de seu ciclo de vida.

---

## 10. 📚 Referências
- Revisando alterações em Pull Requests:  
  https://docs.github.com/pt/pull-requests/collaborating-with-pull-requests/reviewing-changes-in-pull-requests/commenting-on-a-pull-request

- Guia oficial de **Conventional Commits**:  
  https://www.conventionalcommits.org/pt-br/v1.0.0/

- Documentação do Spring Boot (boas práticas, segurança e performance):  
  https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/

- OWASP Cheat Sheets (segurança em aplicações web):  
  https://cheatsheetseries.owasp.org/

---
