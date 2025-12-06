# 🎓 Sistema de Gestão Acadêmica

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans&logoColor=white)

> Sistema desktop desenvolvido em Java para gerenciamento de alunos, professores, disciplinas e matrículas acadêmicas.

## 💻 Sobre o Projeto

Este projeto foi desenvolvido como parte dos estudos de **Programação Orientada a Objetos**. O objetivo foi aplicar conceitos de Engenharia de Software Banco de Dados na prática, e POO criando um sistema CRUD completo com interface gráfica em JAVA Swing.

O sistema permite o controle total da vida acadêmica, desde o cadastro de entidades básicas até o lançamento de notas com cálculo automático de médias.

## ⚙️ Funcionalidades

- **Gerenciamento de Pessoas:**
  - Cadastro, edição e exclusão de Alunos e Professores.
  - Validação de datas (Java `LocalDate`) e formatação BR.
- **Gestão Acadêmica:**
  - Cadastro de Disciplinas vinculadas a Professores (Chave Estrangeira).
  - Listagem inteligente com **Inner Join** (exibindo nomes ao invés de IDs).
- **Matrícula e Notas:**
  - Matrícula de alunos em disciplinas.
  - Sistema de lançamento de notas (AV1, AV2, AV3).
  - **Regra de Negócio:** O sistema calcula a média final automaticamente.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java (JDK 17+)
- **Interface:** Java Swing (JFrame, JTable, JComboBox)
- **Banco de Dados:** MySQL 8.0
- **Acesso a Dados:** JDBC (Java Database Connectivity)
- **Padrões de Projeto:**
  - **MVC** (Model-View-Controller)
  - **DAO** (Data Access Object)
  - **Singleton** (Connection Factory)

## 🗄️ Modelagem do Banco de Dados

O banco de dados `unijorgedb` foi modelado para garantir integridade referencial.
Principais tabelas:
- `aluno`
- `professor`
- `disciplina` (FK para professor)
- `matricula` (FK para aluno e disciplina)

## 📸 Screenshots
<img width="902" height="644" alt="Sistema - cadastro aluno" src="https://github.com/user-attachments/assets/75ec5ce8-0f20-4a8a-b85d-50931e2b6513" />
<img width="899" height="643" alt="Sistema - nota aluno" src="https://github.com/user-attachments/assets/46d9e63f-3e17-42ef-abd7-7e372e1e0ba4" />
<img width="901" height="641" alt="Sistema - professores" src="https://github.com/user-attachments/assets/1aec5e5d-6022-4ecd-97ab-15d2080fb06f" />


