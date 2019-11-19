/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.depositoprodutos.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author williams
 */
public class MensagemUtil {
    
    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale EN_US = new Locale("en", "US");
    public static final Locale ES_ES = new Locale("es", "ES");
    
     private static ResourceBundle resource = ResourceBundle.getBundle("mensagens", PT_BR);
     
     
    public static final String MSG_VALIDACAO_NOME = "msg.validacao.nome";
    public static final String MSG_VALIDACAO_VALOR = "msg.validacao.valor";
    
    public static final String MSG_ERRO = "msg.erro";
    public static final String MSG_ERRO_SELECIONAR = "msg.erro.selecionar";
    public static final String MSG_ERRO_CONSULTAR = "msg.erro.consultar ";

    public static final String MSG_LABEL_NOME  = "msg.label.nome";
    public static final String MSG_LABEL_VALOR = "msg.label.valor";
    public static final String MSG_LABEL_MARCA = "msg.label.marca";
    public static final String MSG_LABEL_SIST_OPER = "msg.label.so";
    public static final String MSG_LABEL_COR = "msg.label.cor";
    public static final String MSG_LABEL_DETALHES = "msg.label.detalhes";
     
    public static final String MSG_LABEL_BUSCAR = "msg.label.buscar";
    public static final String MSG_LABEL_TITULO = "msg.label.titulo";
    public static final String MSG_LABEL_NOVO_PRODUT = "msg.label.novo.titulo";
    public static final String MSG_LABEL_EDITAR_PRODUT = "msg.label.editar.titulo";
            
    public static final String MSG_BUTTON_SALVAR = "msg.button.salvar";
    public static final String MSG_BUTTON_CANCELAR = "msg.button.cancelar";
    public static final String MSG_BUTTON_NOVO = "msg.button.novo";
    public static final String MSG_BUTTON_EDITAR = "msg.button.editar";
    public static final String MSG_BUTTON_EXCLUIR = "msg.button.excluir";
    public static final String MSG_BUTTON_SAIR = "msg.button.sair";
    public static final String MSG_TABELA_CODIGO = "msg.tabela.codigo";
    public static final String MSG_TABELA_NOME = "msg.tabela.nome";
    public static final String MSG_TABELA_VALOR = "msg.tabela.valor";
    public static final String MSG_TABELA_MARCA = "msg.tabela.marca";
    public static final String MSG_TABELA_SISTMA_OPE = "msg.tabela.so";
    public static final String MSG_TABELA_COR = "msg.tabela.cor";
    public static final String MSG_TABELA_DETALHES = "msg.tabela.detalhes";
    
    
    public static String getMensagem(String key){
        return resource.getString(key);
    }
    
    public static void setLocale(Locale local){
        resource = ResourceBundle.getBundle("mensagens", local);
    }
}
