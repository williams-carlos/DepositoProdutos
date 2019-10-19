/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.depositoprodutos.modelos;

/**
 *
 * @author williams
 */
public class Produto {
    
    private String nome_produto;
    private float preco_produto;
    private int codigo;
    private Caracteristica caracteristica;

    public Produto() {
        caracteristica = new Caracteristica();
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

   
    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public float getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(float preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(nome_produto).append(" -- ").append(preco_produto).append(" -- ").append(codigo).append("  ---- ").append(caracteristica).append(" -- ");
        return sb.toString();
    }
}
