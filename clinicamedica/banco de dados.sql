CREATE DATABASE basedadosalunos;

USE basedadosalunos;

CREATE TABLE aluno(
	ra int primary key auto_increment,
    nome varchar(50) not null,
    pri double not null,
    seg double not null,
    ter double not null,
    qua double not null,
    sex double,
    media double,
    faturamento varchar(20)
);
CREATE TABLE Consulta (
    id int primary key auto_increment,
    nome_paciente VARCHAR(100),
    data_consulta DATE,
    horario_consulta TIME,
    sintomas TEXT,
    diagnostico VARCHAR(255)
);

SELECT * FROM Aluno;
SELECT * FROM consulta;