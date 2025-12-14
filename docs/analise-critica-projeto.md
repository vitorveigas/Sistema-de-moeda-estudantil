# 📘 Relatório de Análise Crítica do Projeto 👨‍💻

## 1. Informações do grupo
- **🎓 Curso:** Engenharia de Software
- **📘 Disciplina:** Laboratório de Desenvolvimento de Software
- **🗓 Período:** 4° Período
- **👨‍🏫 Professor(a):** Prof. Dr. João Paulo Carneiro Aramuni
- **👥 Membros do Grupo:** [Lista de integrantes]

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

Avalie as práticas de Engenharia de Software Colaborativa do projeto, focando na clareza, padronização e rastreabilidade.

### 4.1. Estrutura do Repositório e Documentação
* **Estrutura de Pastas:** A organização dos diretórios (`src`, `config`, `frontend`, etc.) segue as convenções padrão do Spring Boot/Next.js? A separação de Backend e Frontend é clara e lógica?
* **Documentação Essencial:** O arquivo `README.md` é completo e útil? Verifique se ele contém:
    * **Descrição** do projeto e suas funcionalidades.
    * **Requisitos** de ambiente (Java, Node, versões específicas, etc.).
    * **Instruções claras de inicialização** (incluindo banco de dados e comandos de *build*).

### 4.2. Gerenciamento de Tarefas (Issues)
* **Uso de Issues:** O grupo utilizou o sistema de Issues para:
    * Rastrear bugs, funcionalidades e tarefas?
    * Gerenciar o backlog e priorizar o trabalho (com *labels* ou *milestones*)?
    * A descrição das Issues é suficientemente detalhada para guiar o desenvolvimento?

### 4.3. Fluxo de Trabalho (Pull Requests e Branches)
* **Branches:** O fluxo de *branching* é claro (e.g., usa *main/master*, *develop* e *feature branches*)?
* **Pull Requests (PRs):** Qual a qualidade e o uso dos Pull Requests?
    * Possuem **descrições** detalhadas e explicam o propósito das mudanças?
    * Estão **vinculados** às Issues correspondentes?
    * Foram usados para **Revisão de Código (Code Review)** antes do *merge*?

### 4.4. Padrões de Commits e Versionamento
* **Padrão de Commits:** Existe um padrão de mensagens de commit (e.g., usando prefixos como `feat:`, `fix:`, `refactor:`)?
    > **Sugestão:** Se não houver, mencione que a adoção de [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) melhoraria drasticamente a rastreabilidade e a geração automática de *changelogs*.
* **Versionamento (Releases/Tags):** O projeto utiliza **Tags** ou **Releases** para marcar versões estáveis ou marcos importantes (e.g., `v1.0.0`)?

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

1. **Melhoria da Documentação:** Criar um arquivo `CONTRIBUTING.md`, adicionar instruções completas de configuração do ambiente (Java, Maven, variáveis de ambiente e scripts de inicialização) e incluir uma seção de troubleshooting no `README.md`.
2. **Padronização do Código:** Adotar **Conventional Commits**, habilitar ferramentas como **Spotless**, **Checkstyle** ou **SonarLint** para manter consistência e detectar code smells automaticamente.
3. **Testes Automatizados:** Implementar testes unitários na camada de **Service** e testes de integração com **Spring Boot Test**, buscando ao menos **80% de cobertura** nas funcionalidades principais.
4. **Melhorias de Segurança:** Utilizar **Spring Validation** para validação de DTOs, adicionar tratamento centralizado de erros com `@ControllerAdvice`, remover informações sensíveis de logs e revisar dependências vulneráveis usando `mvn dependency-check`.
5. **Organização do Repositório:** Padronizar a estrutura de pastas, adicionar templates de Pull Request e Issues, além de configurar Branch Protection para `main`.
6. **Performance e Otimização:** Analisar pontos de gargalo no carregamento de dados, reduzir consultas redundantes, aplicar cache quando adequado e revisar métodos que fazem processamento excessivo no backend.
7. **Automação e CI/CD:** Criar uma pipeline no **GitHub Actions** para rodar testes, verificar estilo, validar segurança das dependências e realizar build automático a cada PR.

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

**Arquivo:** `src/main/java/br/edu/moedaestudantil/service/ProfessorService.java, AlunoService.java, EmpresaService.java
**Pull Request:** https://github.com/exemplo/projeto/pull/1  

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
