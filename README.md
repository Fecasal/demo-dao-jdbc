# Demo DAO JDBC

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://github.com/Fecasal/demo-dao-jdbc/tree/main?tab=MIT-1-ov-file)

## 📖 Sobre o projeto

**Demo DAO JDBC** é um projeto de estudo de acesso a banco de dados com **Java** e **JDBC**, que implementa manualmente o padrão **DAO** (Data Access Object). Ele consiste em um cadastro simples de **Vendedores** (*Seller*) e seus respectivos **Departamentos** (*Department*), com persistência em **MySQL**.

### 🎯 Objetivos

- Conhecer os principais recursos do JDBC, na teoria e na prática.
- Elaborar a estrutura básica de um projeto com JDBC.
- Implementar o padrão DAO manualmente com JDBC.
- Aplicar conceitos de Programação Orientada a Objetos (polimorfismo, encapsulamento e associação).
- Utilizar os padrões de projeto **DAO** e **Factory** (este último para injeção de dependência).

## 🧩 Modelo conceitual

![Modelo conceitual 1](https://user-images.githubusercontent.com/120049410/225110278-aac173cf-f573-4550-ad5d-3414ddbb0c0b.png)
![Modelo conceitual 2](https://user-images.githubusercontent.com/120049410/225110294-e0ebce38-8379-46ce-b23a-3f211f217f74.png)

Cada **Vendedor** pertence a um **Departamento** (associação muitos-para-um), e um departamento possui vários vendedores.


## ⚙️ Funcionalidades

**Vendedor (Seller)**
- Inserir novo vendedor
- Atualizar dados de um vendedor
- Excluir vendedor por id
- Buscar vendedor por id
- Listar todos os vendedores
- Listar vendedores por departamento

**Departamento (Department)**
- Inserir novo departamento
- Atualizar departamento
- Excluir departamento por id
- Buscar departamento por id
- Listar todos os departamentos

---

## 🏗️ Arquitetura e padrões de projeto

- **DAO (Data Access Object):** para cada entidade existe uma interface DAO (contrato) e uma implementação JDBC responsável por todo o acesso ao banco, isolando o SQL do restante da aplicação.
- **Factory (`DaoFactory`):** cria as implementações dos DAOs e expõe apenas as interfaces, implementando injeção de dependência sem expor a implementação concreta.
- **Polimorfismo e encapsulamento:** o programa principal depende das interfaces, não das classes concretas.
- **Associação entre objetos:** `Seller` possui um `Department`.

## 🛠️ Tecnologias utilizadas

**Back end**
- Java
- JDBC
- MySQL
- Padrões DAO e Factory

## ✅ Pré-requisitos

- [JDK 11+](https://adoptium.net/) (ou a versão utilizada no projeto)
- [MySQL Server](https://dev.mysql.com/downloads/) em execução
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) (driver JDBC) adicionado ao classpath
- Uma IDE como Eclipse, IntelliJ IDEA ou VS Code (opcional)

## 📚 Aprendizados

- Uso do JDBC para armazenar e consultar dados em um banco MySQL (conexão, `PreparedStatement`, `ResultSet`).
- Tratamento de exceções personalizadas para a camada de dados.
- Implementação manual do padrão DAO e uso do padrão Factory para injeção de dependência.
- Mapeamento entre tabelas relacionais e objetos associados (`Seller` → `Department`).
- Boas práticas, como fechar recursos (`Statement`, `ResultSet`, `Connection`) e manter o SQL isolado na camada DAO.

## 👤 Autor

- [![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/fernando-casal-lires)
