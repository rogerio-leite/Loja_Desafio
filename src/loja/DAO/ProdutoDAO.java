/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import loja.Util.Database.Conexao;
import loja.Models.Produto;
/**
 *
 * @author Rogerio
 */
public class ProdutoDAO {
    
    Conexao conexao = new Conexao();
    
    int resultadoOperacao;
    
    public int cadastrarProduto(Produto produto){
            Connection conn = conexao.getConnection();
            
            String sql = "INSERT INTO produto (codigo_produto, descricao_produto, preco_produto)"
                    + "VALUES (?,?,?)";
            
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                stmt.setInt(1, produto.getCodigoProduto());
                stmt.setString(2, produto.getDescricaoProduto());
                stmt.setDouble(3, produto.getPrecoProduto());
                
                stmt.execute();
                stmt.close();
                conn.close();
                
                resultadoOperacao = 0;
               
                
            } catch (SQLException e) {
                e.printStackTrace();
                resultadoOperacao = 1;
            }
            
            return resultadoOperacao;
            
    }
    
    public Produto buscarProdutoAdicionar(Produto produto){
            Connection conn = conexao.getConnection();
            String sql = "SELECT * FROM produto WHERE codigo_produto = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, produto.getCodigoProduto());
                
                ResultSet rs = stmt.executeQuery();

                while (rs.next()){
                    produto.setCodigoProduto(rs.getInt("codigo_produto"));
                    produto.setDescricaoProduto(rs.getString("descricao_produto"));
                    produto.setPrecoProduto(rs.getDouble("preco_produto"));
                }
                
                stmt.close();
                conn.close();
                return produto;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}
