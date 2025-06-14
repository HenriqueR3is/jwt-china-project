<div align="center">

# 🔑 Projeto de Autenticação com Spring Boot e JWT 🔐

<p>
  Um projeto acadêmico robusto que implementa uma API RESTful completa com um sistema de autenticação e autorização baseado em JSON Web Tokens. Uma exploração prática de como construir aplicações seguras e prontas para o mundo real com o ecossistema Spring.
</p>

<p>
  <img src="https://img.shields.io/badge/Status-Concluído-4CAF50?style=for-the-badge" alt="Status do Projeto: Concluído"/>
  <img src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.3.0-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot 3.3.0"/>
  <img src="https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL 8.0"/>
</p>

</div>

---

## 🎯 Sobre o Projeto

Este projeto nasceu como uma atividade acadêmica com a missão de solidificar conceitos essenciais de segurança em APIs. A ideia foi criar do zero um backend onde diferentes tipos de usuários pudessem interagir com o sistema de acordo com suas permissões, tudo isso gerenciado por um fluxo de autenticação moderno usando JWT. Foi uma jornada incrível de aprendizado, passando por configuração de ambiente, modelagem de dados, implementação de regras de negócio e, claro, muita depuração!

---

## 🛠️ Tecnologias e Ferramentas

A fundação deste projeto foi construída com as seguintes tecnologias:

<table align="center">
  <tr>
    <td align="center" width="96">
      <a href="https://www.java.com/">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="48" height="48" alt="Java" />
      </a>
      <br>Java 17
    </td>
    <td align="center" width="96">
      <a href="https://spring.io/projects/spring-boot">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="48" height="48" alt="Spring Boot" />
      </a>
      <br>Spring Boot
    </td>
    <td align="center" width="96">
      <a href="https://spring.io/projects/spring-security">
        <img src="https://spring.io/img/projects/spring-security.svg" width="48" height="48" alt="Spring Security" />
      </a>
      <br>Spring Security
    </td>
    <td align="center" width="96">
      <a href="https://www.mysql.com/">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" width="48" height="48" alt="MySQL" />
      </a>
      <br>MySQL
    </td>
    <td align="center" width="96">
      <a href="https://maven.apache.org/">
        <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/maven/maven-original.svg" width="48" height="48" alt="Maven" />
      </a>
      <br>Maven
    </td>
     <td align="center" width="96">
      <a href="https://jwt.io/">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5Pte0L4XLvNqEWXbkCXk_LDN6eSpcaDDLhQ&s" width="48" height="48" alt="JWT" />
      </a>
      <br>JWT
    </td>
  </tr>
</table>

---

## 🚀 Como Executar

Para ter a API rodando na sua máquina local, o caminho é bem simples. Só precisa ter o **JDK 17** e o **MySQL** instalados.

```bash
# 1. Clone o repositório para a sua máquina
git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)

# 2. Entre na pasta do projeto
cd nome-da-pasta-do-projeto

# 3. Configure suas variáveis de ambiente
#    Abra o arquivo `src/main/resources/application.properties` e
#    insira suas credenciais do MySQL e uma chave secreta para o JWT.
#    (Não se esqueça de criar o usuário e o banco no MySQL antes!)

# 4. Deixe o Maven fazer a mágica!
#    Este comando vai baixar as dependências e iniciar o servidor.
mvn spring-boot:run

# 5. Pronto! A API estará acessível em http://localhost:8080

🗺️ Endpoints da API
Abaixo estão os endpoints disponíveis. Clique em cada um para ver mais detalhes, como a descrição e exemplos de corpo (body) para as requisições.

/api/auth/register

Descrição: Registra um novo usuário no sistema.
Acesso: Público
Exemplo de Corpo (Body):

JSON

{
    "name": "Henrique Reis",
    "email": "henrique@email.com",
    "password": "senha123",
    "role": "ROLE_USER"
}

/api/auth/login

Descrição: Autentica um usuário e, se as credenciais estiverem corretas, retorna um token JWT.
Acesso: Público
Exemplo de Corpo (Body):
JSON

{
    "email": "henrique@email.com",
    "password": "senha123"
}

/api/users/me

Descrição: Retorna as informações do perfil do usuário que está autenticado.
Acesso: USER ou ADMIN
Autenticação: Requer um token JWT válido no cabeçalho Authorization: Bearer <token>.

/api/admin/users

Descrição: Retorna a lista completa de todos os usuários cadastrados no sistema.
Acesso: ADMIN
Autenticação: Requer um token JWT de um usuário com o papel de administrador.
```

> [Henrique Hiroshi Koshiba Reis]