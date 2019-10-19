/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.depositoprodutos.ui;


import br.com.map.depositoprodutos.dao.ProdutoDao;
import br.com.map.depositoprodutos.modelos.Produto;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author williams
 */
public class DepositoProdutosMAP {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
            Scanner input = new Scanner(System.in);
            Produto p;
            String op="";
            int codigo;
            ProdutoDao dao = new ProdutoDao();
            List<Produto> list;
            
            do{
                System.out.println("------------------ MENU -----------------------");
                System.out.println("-01- CADASTRAR ");  
                System.out.println("-02- EDITAR ");
                System.out.println("-03- BUSCAR POR CODIGO");
                System.out.println("-04- LISTAR TODOS PRODUTOS ");
                System.out.println("-05- EXCLUIR ");
                System.out.println("-06- SAIR");
                
                op= input.nextLine();
                System.out.println("opcao escolhida: "+ op);
                
                switch(op) {
                    case "1":
                        p = new Produto();
                        
                        System.out.println("---------------- CADASTRAR ----------------------");
                        System.out.println(" Nome produto:");
                        p.setNome_produto(input.nextLine());
                        
                        System.out.println("Preço :");
                        p.setPreco_produto(input.nextFloat());
                        input.nextLine();
                        
                        System.out.println("Marca:");
                        p.getCaracteristica().setMarca(input.nextLine());
                        
                        System.out.println("Sistema operacional: ");
                        p.getCaracteristica().setSistemaOpe(input.nextLine());
                        
                        System.out.println("Cor: ");
                        p.getCaracteristica().setCor(input.nextLine());
                        System.out.println("detalhes:");
                        p.getCaracteristica().setDetalhes(input.nextLine());
                        
                        dao.inserir(p);
                        break;
                        
                    case "2":
                        System.out.println("-------------- EDITAR ----------------------------");
                        System.out.println("Qual codigo do produto para edição:");
                        codigo = Integer.parseInt(input.nextLine());
                        
                        p = dao.buscarPorCodigo(codigo);
                        if(p != null)
                        {
                            System.out.println("Produto encontrado: "+ p);
                            System.out.println("novo nome: ");
                            p.setNome_produto(input.nextLine());
                            System.out.println("novo preço: ");
                            p.setPreco_produto(Float.parseFloat(input.nextLine()));
                            System.out.println("nova Marca:");
                            p.getCaracteristica().setMarca(input.nextLine());
                        
                            System.out.println("novo Sistema operacional: ");
                            p.getCaracteristica().setSistemaOpe(input.nextLine());
                        
                            System.out.println("nova Cor: ");
                            p.getCaracteristica().setCor(input.nextLine());
                            System.out.println("novo detalhes:");
                            p.getCaracteristica().setDetalhes(input.nextLine());
                            
                            
                            dao.editar(p);
                            System.out.println("Registro alterado com Sucesso!");
                        }
                        else
                            System.out.println("Registro não alterado ou não existe!");
                        break;
                    
                    case "3":
                        System.out.println("-------------BUSCAR POR CODIGO-------------------");
                        System.out.println("Qual Código quer consultar:");
                        codigo = Integer.parseInt(input.nextLine());
                        p = dao.buscarPorCodigo(codigo);
                        if(p!=null)
                            System.out.println(p);
                        else
                            System.out.println("Código de Produto não encontrado ou não existe!!!");
                        break;
                
                    case "4":
                        System.out.println("-------------LISTAR PRODUTOS-------------------");
                        list = dao.listar();
                        System.out.println(list);
                        if(list!=null)
                        {
                            for (Produto pr : list)
                                System.out.println(pr);
                        }
                        else
                            System.out.println("Sem produtos para listar.....");
                        break;
                        
                    case "5":
                        System.out.println("-------------------EXCLUIR----------------------");
                        System.out.println("digite o codigo do produto que deseja excluir:");
                        codigo = Integer.parseInt(input.nextLine());
                        p = dao.buscarPorCodigo(codigo);
                        if(p != null){
                            dao.excluir(p);
                            System.out.println("produto "+p.getNome_produto()+" , excluido");
                        }
                        else
                            System.out.println("Produto nao existe ou nao excluido!!");
                        break;
                        
                    case "6":
                        System.out.println("saindo....");
                        break;
                    default:
                        System.out.println("    entrada inválida!");
                        
                }
                
            } while(!op.equals("6"));
        
    }
    
}
