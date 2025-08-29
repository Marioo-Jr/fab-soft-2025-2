
# fab-soft-2025

Nome: Mario Sergio Minas Junior


## Propostas

Lexical notebook.

	- Conexao entre os alunos
		- os alunos vao poder compartilhar os flashcards uns com os outros.
		- quando o professor criar um turma, ele vai poder adicionar os alunos na Turma.	
		- quando o professor adicionar vocabularios novos, os alunos vao receber o vocab novo.

	- Correcao
		- O app precisa ter algum tipo de correcao, para evitar que os alunos adicionem conteudos escritos errados.
	- Busca por vocabularios
		- o app permoite que o usuario tenha algumas opcoes de organizacao
			- Por pastas
			- Por Tags
			- Por Nome

	- Visualizar edicao
		- permite que o usuario crie, edite ou exclua qualquer conteudo adicionado.

	- Modos de estudos
		- Metodo quiz
		- Metodo repeticao espacada
  ### Historias 12/08.

 - Como usuario eu gostaria de compartilhar meus vocabularios com outros alunos.
 - Como usuario eu gostaria poder fazer flash cards com o vocabulario novo.
 - como usuario eu gostaria de poder ter diferentes formas de estudar o vocabulario
 - como usuario eu gostaria de poder ver o vocabulario que meu colega adicionou
 - como usuario eu gostaria de poder adicionar meus amigos na plataforma
 - como usuario eu gostaria de poder criar grupos na plataforma.
 - como usuario eu gostaria de poder criar pastas na plataforma.


##
Sistema de Controle de Condomínios 

- Cadastro de Moradores

	Inserir, editar e excluir moradores.

- Cadastro de Áreas Comuns

	Criar e gerenciar áreas comuns (salão de festas, churrasqueira, academia, etc.).

- Reserva de Áreas Comuns

	Moradores podem solicitar reserva de áreas disponíveis em datas e horários específicos.

	Sistema bloqueia horários já reservados.

- Registro de Ocorrências

	Moradores registram ocorrências (barulho, manutenção, segurança), com título, descrição e fotos opcionais.

	Síndico e/ou administradores podem atualizar status da ocorrência (pendente, em andamento, resolvida).


- Histórico de Reservas e Ocorrências

	Morador pode consultar tudo o que já registrou ou reservou.

- Autenticação de Usuários

	Login separado para moradores e administradores (com permissões diferentes).


- Controle de Funcionários //

	Cadastro e escalas de porteiros, zeladores, faxineiros, etc.

- Gestão de Manutenção Preventiva // 

	Agenda para manutenção de elevadores, bombas d’água, portões, etc.

- Relatórios e Estatísticas //

	Relatório de reservas, ocorrências mais comuns, inadimplência, etc.

### Historias 

- Como usuario eu gostaria de poder entrar em contato com o responsavel de maneira facil e rapida
- como usuario eu gostaria de poder agendar o uso de certos locais de forma facil e rapida
- como usuario eu gostaria de receber notificacoes de coisas importantes
- como usuario eu gostaria de inserir deletar ou editar os dados de um usuario.
- como usuario eu gostaria de ver um historico de lugares que eu aluguei.
- como usuario eu gostaria de poder registrar ocorrencias.





## Aula 05/08

- JRE - Java Runtime Enviroment
  - Ambiente mínimo para executar um programa Java
  - JVM - Java Virtual Machine (java.exe ou javaw.exe)

- JDK - Java Development Kit
  - [Adoptium JDK](https://adoptium.net/pt-BR)
  - Ambiente de DESENVOLVIMENTO (javac.exe) compilador

- COMPILAÇÃO

	- Escreve um programa em java (arquivo.java)
	- Compilação arquivo.java -> javac.exe -> bytecode arquivo.class
	- EXECUÇÃO 3 Passar .class -> java.exe (JVM) -> ling máquina

- VSCode

VSCode
	- Java Extension Packava.exe (JVM) -> ling máquina
#

### aula  20/08

```mermaid
---
title: Diagrama de Entidades
---
classDiagram
    Locacao "*" --> "1" Locatario
    Locacao "*" --> "1" Imovel
    Imovel "*" --> "1" Condominio
    Imovel "*" --> "1" Proprietario
    Espaco "*" --> "1" Condominio
    Reserva "*" --> "1" Espaco
    Reserva "*" --> "1" Locatario
    

    Locacao ..> StatusLocacao
    Imovel ..> StatusImovel
    Espaco ..> StatusEspaco
    Reserva ..> StatusReserva

    
    

    namespace entity {
      class Proprietario{

        -id : Long
        -nome : String
        -cpf : String
        -dataNascimento : LocalDate
        -email : String
        -telefone : String

        +getId()long
        +setId(id:long) void
        +getNome() String
        +setNome(nome:String) void
        +getCpf() String
        +setCpf(cpf:String) void
        +getEmail() String
        +setEmail(email:String) void
        +getTelefone() String
        +setTelefone(telefone:String) void
        +getDataNascimento() LocalDate
        +setDataNascimento(LocalDate:Date) void
        

      }

      class Locatario{
          -id : long
          -nome : String
          -cpf : String 
          -endereco : String
          -telefone : String
          -dataNascimento: LocalDate

          +getId()long
          +setId(id:long) void
          +getNome() String
          +setNome(nome:String) void
          +getCpf() String
          +setCpf(cpf:String) void
          +getEndereco() String
          +setEndereco(endereco:String) void
          +getTelefone() String
          +setTelefone(telefone:String) void
          +getDataNascimento() LocalDate
          +setDataNascimento(LocalDate:Date) void
      }
      class Locacao{
        -id : Long
        -locatario : Locatario
        -imovel : Imovel
        -dataInicio : LocalDtate
        -dataFim: LocalDate
        -valorAluguel : Double
        -statusLocacao : Enum "Ativa","Encerrada","Inadimplente"

        +getId()long
        +setId(id:long) void
        +getLocatario() Locatario
        +setLocatario(locatario:Locatario) void
        +getImovel() Imovel
        +setImovel(imovel:Imovel) void
        +getDataInicio() LocalDate
        +setDataInicio(dataInicio:LocalDate) void
        +getDataFim() LocalDate
        +setDataFim(dataFim:LocalDate) void
        +getValorAluguel() Double
        +setValorAlguel(valorAluguel:Double) void
        +getStatusLocacao() Enum
        +setStatus(StatusLocacao:Enum) void

      }

      class Condominio{
        -id : Long
        -nome : String
        -endereco : String
        -cnpj : String
        -sindico : Locatario

        +getId() Long
        +setId(id:Long) void
        +getNome() String
        +setNome(nome:String) void
        +getEndereco() String
        +setEndereco(endereco:String) void
        +getCnpj() String
        +setCnpj(cnpj:String) void
        +getSindico() Locatario
        +setSindico(sindico:Locatario) void

      }

      class Imovel{
      -id : Long
      -numero : String
      -bloco : String
      -qtdeQuartos : Integer
      -qtdeBanheiros : Integer
      -vagaGaragem : Integer
      -statusImovel : Enum "Ocupado","Disponivel","Manutencao"
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
      +serQtdeBanheiros(qtdeBanheiros:Integer) void
      +getVagaGaragem() Integer
      +setVagaGaragem(vagaGaragem:Integer) void
      +getStatusImovel() Enum
      +setStatusImovel(statusImovel:Enum) void
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
        -statusEspaco : Enum
        condominio : Condominio

        +getId() Long
        +setId(id:Long) void
        +getNome() String
        +setNome(nome:String) void
        +getDescricao() String
        +setDescricao(descricao:String) void
        +getCapacidadeMaxima() Integer
        +setCapacidadeMaxima(capacidadeMaxima:Integer) void
        +getStatusEspaco() Enum
        +setStatusEspaco(statusEspaco:Enum) void
        +getCondominio() Condominio
        +setCondominio(condominio:Condominio) void
      }

      class Reserva{

        -id : Long
        -espaco : Espaco
        -locatario : Locatario
        -dataEvento : LocalTime
        -valorTotal : Double
        -observacoes : String
        -StatusReserva : Enum

        +getId() Long
        +setId(id:Long) void
        +getEspaco() Espaco
        +setEspaco(espaco:Espaco) void
        +getLocatario() Locatario
        +setLocatario(locatario:Locatario) void
        +getDataEvento() LocalTime
        +setDataEvento(dataEvento:LocalTime) void
        +getValorTotal() Double
        +setValorTotal(valorTotal:Double) void
        +getObservacoes() String
        +setObservacoes(observacoes:String) void
        +getStatusReserva() Enum
        +setStatusReserva(statusReserva:Enum) void

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