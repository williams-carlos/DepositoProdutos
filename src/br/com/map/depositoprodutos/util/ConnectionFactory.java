
package br.com.map.depositoprodutos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/produtos";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "admin";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return null;
        }
    }
}
