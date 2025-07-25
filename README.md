# Zoo Management System

Sistema de gerenciamento de zoológico desenvolvido com Spring Boot, JPA e PostgreSQL.

Projeto para estudo, criado de forma autônoma, focando em aplicar conceitos de **SPRINGBOOT 1, 2 e 3**, **HTML/CSS** da trilha de estudos da **CompassUOL**, e **princípios SOLID** e **padrões de projeto** para aprofundamento em boas práticas de desenvolvimento.

## Descrição

Este projeto tem como objetivo desenvolver uma API RESTful completa para gerenciamento de um zoológico, com foco em **boas práticas de desenvolvimento**, **validação de dados** e **tratamento de exceções**. Inclui também uma interface web estática aplicando conceitos de **HTML semântico e CSS** da **Semana 9** da trilha de estudos.

### Objetivos de Estudo

- Aplicar os **princípios SOLID** 
- Implementar **padrões de projeto** 
- Praticar **arquitetura limpa** e **separação de responsabilidades**
- Desenvolver **tratamento robusto de exceções**
- Aplicar conceitos de **HTML semântico** e **CSS moderno**

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA** - Para persistência de dados
- **Spring Security** - Para autenticação e autorização
- **Spring Boot Validation** - Para validação de dados
- **PostgreSQL** - Banco de dados relacional
- **Hibernate** - ORM para mapeamento objeto-relacional
- **Maven** - Gerenciador de dependências
- **Postman** - Para testes de API
- **HTML5** - Estruturação semântica da interface web
- **CSS3** - Estilização e layout responsivo

## Funcionalidades

- **CRUD completo** de animais e habitats
- **Validação** de dados de entrada
- **Tratamento de exceções** customizadas
- **Prevenção de duplicidade** de dados
- **Relacionamento entre entidades** (Animal ↔ Habitat)
- **Interface console** para inserção de dados
- **Criação automática de tabelas** via JPA/Hibernate
- **Segurança** com Spring Security
- **API REST** com endpoints para teste
- **Interface web estática** com HTML semântico e CSS

## Arquitetura e Padrões

O projeto segue uma arquitetura em camadas aplicando princípios SOLID:

- **Entities** - Camada de domínio (Single Responsibility)
- **Repositories** - Camada de acesso a dados (Repository Pattern)
- **Services** - Camada de negócio (Dependency Inversion)
- **Controllers** - Camada de apresentação (Open/Closed)
- **Exception Handling** - Tratamento centralizado de exceções