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
import models.Aluno;

/**
 *
 * @author willi
 */
public class AlunoDAO {
    
    private Connection con;
    
    public AlunoDAO(){
        //conectar banco
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarAluno(Aluno obj){
        try {
            //1 - Criar o comando SQL
            String sql = "insert into aluno (nome,email,data_nascimento,endereco,curso,TelefoneCelular,WhatsApp) "
                    + "values (?,?,?,?,?,?,?)";
            
            //2 - Organizar e executar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setDate(3, java.sql.Date.valueOf(obj.getData_nascimento()));
            stmt.setString(4, obj.getEndereco());
            stmt.setString(5, obj.getCurso());
            stmt.setString(6, obj.getTelefoneCelular());
            stmt.setString(7, obj.getWhatsapp());
            
            //3 - Executar e fechar a conexão
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Aluno cadastrado");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public List<Aluno> listarAlunos(){
        try {
            //criar o comando SQL
            String sql = "select * from aluno";
            
            //criar a lista
            List<Aluno> lista = new ArrayList<>();
            
            //Organizar e executar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Aluno obj = new Aluno();
                
                //montar o objeto
                obj.setId_aluno(rs.getInt("id_aluno"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                obj.setEndereco(rs.getString("endereco"));
                obj.setCurso(rs.getString("curso"));
                obj.setTelefoneCelular(rs.getString("TelefoneCelular"));
                obj.setWhatsapp(rs.getString("WhatsApp"));
                
                //Adicionar o abjeto com os dados na lista
                lista.add(obj);
            }
            return lista;
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }
    }
    
    public void alterarAluno(Aluno obj){
        try {
            //1 - Criar o comando SQL
            String sql = "update aluno set nome=?,email=?,data_nascimento=?,endereco=?,curso=?,TelefoneCelular=?,"
                    + "WhatsApp=? where id_aluno=?";
            
            //2 - Organizar e executar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setDate(3, java.sql.Date.valueOf(obj.getData_nascimento()));
            stmt.setString(4, obj.getEndereco());
            stmt.setString(5, obj.getCurso());
            stmt.setString(6, obj.getTelefoneCelular());
            stmt.setString(7, obj.getWhatsapp());          
            stmt.setInt(8, obj.getId_aluno());
            //3 - Executar e fechar a conexão
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public void excluirAluno(int id_aluno){
        try {
            //1 - Criar o comando SQL
            String sql = "delete from aluno where id_aluno=?";
            
            //2 - Organizar e executar o comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, id_aluno);

            //3 - Executar e fechar a conexão
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public List<Aluno> buscarAlunoPeloNome(String nome){
        try {
            //criar o comando SQL
            String sql = "select * from aluno where nome like ?";
            
            //criar a lista
            List<Aluno> lista = new ArrayList<>();
            
            //Organizar e executar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Aluno obj = new Aluno();
                
                //montar o objeto
                obj.setId_aluno(rs.getInt("id_aluno"));
                obj.setNome(rs.getString("nome"));
                obj.setEmail(rs.getString("email"));
                obj.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                obj.setEndereco(rs.getString("endereco"));
                obj.setCurso(rs.getString("curso"));
                obj.setTelefoneCelular(rs.getString("TelefoneCelular"));
                obj.setWhatsapp(rs.getString("WhatsApp"));
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
