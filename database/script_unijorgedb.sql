-- 1. Criação do Banco de Dados
CREATE DATABASE unijorgedb;
USE unijorgedb;

-- 2. Tabela Professor
-- (Criada primeiro pois será referenciada na disciplina)
CREATE TABLE professor (
    id_professor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    especialidade VARCHAR(50),
    endereco VARCHAR(200),
	TelefoneCelular VARCHAR(15),
    WhatsApp VARCHAR(15)
);

-- 3. Tabela Disciplina
-- (Possui uma FK ligando ao professor responsável)
CREATE TABLE disciplina (
    id_disciplina INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    carga_horaria INT,
    semestre INT,
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES professor(id_professor)
);

-- 4. Tabela Aluno
CREATE TABLE aluno (
    id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    data_nascimento DATE,
    endereco VARCHAR(200),
    curso VARCHAR(100),
	TelefoneCelular VARCHAR(15),
    WhatsApp VARCHAR(15)
);

-- 5. Tabela de Associação (Matrícula)
-- (Conecta Alunos às Disciplinas)
CREATE TABLE matricula (
    id_matricula INT AUTO_INCREMENT PRIMARY KEY,
    id_aluno INT NOT NULL,
    id_disciplina INT NOT NULL,
    data_matricula DATE DEFAULT (CURRENT_DATE),
    av1 DECIMAL(4,2),
	av2 DECIMAL(4,2),
	av3 DECIMAL(4,2),
    media_final DECIMAL(4,2),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina)
);