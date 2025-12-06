/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import models.Matricula;

/**
 *
 * @author willi
 */
public class MatriculaDAO {
    
    private Connection con;
    
    public MatriculaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    // 1. Cadastrar (Aqui usamos os IDs, pois é o que o banco exige para salvar)
    public void cadastrarMatricula(Matricula obj){
        try {
            String sql = "insert into matricula (id_aluno, id_disciplina, data_matricula, av1, av2, av3, media_final) values (?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId_aluno());
            stmt.setInt(2, obj.getId_disciplina());
            // Tratamento de Data
            stmt.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
            // Tratamento de Nota deixando vazia
            stmt.setNull(4, java.sql.Types.DOUBLE);
            stmt.setNull(5, java.sql.Types.DOUBLE);
            stmt.setNull(6, java.sql.Types.DOUBLE);
            
            //Campo para a media, que vai ser calculada no jframe
            stmt.setNull(7, java.sql.Types.DOUBLE);
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Matrícula realizada com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao realizar matrícula: " + erro);
        }
    }
    
    // 2. Listar Detalhado (Usa INNER JOIN para trazer os nomes)
    public List<Matricula> listarMatriculas(){
        try {
            // Query poderosa: Une as 3 tabelas para trazer dados legíveis
            String sql = "SELECT m.id_matricula, m.id_aluno, m.id_disciplina, m.data_matricula, m.av1, m.av2, m.av3, m.media_final, "
                       + "a.nome AS nome_aluno, "
                       + "d.nome AS nome_disciplina "
                       + "FROM matricula AS m "
                       + "INNER JOIN aluno AS a ON m.id_aluno = a.id_aluno "
                       + "INNER JOIN disciplina AS d ON m.id_disciplina = d.id_disciplina";
            
            List<Matricula> lista = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Matricula obj = new Matricula();
                
                // Dados básicos da tabela matrícula
                obj.setId_matricula(rs.getInt("id_matricula"));
                obj.setId_aluno(rs.getInt("id_aluno"));
                obj.setId_disciplina(rs.getInt("id_disciplina"));
                
                if(rs.getDate("data_matricula") != null){
                     obj.setData_matricula(rs.getDate("data_matricula").toLocalDate());
                }
                
                obj.setAv1(rs.getDouble("av1"));
                obj.setAv2(rs.getDouble("av2"));
                obj.setAv3(rs.getDouble("av3"));
                obj.setMediaFinal(rs.getDouble("media_final"));
                
                // Dados extras vindos do JOIN (Aluno e Disciplina)
                obj.setNomeAluno(rs.getString("nome_aluno"));
                obj.setNomeDisciplina(rs.getString("nome_disciplina"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar matrículas: " + erro);
            return null;
        }
    }
    
    // 3. Alterar (Usa IDs para atualizar o registro correto)
    public void alterarMatricula(Matricula obj){
        try {
            String sql = "update matricula set id_aluno=?, id_disciplina=?, data_matricula=?, av1=?, av2=?, av3=?, media_final=? where id_matricula=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, obj.getId_aluno());
            stmt.setInt(2, obj.getId_disciplina());
            stmt.setDate(3, java.sql.Date.valueOf(obj.getData_matricula()));
            stmt.setDouble(4, obj.getAv1());
            stmt.setDouble(5, obj.getAv2());
            stmt.setDouble(6, obj.getAv3());
            stmt.setDouble(7, obj.getMediaFinal());
            
            stmt.setInt(5, obj.getId_matricula()); // Where id
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Matrícula alterada com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar matrícula: " + erro);
        }
    }
    
    // 4. Excluir
    public void excluirMatricula(int id_matricula){
        try {
            String sql = "delete from matricula where id_matricula=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_matricula);
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Matrícula excluída com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir matrícula: " + erro);
        }
    }
    
    // 5. Buscar por Nome do Aluno (Pesquisa inteligente com JOIN)
    public List<Matricula> buscarMatriculaPorNomeAluno(String nomeAluno){
        try {
            // Mesma query do listar, mas com filtro WHERE no nome do aluno
            String sql = "SELECT m.id_matricula, m.id_aluno, m.id_disciplina, m.data_matricula, m.av1, m.av2, m.av3, m.media_final, "
                       + "a.nome AS nome_aluno, "
                       + "d.nome AS nome_disciplina "
                       + "FROM matricula AS m "
                       + "INNER JOIN aluno AS a ON m.id_aluno = a.id_aluno "
                       + "INNER JOIN disciplina AS d ON m.id_disciplina = d.id_disciplina "
                       + "WHERE a.nome LIKE ?";
            
            List<Matricula> lista = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Adiciona % para busca parcial
            stmt.setString(1, "%" + nomeAluno + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Matricula obj = new Matricula();
                
                obj.setId_matricula(rs.getInt("id_matricula"));
                obj.setId_aluno(rs.getInt("id_aluno"));
                obj.setId_disciplina(rs.getInt("id_disciplina"));
                
                if(rs.getDate("data_matricula") != null){
                     obj.setData_matricula(rs.getDate("data_matricula").toLocalDate());
                }
                
                obj.setAv1((rs.getDouble("av1")));
                obj.setAv2((rs.getDouble("av2")));
                obj.setAv3((rs.getDouble("av3")));
                obj.setMediaFinal(rs.getDouble("media_final"));
                
                // Preenchendo os nomes para exibição
                obj.setNomeAluno(rs.getString("nome_aluno"));
                obj.setNomeDisciplina(rs.getString("nome_disciplina"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar por nome: " + erro);
            return null;
        }
    }
    
    // Método para lançar notas e atualizar a média
    public void alterarNotas(Matricula obj){
        try {
            String sql = "update matricula set av1=?, av2=?, av3=?, media_final=? where id_matricula=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setDouble(1, obj.getAv1());
            stmt.setDouble(2, obj.getAv2());
            stmt.setDouble(3, obj.getAv3());
            
            // Aqui salvamos a média que vai ser calculada no frame
            stmt.setDouble(4, obj.getMediaFinal());
            
            stmt.setInt(5, obj.getId_matricula()); // WHERE id...
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Notas lançadas com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao lançar notas: " + erro);
        }
    }
}