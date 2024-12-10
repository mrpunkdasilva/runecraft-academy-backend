# Flash Pomo Backend

![](.gitlab/flashpomo-no-bg.png)

```
 ███████████ ████                    █████         ███████████                                   
░░███░░░░░░█░░███                   ░░███         ░░███░░░░░███                                  
 ░███   █ ░  ░███   ██████    █████  ░███████      ░███    ░███  ██████  █████████████    ██████ 
 ░███████    ░███  ░░░░░███  ███░░   ░███░░███     ░██████████  ███░░███░░███░░███░░███  ███░░███
 ░███░░░█    ░███   ███████ ░░█████  ░███ ░███     ░███░░░░░░  ░███ ░███ ░███ ░███ ░███ ░███ ░███
 ░███  ░     ░███  ███░░███  ░░░░███ ░███ ░███     ░███        ░███ ░███ ░███ ░███ ░███ ░███ ░███
 █████       █████░░████████ ██████  ████ █████    █████       ░░██████  █████░███ █████░░██████ 
░░░░░       ░░░░░  ░░░░░░░░ ░░░░░░  ░░░░ ░░░░░    ░░░░░         ░░░░░░  ░░░░░ ░░░ ░░░░░  ░░░░░░ 
```

---

## Table of Contents

<!-- TOC -->
* [Flash Pomo Backend](#flash-pomo-backend)
  * [Sobre o Projeto](#sobre-o-projeto)
    * [Objetivos](#objetivos)
  * [Tecnologias Utilizadas](#tecnologias-utilizadas)
  * [Configuração do Ambiente](#configuração-do-ambiente)
<!-- TOC -->

---

>![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

## Sobre o Projeto

O aplicativo desenvolvido é voltado para o meio acadêmico, combinando as estratégias de
estudo Pomodoro e Flashcards em um único hub. Ele oferece funcionalidades que permitem a
criação e edição de flashcards, além de gerenciar o tempo de estudo de forma eficiente através da
técnica Pomodoro.
Além disso, o aplicativo conta com funcionalidades de mercado, onde os usuários podem
negociar seus flashcards usando uma moeda própria da aplicação. Essa integração de ferramentas
proporciona um ambiente de aprendizado dinâmico e interativo, favorecendo o desenvolvimento
acadêmico e a troca de conhecimento entre os usuários.

### Objetivos
O objetivo deste relatório é documentar a criação, o desenvolvimento e o funcionamento de
um software voltado para o contexto acadêmico, abrangendo suas etapas de concepção,
implementação, modelagem e sua aplicabilidade no ambiente de estudos.

## Funcionalidades e Demonstração

> Como usar o Insominia para testar os endpoints 
> ![](./.gitlab/demo/usar-insominia.mp4)

### Usuário
- Cadastrar
![](./.gitlab/demo/auth/auth-2.mp4)

- Fazer login
![](./.gitlab/demo/auth/auth-1.mp4)

- Deletar conta
![](./.gitlab/demo/user/user-4.mp4)

- Editar conta
![](./.gitlab/demo/user/user-3.mp4)

- Retornar todos os usuários
![](./.gitlab/demo/user/user-2.mp4)

- Retornar um usuário por ID
![](./.gitlab/demo/user/user-1.mp4)

### Ensemble
- Criar um ensemble
![](./.gitlab/demo/ensemble/ensemble-6.mp4)

- Editar um ensemble
![](./.gitlab/demo/ensemble/ensemble-5.mp4)

- Deletar um ensemble
![](./.gitlab/demo/ensemble/ensemble-4.mp4)

- Editar um ensemble
![](./.gitlab/demo/ensemble/ensemble-3.mp4)

- Retornar todos os ensembles cadastrados
![](./.gitlab/demo/ensemble/ensemble-2.mp4)

- Retornar um ensemble por ID
![](./.gitlab/demo/ensemble/ensemble-1.mp4)


### Flashcards
- Criar um flashcard
![](./.gitlab/demo/flashcard/flashcard-5.mp4)

- Editar um flashcard
![](./.gitlab/demo/flashcard/flashcard-2.mp4)

- Deletar um flashcard
![](./.gitlab/demo/flashcard/flashcard-1.mp4)

- Retornar todos os flashcards cadastrados
![](./.gitlab/demo/flashcard/flashcard-4.mp4)

- Retornar um flashcard por ID
![](./.gitlab/demo/flashcard/flashcard-3.mp4)



---
## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Lombok

---
## Configuração do Ambiente

1. Certifique-se de ter o Java 11 e o Maven instalados em sua máquina.
2. Instale e configure o MySQL em sua máquina.
3. Clone o repositório do projeto:

```git
git clone https://gitlab.com/jala-university1/cohort-4/oficial-pt-desenvolvimento-de-software-1-iso-115/se-o-c/equipe-4/flash-pomo-backend.git
```

4. Acesse o diretório do projeto:

```
cd flash-pomo-backend
```

5. Crie um arquivo `application.properties` na pasta `src/main/resources` e configure as seguintes propriedades:

``` springdataql
spring.datasource.url=jdbc:postgresql://localhost:5432/flash_pomo
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

6. Compile e execute o projeto:

```
./mvnw spring-boot:run
```
---
## Desenvolvedores

- Rinaldo Lira de Albuquerque Lima 
- Rhuan Esteves
- David Souza Santos
- Gustavo Jesus da Silva
