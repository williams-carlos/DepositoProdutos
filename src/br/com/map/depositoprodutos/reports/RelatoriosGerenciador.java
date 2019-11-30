/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.depositoprodutos.reports;

import br.com.map.depositoprodutos.modelos.Produto;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author williams
 */
public class RelatoriosGerenciador {
    
   private static String path
            = RelatoriosGerenciador.class.getClassLoader().getResource("").getPath() + "/br/com/map/depositoprodutos/reports";

    public static JasperPrint gerarRelatorioProdutos(List<Produto> produtos) throws JRException {

        // compilar arquivo jrxml -> JasperPeport
        JasperReport report = JasperCompileManager.compileReport(path + "/Produtos.jrxml");
        // preencher report com lista de clientes
        return JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(produtos));

    }
    
    public static JasperPrint gerarRelatorioProdutosMais1000$(List<Produto> produtos) throws JRException {

        // compilar arquivo jrxml -> JasperPeport
        JasperReport report = JasperCompileManager.compileReport(path + "/Produtos.jrxml");
        // preencher report com lista de clientes
        return JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(produtos));

    }


}
