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
public class Caracteristica {
    
    private String marca;
    private String sistemaOpe;
    private String cor;
    private int codigo;
    private String detalhes;

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistemaOpe() {
        return sistemaOpe;
    }

    public void setSistemaOpe(String sistemaOpe) {
        this.sistemaOpe = sistemaOpe;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
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
         sb.append(codigo).append("  //  ").append(marca).append("  //  ").append(sistemaOpe).append("  //  ").append(cor).append("// ").append(detalhes);
        return sb.toString();
    }
    
}
