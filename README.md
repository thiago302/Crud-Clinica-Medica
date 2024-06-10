# Sistema de Gerenciamento de Clínica Médica

Este projeto é um sistema completo de gerenciamento de uma clínica médica, desenvolvido utilizando tecnologias modernas de desenvolvimento web. O sistema permite cadastrar clínicas, marcar consultas, gerar diagnósticos automáticos, gerir consultas e visualizar relatórios de atendimentos.

## 🚀 Funcionalidades

- **Cadastro de Clínicas**: Permite o cadastro de clínicas, registrando informações essenciais como nome e capacidade de atendimento diário.
- **Marcação de Consultas**: Interface intuitiva para agendar consultas, incluindo campos para nome do paciente, data, horário, sintomas e gravidade do caso.
- **Diagnóstico Automático**: Sistema que processa a gravidade dos sintomas e gera automaticamente um diagnóstico sugerido.
- **Gestão de Consultas**: Visualização de todas as consultas agendadas, com possibilidade de editar ou excluir registros.
- **Relatórios de Atendimentos**: Listagem de todas as consultas realizadas, facilitando o acompanhamento das atividades da clínica.

## 🛠️ Tecnologias Utilizadas

- **Backend**: Java com Servlet e JDBC para a lógica de negócios e conexão com o banco de dados.
- **Frontend**: HTML e CSS para a interface de usuário.
- **Banco de Dados**: MySQL para armazenar dados das clínicas, consultas e diagnósticos.


## 🚀 Como Executar o Projeto

### Pré-requisitos

- Java Development Kit (JDK) 8 ou superior
- Apache Tomcat 9 ou superior
- MySQL 5.7 ou superior
- Maven


### Instruções

1. **Clone o repositório**: Copie o repositório do GitHub para sua máquina local.
2. **Configure o banco de dados**: Crie um banco de dados no MySQL e execute o script SQL fornecido no projeto para criar as tabelas necessárias.
3. **Configure o arquivo de propriedades do banco de dados**: Edite o arquivo `database.properties` com as informações do seu banco de dados MySQL.
4. **Compile o projeto**: Use Maven para compilar o projeto.
5. **Desploy no Tomcat**: Copie o arquivo WAR gerado para o diretório `webapps` do Tomcat e inicie o servidor.

Preencha as seções "Integrantes" e "Contato" com as informações apropriadas antes de usar o README.md no seu repositório.

