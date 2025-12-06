/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author willi
 */
public class TesteConexao {
    public static void main(String[] args){
        try{
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
}
