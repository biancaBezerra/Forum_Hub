# API FórumHub
***
## Índice
- [Introdução](#introdução)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configurações e Dependências](#configurações-e-dependências)
- [Funcionalidades da API](#funcionalidades-da-api)
- [Validações e Padrões de Projeto](#validações-e-padrões-de-projeto)
- [Documentação da API](#documentação-da-api)
- [Segurança com Spring Security](#segurança-com-spring-security)
- [Conclusão](#conclusão)
- [Agradecimentos](#agradecimentos)
***

## Introdução
A API FórumHub foi desenvolvida para replicar a funcionalidade de um fórum de perguntas e respostas, permitindo aos usuários criar, visualizar, atualizar e deletar tópicos. Este projeto tem como objetivo proporcionar um ambiente de aprendizado e colaboração, similar ao fórum utilizado na plataforma Alura.

## Estrutura do Projeto
A aplicação foi organizada em três principais pacotes:
- **Controller**
- **Domain**
- **Infra**

No pacote `domain`, temos classes relacionadas aos tópicos e usuários. No pacote `infra`, estão as configurações de infraestrutura, incluindo frameworks e bibliotecas usadas no projeto.

## Configurações e Dependências
Utilização de módulos como Web, Validação e Spring Data JPA. Bibliotecas adicionais como o driver do MySQL, Flyway e Lombok. Configurações do projeto Spring Boot.

## Funcionalidades da API
- **Cadastro de Tópicos:** Permite criar, ler, atualizar e deletar tópicos.
- **Visualização de Tópicos:** Permite listar todos os tópicos e visualizar detalhes de um tópico específico.

Este aplicativo foi projetado para ser fácil de usar, permitindo que os usuários realizem operações de CRUD para os tópicos de forma eficiente.


Padronização dos retornos dos métodos da API com `ResponseEntity`, aplicando boas práticas do protocolo HTTP.

## Validações e Padrões de Projeto
Isolamento de validações usando validadores injetados por polimorfismo com interface e List. Aplicação dos princípios do SOLID para manter o código fácil de entender e de manter.

No pacote `infra > exception`, foi criada a classe `TratadorDeErros` seguindo o conceito de Controller Advice do Spring Boot para tratamento de erros, simplificando o manejo de exceções.

## Documentação da API
Aplicado com SpringDoc ao projeto para gerar documentação. Com a utilização do Swagger para acessar a interface gráfica, simular requisições e incluir cabeçalhos de autenticação JWT. A documentação gerada é útil para equipes de desenvolvimento de front-end e mobile.

## Segurança com Spring Security
Adicionamos o Spring Security ao projeto, implementando autenticação e autorização por tokens JWT. Configuramos o Spring Security para usar autenticação stateless e hashing de senha com BCrypt.

## Conclusão
Habilidades adquiridas com esta API:
- Criação de uma API do zero com o Spring usando o Spring Initializr.
- Implementação de funcionalidades, controller e repository.
- Uso do Flyway para migrations.
- Implementação de CRUD com validações.
- Aumentando a segurança da aplicação com Spring Security.

## Agradecimentos
Gostaria de agradecer à [Alura](https://www.alura.com.br) e à [Oracle Next Education](https://www.oracle.com/br/education/oracle-next-education/) pelo suporte e pelos recursos fornecidos durante todo o curso. O conhecimento adquirido foi inestimável para o meu desenvolvimento como desenvolvedora.
