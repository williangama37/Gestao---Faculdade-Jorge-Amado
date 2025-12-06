/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import models.Professor;

/**
 *
 * @author willi
 */
public class ProfessorDAO {
    
    private Connection con;
    
    public ProfessorDAO(){
        //conectar banco
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarProfessor(Professor obj){
        try {
            //1 - Criar o comando SQL
            String sql = "insert into professor (nome,email,especialidade,endereco,TelefoneCelular,WhatsApp) "
                    + "values (?,?,?,?,?,?)";
            
            //2 - Organizar e executar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getEspecialidade());
            stmt.setString(4, obj.getEndereco());
            stmt.setString(5, obj.getTelefoneCelular());
            stmt.setString(6, obj.getWhatsApp());
            
            //3 - Executar e fechar a conexão
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Professor cadastrado");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public List<Professor> listarProfessores(){
        try {
            //criar o comando SQL
            String sql = "select * from professor";
            
            //criar a lista
            List<Professor> lista = new ArrayList<>();
            
            //Organizar e executar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Professor obj = new Professor();
                
                //montar o objeto
                obj.setId_professor(rs.getInt("id_professor"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setEspecialidade(rs.getString("especialidade"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setTelefoneCelular(rs.getString("TelefoneCelular"));
                obj.setWhatsApp(rs.getString("WhatsApp"));
                
                //Adicionar o abjeto com os dados na lista
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    public void alterarProfessor(Professor obj){
        try {
            //1 - Criar o comando SQL
            /*""insert into professor (nome,email,especialidade,endereco,TelefoneCelular,WhatsApp) "
                    + "values (?,?,?,?,?,?)";*/
            String sql = "update professor set nome=?,email=?,especialidade=?,endereco=?,TelefoneCelular=?,"
                    + "WhatsApp=? where id_professor=?";
            
            //2 - Organizar e executar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getEspecialidade());
            stmt.setString(4, obj.getEndereco());
            stmt.setString(5, obj.getTelefoneCelular());
            stmt.setString(6, obj.getWhatsApp());
            
            stmt.setInt(7, obj.getId_professor());
            //3 - Executar e fechar a conexão
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public void excluirProfessor(int id_professor){
        try {
            //1 - Criar o comando SQL
            String sql = "delete from professor where id_professor=?";
            
            //2 - Organizar e executar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, id_professor);

            //3 - Executar e fechar a conexão
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public List<Professor> buscarProfessorPeloNome(String nome){
        try {
            //criar o comando SQL
            String sql = "select * from professor where nome like ?";
            
            //criar a lista
            List<Professor> lista = new ArrayList<>();
            
            //Organizar e executar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Professor obj = new Professor();
                
                //montar o objeto
                obj.setId_professor(rs.getInt("id_professor"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setEspecialidade(rs.getString("especialidade"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setTelefoneCelular(rs.getString("TelefoneCelular"));
                obj.setWhatsApp(rs.getString("WhatsApp"));
                //Adicionar o abjeto com os dados na lista
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }

}
