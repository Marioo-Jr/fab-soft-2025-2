
# FabSoft — Sistema de Gestão de Condomínios

> Aplicação full-stack para gerenciamento completo de condomínios, desenvolvida com **Spring Boot** no backend e **Angular** no frontend.

---

## Visão Geral

O FabSoft é um sistema de administração condominial full-stack desenvolvido para centralizar e simplificar a gestão de condomínios residenciais. A aplicação permite o controle completo de moradores (proprietários e locatários), unidades habitacionais, contratos de locação e áreas comuns como salões de festas e churrasqueiras.
No backend, a API REST foi construída com Spring Boot, seguindo uma arquitetura em camadas com separação clara entre controllers, services e repositórios. A persistência é feita via Spring Data JPA, com suporte a banco H2 para desenvolvimento e MariaDB para produção. O banco é populado automaticamente com dados de exemplo na inicialização, facilitando testes e demonstrações.
No frontend, a interface foi desenvolvida em Angular 20 com Bootstrap 5, oferecendo uma experiência responsiva e fluida para cadastro, edição e exclusão de registros em todos os módulos. A comunicação com a API é feita de forma reativa via RxJS e HttpClient.
##
## Pagina inicial
<img width="1914" height="905" alt="homePage" src="https://github.com/user-attachments/assets/2da7db29-a0b6-4a6d-a934-83234e9a7b46" />

##
<img width="1900" height="850" alt="tabelaPessoa" src="https://github.com/user-attachments/assets/e8bc24cb-5a32-461d-9c1d-2a46fdbf05bc" />

##
<img width="1907" height="892" alt="TabelaEspaco" src="https://github.com/user-attachments/assets/f0ce3f2b-6f4a-4ec2-9a26-171d347db244" />

##
<img width="1914" height="894" alt="TabelaImoveis" src="https://github.com/user-attachments/assets/c220d5cd-c640-4ebe-aff4-0d79f271bc06" />

##
<img width="1911" height="892" alt="TabelaLocao" src="https://github.com/user-attachments/assets/fc99de41-1c2e-4a4b-87c4-ed293e134763" />



---

##  Funcionalidades

| Módulo | Operações |
|---|---|
|  **Condomínios** | Cadastrar, editar, excluir, associar síndico |
|  **Imóveis** | Gerenciar unidades por bloco, status e proprietário |
|  **Pessoas** | Cadastro de proprietários e locatários |
|  **Espaços** | Áreas comuns com capacidade e valor de reserva |
|  **Locações** | Controle de contratos de aluguel com status |

---

##  Stack Tecnológica

### Backend
- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Data JPA / Hibernate**
- **H2 Database** (perfil `dev`) — banco em memória, zero configuração
- **MariaDB** (perfil produção)
- **SpringDoc OpenAPI** (Swagger UI em `/swagger-ui.html`)
- **Docker** (Dockerfile multi-stage incluído)

### Frontend
- **Angular 20**
- **TypeScript 5.9**
- **Bootstrap 5.3**
- **RxJS** para comunicação reativa com a API

---

## Como Rodar o Projeto

### Pré-requisitos

- **Java 21+** — [Download Adoptium](https://adoptium.net/pt-BR)
- **Maven 3.9+** — ou use o `mvnw` incluso no projeto
- **Node.js 20+** e **npm** — [Download Node.js](https://nodejs.org)
- **Angular CLI** — instalado automaticamente via `npm`

---

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/fab-soft-2025.git
cd fab-soft-2025
```

---

### 2. Rodar o Backend


```bash
cd fabsoft-backend
./mvnw spring-boot:run
```

> **Windows:** use `mvnw.cmd spring-boot:run`

A API ficará disponível em: **`http://localhost:8080`**

---

### 3. Rodar o Frontend

Em um **novo terminal**:

```bash
cd fabsoft-frontend
npm install
npm start
```

O frontend ficará disponível em: **`http://localhost:4200`**

---

### 4. Acessar a Aplicação

Abra o navegador em **`http://localhost:4200`** e explore os módulos pelo menu de navegação ou pelo painel inicial.

---


##  Arquitetura do Backend

O backend segue uma arquitetura em camadas bem definida:

```
Controller  →  Service (Interface + Impl)  →  Repository (JPA)  →  Entity
     ↕                                                                  ↕
    DTO  ←────────────────────────────────────────────────────── Database
```

**Destaques de design:**
- **DTOs** para desacoplar a API da camada de persistência
- **Herança JPA** (`JOINED`) para `Pessoa` → `Proprietario` / `Locatario`
- **Factory Pattern** (`PessoaFactory`) para instanciar o tipo correto de pessoa
- **Tratamento de erros** centralizado via `@ControllerAdvice`
- **CORS** configurado globalmente para desenvolvimento local


---

## Relacionamento entre as tabelas


```mermaid
---
title: Diagrama de Entidades
---

classDiagram
    Locacao "1" -- "1" Imovel
    Imovel "1" -- "1" Condominio
    Imovel "1" -- "1" Proprietario
    Condominio "1" -- "N" Espaco
    Condominio "1" -- "N" Imovel
    Espaco "1" -- "N" Reserva
    Reserva "1" -- "1" Locatario
    Condominio "1" -- "1" Pessoa : sindico

    Pessoa <|-- Proprietario
    Pessoa <|-- Locatario

    Locacao ..> StatusLocacao
    Imovel ..> StatusImovel
    Espaco ..> StatusEspaco
    Reserva ..> StatusReserva

    namespace entity {
      class Pessoa {
          <<abstract>>
          -id : Long
          -nome : String
          -cpf : String
          -dataNascimento : LocalDate
          -email : String
          -telefone : String

          +getId() Long
          +setId(id:Long) void
          +getNome() String
          +setNome(nome:String) void
          +getCpf() String
          +setCpf(cpf:String) void
          +getEmail() String
          +setEmail(email:String) void
          +getTelefone() String
          +setTelefone(telefone:String) void
          +getDataNascimento() LocalDate
          +setDataNascimento(dataNascimento:LocalDate) void
      }

      class Proprietario {
          
      }

      class Locatario {
          -endereco : String

          +getEndereco() String
          +setEndereco(endereco:String) void
      }

      class Locacao {
        -id : Long
        -locatario : Locatario
        -imovel : Imovel
        -dataInicio : LocalDate
        -dataFim: LocalDate
        -valorAluguel : Double
        -statusLocacao : StatusLocacao

        +getId() Long
        +setId(id:Long) void
        +getLocatario() Locatario
        +setLocatario(locatario:Locatario) void
        +getImovel() Imovel
        +setImovel(imovel:Imovel) void
        +getDataInicio() LocalDate
        +setDataInicio(dataInicio:LocalDate) void
        +getDataFim() LocalDate
        +setDataFim(dataFim:LocalDate) void
        +getValorAluguel() Double
        +setValorAluguel(valorAluguel:Double) void
        +getStatusLocacao() StatusLocacao
        +setStatusLocacao(statusLocacao:StatusLocacao) void
      }

      class Condominio {
        -id : Long
        -nome : String
        -endereco : String
        -cnpj : String
        -sindico : Pessoa

        +getId() Long
        +setId(id:Long) void
        +getNome() String
        +setNome(nome:String) void
        +getEndereco() String
        +setEndereco(endereco:String) void
        +getCnpj() String
        +setCnpj(cnpj:String) void
        +getSindico() Pessoa
        +setSindico(sindico:Pessoa) void
      }

      class Imovel {
        -id : Long
        -numero : String
        -bloco : String
        -qtdeQuartos : Integer
        -qtdeBanheiros : Integer
        -vagaGaragem : Integer
        -statusImovel : StatusImovel
        -condominio : Condominio
        -proprietario : Proprietario

        +getId() Long
        +setId(id:Long) void
        +getNumero() String
        +setNumero(numero:String) void
        +getBloco() String
        +setBloco(bloco:String) void
        +getQtdeQuartos() Integer
        +setQtdeQuartos(qtdeQuartos:Integer) void
        +getQtdeBanheiros() Integer
        +setQtdeBanheiros(qtdeBanheiros:Integer) void
        +getVagaGaragem() Integer
        +setVagaGaragem(vagaGaragem:Integer) void
        +getStatusImovel() StatusImovel
        +setStatusImovel(statusImovel:StatusImovel) void
        +getCondominio() Condominio
        +setCondominio(condominio:Condominio) void
        +getProprietario() Proprietario
        +setProprietario(proprietario:Proprietario) void
      }

      class Espaco {
        -id : Long
        -nome : String
        -descricao : String
        -capacidadeMaxima : Integer
        -valorReserva : Double
        -statusEspaco : StatusEspaco
        -condominio : Condominio

        +getId() Long
        +setId(id:Long) void
        +getNome() String
        +setNome(nome:String) void
        +getDescricao() String
        +setDescricao(descricao:String) void
        +getCapacidadeMaxima() Integer
        +setCapacidadeMaxima(capacidadeMaxima:Integer) void
        +getStatusEspaco() StatusEspaco
        +setStatusEspaco(statusEspaco:StatusEspaco) void
        +getCondominio() Condominio
        +setCondominio(condominio:Condominio) void
      }

      class Reserva {
        -id : Long
        -espaco : Espaco
        -locatario : Locatario
        -dataEvento : LocalDate
        -valorTotal : Double
        -observacoes : String
        -statusReserva : StatusReserva

        +getId() Long
        +setId(id:Long) void
        +getEspaco() Espaco
        +setEspaco(espaco:Espaco) void
        +getLocatario() Locatario
        +setLocatario(locatario:Locatario) void
        +getDataEvento() LocalDate
        +setDataEvento(dataEvento:LocalDate) void
        +getValorTotal() Double
        +setValorTotal(valorTotal:Double) void
        +getObservacoes() String
        +setObservacoes(observacoes:String) void
        +getStatusReserva() StatusReserva
        +setStatusReserva(statusReserva:StatusReserva) void
      }
  
     class StatusLocacao {
        <<enum>>
        ATIVA
        ENCERRADA
        INADIMPLENTE
    }

    class StatusImovel {
        <<enum>>
        OCUPADO
        DISPONIVEL
        MANUTENCAO
    }

    class StatusEspaco {
        <<enum>>
        DISPONIVEL
        MANUTENCAO
    }

    class StatusReserva {
        <<enum>>
        PENDENTE
        CONFIRMADA
        CANCELADA
    }

    }
