
package br.com.map.depositoprodutos.util;

import java.util.ResourceBundle;

public class ConfigUtil {
    
    private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static final String CONF_JDBC_URL = "conf.jdbc.url";
    public static final String CONF_JDBC_USUARIO = "conf.jdbc.usuario";
    public static final String CONF_JDBC_SENHA = "conf.jdbc.senha";
    
    public static String getConf(String key){
        return bundle.getString(key);
    }
}
