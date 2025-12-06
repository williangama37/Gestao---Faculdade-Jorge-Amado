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
import models.Disciplina;

/**
 *
 * @author willi
 */
public class DisciplinaDAO {
    
    private Connection con;
    
    public DisciplinaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarDisciplina(Disciplina obj){
        try {
            // 1 - Instrução SQL (Note que id_professor entra aqui como inteiro)
            String sql = "insert into disciplina (nome, carga_horaria, semestre, id_professor) values (?,?,?,?)";
            
            // 2 - Preparar conexão
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getCarga_horaria());
            stmt.setInt(3, obj.getSemestre());
            stmt.setInt(4, obj.getId_professor());  // Chave Estrangeira (FK)
            
            // 3 - Executar
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar disciplina: " + erro);
        }
    }
    
    public List<Disciplina> listarDisciplinas(){
        try {
            //--- Observação ---
            // Para trazer o NOME do professor junto, precisaríamos de um INNER JOIN.
            String sql = "SELECT d.id_disciplina, d.nome, d.carga_horaria, d.semestre, d.id_professor, "
                       + "p.nome AS nome_professor " // Trouxemos o nome!
                       + "FROM disciplina AS d "
                       + "INNER JOIN professor AS p ON d.id_professor = p.id_professor";
            
            List<Disciplina> lista = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Disciplina obj = new Disciplina();
                
                obj.setId_disciplina(rs.getInt("id_disciplina"));
                obj.setNome(rs.getString("nome"));
                obj.setCarga_horaria(rs.getInt("carga_horaria"));
                obj.setSemestre(rs.getInt("semestre"));
                obj.setId_professor(rs.getInt("id_professor"));
                obj.setNomeProfessor(rs.getString("nome_professor"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + erro);
            return null;
        }
    }
    
    public void alterarDisciplina(Disciplina obj){
        try {
            String sql = "update disciplina set nome=?, carga_horaria=?, semestre=?, id_professor=? where id_disciplina=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setInt(2, obj.getCarga_horaria());
            stmt.setInt(3, obj.getSemestre());
            stmt.setInt(4, obj.getId_professor());
            
            stmt.setInt(5, obj.getId_disciplina()); // O ID vai no final para o WHERE
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Disciplina alterada com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + erro);
        }
    }
    
    public void excluirDisciplina(int id_disciplina){
        try {
            String sql = "delete from disciplina where id_disciplina=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_disciplina);
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso!");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + erro);
        }
    }
    
    public List<Disciplina> buscarDisciplinaPeloNome(String nome){
        try {
            
            String sql = "SELECT d.*, p.nome AS nome_professor "
                       + "FROM disciplina AS d "
                       + "INNER JOIN professor AS p ON d.id_professor = p.id_professor "
                       + "WHERE d.nome LIKE ?";
            
            List<Disciplina> lista = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, "%" + nome + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Disciplina obj = new Disciplina();
                
                // Mapeamento (está correto)
                obj.setId_disciplina(rs.getInt("id_disciplina"));
                obj.setNome(rs.getString("nome"));
                obj.setCarga_horaria(rs.getInt("carga_horaria"));
                obj.setSemestre(rs.getInt("semestre"));
                obj.setId_professor(rs.getInt("id_professor"));
                
                // Pegando a coluna extra que criamos no SELECT
                obj.setNomeProfessor(rs.getString("nome_professor"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + erro);
            return null;
        }
    }
}