# API de Cursos de Programação - Desafio 01

## 🚀 Introdução

Bem-vindos ao Desafio 01 da trilha de Java do Ignite! Este projeto é uma oportunidade incrível de aplicar na prática os conceitos aprendidos sobre desenvolvimento de APIs com Java. Preparamos um desafio que simula um cenário real de desenvolvimento de uma API para gestão de cursos de programação. Está pronto para reforçar seus conhecimentos e mergulhar de cabeça nessa jornada? Vamos lá!

## 💡 Sobre o Desafio

O objetivo é desenvolver uma API fictícia para uma empresa de cursos de programação, focando inicialmente no CRUD (Create, Read, Update, Delete) de cursos. Com esta API, você poderá criar, listar, atualizar e remover cursos, praticando os conceitos essenciais para qualquer desenvolvedor backend.

### 🛠️ Funcionalidades

- **Criação de um novo curso:** Adiciona um curso ao banco de dados.
- **Listagem de todos os cursos:** Exibe todos os cursos cadastrados.
- **Atualização de um curso pelo ID:** Modifica os dados de um curso específico.
- **Remoção de um curso pelo ID:** Exclui um curso do banco de dados.
- **Ativação de um curso:** Alterna o status de um curso entre ativo e inativo.

### 📋 Estrutura dos Dados

Cada curso deve conter:

- `id`: Identificador único.
- `name`: Nome do curso.
- `category`: Categoria do curso.
- `active`: Status do curso (ativo/inativo).
- `created_at`: Data de criação do curso.
- `updated_at`: Data da última atualização do curso.

### 🔗 Rotas

- `POST /cursos`: Cria um novo curso.
- `GET /cursos`: Lista todos os cursos.
- `PUT /cursos/:id`: Atualiza um curso pelo ID.
- `DELETE /cursos/:id`: Remove um curso pelo ID.
- `PATCH /cursos/:id/active`: Altera o status de ativação de um curso.

## 📘 Guia de Instalação e Execução

1. **Clone o repositório**
```bash
   git clone [URL_DO_REPOSITÓRIO]
   cd [NOME_DO_REPOSITÓRIO]
```


2. **Configure o ambiente**
- Garanta que o Java e o Maven estejam instalados.


3. **Instale as dependências**
```bash
mvn install
```

4. **Execute a aplicação**
```bash
mvn spring-boot:run
```

5. **Acesse as rotas através de um cliente HTTP, como Postman ou Insomnia.**

## 📚 Recursos Adicionais

- **Validação de campos:** Garanta a presença dos campos `name` e `category` nas requisições.
- **Tratamento de exceções:** Implemente uma maneira eficiente de lidar com erros e exceções.

## 💖 Contribua

Sua contribuição é muito bem-vinda! Se você tem sugestões para melhorar este projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
