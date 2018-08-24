/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Controller;

import loja.Models.Produto;
import loja.DAO.ProdutoDAO;

public class ProdutoController {

    ProdutoDAO produtoDAO = new ProdutoDAO();
    int retornoValidacao;
    int retornoCadastro;
    public int cadastrarProduto(Produto produto){
      
        retornoCadastro = produtoDAO.cadastrarProduto(produto);
        
        return retornoCadastro;
    }
    
    public Produto buscarProdutoAdicionar(Produto produto){
        return produtoDAO.buscarProdutoAdicionar(produto);
    }
    
}
