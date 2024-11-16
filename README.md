# Flash Pomo Backend

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

## Tecnologias Utilizadas

- Java 11
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Lombok

## Configuração do Ambiente

1. Certifique-se de ter o Java 11 e o Maven instalados em sua máquina.
2. Instale e configure o MySQL em sua máquina.
3. Clone o repositório do projeto:

```
git clone https://gitlab.com/jala-university1/cohort-4/oficial-pt-desenvolvimento-de-software-1-iso-115/se-o-c/equipe-4/flash-pomo-backend.git
```

4. Acesse o diretório do projeto:

```
cd flash-pomo-backend
```

5. Crie um arquivo `application.properties` na pasta `src/main/resources` e configure as seguintes propriedades:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/flash_pomo
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

6. Compile e execute o projeto:

```
./mvnw spring-boot:run
```
