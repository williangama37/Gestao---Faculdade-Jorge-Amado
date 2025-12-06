/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/unijorgedb","root","root");
        } catch(SQLException erro){
            throw new RuntimeException(erro);
        }
    }
    
}
