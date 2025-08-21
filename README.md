
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
    Morador "1" --> "*" LocalAlugar
    Morador "*" --> "*" RegistroOcorrencia
    

    namespace entity {
      class Morador{
          -id : long
          -nome : String
          -endereco : String
          -telefone : String
          -dataNascimento: Date

          +getId()long
          +setId(id:long) void
          +getNome() String
          +setNome(nome:String) void
          +getEndereco() String
          +setEndereco(endereco:String) void
          +getTelefone() String
          +setTelefone(telefone:String) void
          +getDataNascimento() Date
          +setDataNascimento(dataNascimento:Date) void
      }
      class LocalAlugar{
          -id : long
          -nome : String
          -descricao : String
          -estaAlugado : Bool
          -data : date

          +getId():long
          +setId(id:long) void
          +getNome() String
          +setNome(nome:String) void
          +getDescricao() String
          +setDescricao(descricao:String) void
          +getEstaAlugado() Bool
          +setEstaAlugado(estaAlugado:Bool) void
          +getData() date
          +setDate(data:date) void
          

      }
      class RegistroOcorrencia{
          -id : long
          -nomeLocal : String
          -descricao : String
          -data : date
          -moradorReport : String
        
          +getId() long
          +setId(id:long) void
          +getNomeLocal() String
          +setNome(nomeLocal:String) void
          +getDescricao() String
          +setDescricao(descricao:String) void
          +getData() date
          +setDate(data:date) void
          +getMoradorReport() String
          +setMoradorReport(moradorReport:String) void

      }

      class HistoricoReserva{
        -id : long
        -nomeArea : String
        -dataAlugado : date
        -moradorRented : String

        +getId() long
        +setId(id:long) void
        +getNomeArea()  String
        +setNomeArea(nomeArea: String) void
        +getDataAlugado() date
        +setDataAlugado(dataAlugado: date) void
        +getMoradorRented() String
        +setMoradorRented (moradorRented:String) void 

      }
      class HistoricoDeOcorrencia{
        -id : long
        -nomeArea : String
        -dataAlugado : date
        -moradorReport : String

        +getId() long
        +setId(id:long) void
        +getNomeArea()  String
        +setNomeArea(nomeArea: String) void
        +getDataAlugado() date
        +setDataAlugado(dataAlugado: date) void
        +getMoradorReport() String
        +setMoradorReport (moradorReport:String) void 

      }
 
      
      
    }
