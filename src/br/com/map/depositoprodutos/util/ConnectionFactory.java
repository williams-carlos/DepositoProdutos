
package br.com.map.depositoprodutos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    
    private static final String URL = ConfigUtil.getConf(ConfigUtil.CONF_JDBC_URL);
    private static final String USUARIO = ConfigUtil.getConf(ConfigUtil.CONF_JDBC_USUARIO);
    private static final String SENHA = ConfigUtil.getConf(ConfigUtil.CONF_JDBC_SENHA);
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException ex) {
            System.out.println(MensagemUtil.getMensagem(MensagemUtil.MSG_ERRO) + ex.getMessage());
            return null;
        }
    }
}
