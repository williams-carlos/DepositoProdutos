/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.depositoprodutos.dao;

import br.com.map.depositoprodutos.modelos.Produto;
import br.com.map.depositoprodutos.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author williams
 */
public class ProdutoDao {
    
    private Connection con;
    private PreparedStatement st;
    private String sql;
    
    public void inserir(Produto produto) throws SQLException{
       // inserir caracteristica
        sql = "insert into caracteristicas (marca, sistema_operacional, cor, detalhes) values(?, ?, ?, ?)";
        
        con = ConnectionFactory.getConnection();
        
        // avisa que retornará  a chave primaria gerada, que será usada como chave estrangeira na tabela produto
        st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        
        st.setString(1, produto.getCaracteristica().getMarca());
        st.setString(2, produto.getCaracteristica().getSistemaOpe());
        st.setString(3, produto.getCaracteristica().getCor());
        st.setString(4, produto.getCaracteristica().getDetalhes());
        
        st.executeUpdate();
        
        // recuperar a chave primaria(codigo) gerado
        ResultSet rs = st.getGeneratedKeys();
        int codigoEndereco = 0;
        if(rs.next())
            codigoEndereco = rs.getInt(1);
                        
              
        //inserir produto
        sql = "insert into produtos (nome_produto , preco_produto, codigo_caract) values(?, ?, ?)";
        
        con = ConnectionFactory.getConnection();
        
        st = con.prepareStatement(sql);
                        
        st.setString(1, produto.getNome_produto());
        st.setFloat(2, produto.getPreco_produto());
        st.setInt(3, codigoEndereco);
                        
        st.executeUpdate();
                        
        con.close();
    }
    public void editar(Produto produto) throws SQLException{
        sql = "update produtos set nome_produto = ?, preco_produto = ? where codigo = ?";
               // + "select c.*, e.*  "
               // + "from clientes c, enderecos e "
               // + "where c.codigo_endereco = e.codigo";
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sql);
        st.setString(1, produto.getNome_produto());
        st.setFloat(2, produto.getPreco_produto());
        st.setInt(3, produto.getCodigo());
        st.executeUpdate();
        
        sql = "update caracteristicas set marca = ?, sistema_operacional = ?, cor = ?, detalhes = ? where codigo_caract = ?";
        st = con.prepareStatement(sql);
        st.setString(1, produto.getCaracteristica().getMarca());
        st.setString(2, produto.getCaracteristica().getSistemaOpe());
        st.setString(3, produto.getCaracteristica().getCor());
        st.setString(4, produto.getCaracteristica().getDetalhes());
        st.setInt(5, produto.getCaracteristica().getCodigo());
        st.executeUpdate();
        
        con.close();

    }
    public List<Produto> buscar(String query) throws SQLException{
       sql= "select p.*, c.* "
                + "from produtos p , caracteristicas c "
                + "where p.codigo_caract = c.codigo_caract "
                + "and p.nome_produto ilike ?";
       con = ConnectionFactory.getConnection();
       st = con.prepareStatement(sql);
       st.setString(1, query+"%");
      
       ResultSet rs = st.executeQuery();
       
       List<Produto> produtos = new ArrayList<>();
       while(rs.next()){
            int codigo = rs.getInt(1);
            String nome = rs.getString(2);
            float preco = rs.getFloat(3);
            //int codigo_caract = rs.getInt(4);
            String marca = rs.getString(5);
            String sistema_op = rs.getString(6);
            String cor = rs.getString(7);
            String detalhes = rs.getString(8);
            
            Produto p = new Produto();
            p.setCodigo(codigo);
            p.setNome_produto(nome);
            p.setPreco_produto(preco);
            //p.getCaracteristica().setCodigo(codigo_caract);
            p.getCaracteristica().setMarca(marca);
            p.getCaracteristica().setSistemaOpe(sistema_op);
            p.getCaracteristica().setCor(cor);
            p.getCaracteristica().setDetalhes(detalhes);
            produtos.add(p);
       }
       con.close();
       return produtos;
       
    }
    public List<Produto> listar() throws SQLException{
         sql = "select p.*, c.* "
             + "from produtos p , caracteristicas c "
             + "where p.codigo_caract = c.codigo_caract";
         
     
        con= ConnectionFactory.getConnection();
        st = con.prepareStatement(sql);
        ResultSet rs =  st.executeQuery();
        List<Produto> list = new ArrayList<>();
        while(rs.next()){
           
            int codigo = rs.getInt("codigo");
            String nome = rs.getString(2);
            float preco = rs.getFloat(3);
            int codigo_caract = rs.getInt(4);
            String marca = rs.getString(6);
            String sistema_op = rs.getString(7);
            String cor = rs.getString("cor");
            String detalhes = rs.getString(9);
            
            Produto p = new Produto();
            p.setCodigo(codigo);
            p.setNome_produto(nome);
            p.setPreco_produto(preco);
            p.getCaracteristica().setCodigo(codigo_caract);
            p.getCaracteristica().setMarca(marca);
            p.getCaracteristica().setSistemaOpe(sistema_op);
            p.getCaracteristica().setCor(cor);
            p.getCaracteristica().setDetalhes(detalhes);  
            list.add(p);
        }
        con.close();
        return list;
    }
    
    public Produto buscarPorCodigo(int codigo) throws SQLException{
       sql= "select p.*, c.* "
                + "from produtos p , caracteristicas c "
                + "where p.codigo_caract = c.codigo_caract "
                + "and p.codigo = ?";
       con = ConnectionFactory.getConnection();
       st = con.prepareStatement(sql);
       st.setInt(1, codigo);
      
       ResultSet rs = st.executeQuery();
       Produto p = null;
       if(rs.next()){
            
            String nome = rs.getString(2);
            float preco = rs.getFloat(3);
            int codigo_caract = rs.getInt(4);
            String marca = rs.getString(6);
            String sistema_op = rs.getString(7);
            String cor = rs.getString("cor");
            String detalhes = rs.getString(9);
           
            p = new Produto();
            p.setCodigo(codigo);
            p.setNome_produto(nome);
            p.setPreco_produto(preco);
            p.getCaracteristica().setCodigo(codigo_caract);
            p.getCaracteristica().setMarca(marca);
            p.getCaracteristica().setSistemaOpe(sistema_op);
            p.getCaracteristica().setCor(cor);
            p.getCaracteristica().setDetalhes(detalhes);
            
       }
       con.close();
       return p;
       
    }
    
    public void excluir(Produto produto) throws SQLException
    {
        sql = "delete from produtos where codigo = ?";
        con =  ConnectionFactory.getConnection();
        st = con.prepareStatement(sql);
        st.setInt(1, produto.getCodigo());
        st.executeUpdate();
        
        sql = "delete from caracteristicas where codigo_caract = ?";
        st = con.prepareStatement(sql);
        st.setInt(1, produto.getCaracteristica().getCodigo());
        st.executeUpdate();
        
        con.close();
    }
}
