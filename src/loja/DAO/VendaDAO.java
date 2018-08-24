/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import loja.Models.Produto;
import loja.Models.Venda;
import loja.Util.Database.Conexao;

/**
 *
 * @author Rogerio
 */
public class VendaDAO {
    
    Conexao conexao = new Conexao();
    
    public int retornarNumeroVenda(){
        Connection conn = conexao.getConnection();
        int retornoNumeroVenda = 0;
        String sql = "SELECT numero_venda FROM documento ORDER BY numero_venda DESC LIMIT 1";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                retornoNumeroVenda = rs.getInt("numero_venda");
                retornoNumeroVenda = retornoNumeroVenda + 1;
            }
            
            return retornoNumeroVenda;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
        
        public boolean cancelarVenda(Venda venda){
            Connection conn = conexao.getConnection();
            String sql = "INSERT INTO documento (numero_venda, total_venda, confirmacao_venda) VALUES (?,?,?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, venda.getNumeroVenda());
                stmt.setDouble(2, 0);
                stmt.setBoolean(3, false);
                
                stmt.execute();
                stmt.close();
                conn.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    public boolean confirmarVenda(Venda venda) {
        Connection conn = conexao.getConnection();
            String sql = "INSERT INTO documento (numero_venda, total_venda, confirmacao_venda) VALUES (?,?,?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, venda.getNumeroVenda());
                stmt.setDouble(2, venda.getTotalVenda());
                stmt.setBoolean(3, true);
                
                stmt.execute();
                stmt.close();
                conn.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }
    
    public boolean cadastrarItensVenda(Venda venda) {
        Connection conn = conexao.getConnection();
            String sql = "INSERT INTO venda_itens (id_documento, id_item) VALUES (?,?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                for(Produto prod: venda.getListaProdutosVenda()){
                    stmt.setInt(1, venda.getNumeroVenda());
                    stmt.setInt(2, prod.getCodigoProduto());
                    stmt.execute();
                }
                stmt.close();
                conn.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }
    
    
    
    public int totalVendasConfirmadas(){
        Connection conn = conexao.getConnection();
        int retornoVendaConfirmada = 0;
        String sql = "SELECT COUNT(*) as contagem FROM documento WHERE confirmacao_venda = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                retornoVendaConfirmada = rs.getInt("contagem");
            }
            
            return retornoVendaConfirmada;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int totalVendasCanceladas(){
        Connection conn = conexao.getConnection();
        int retornoVendaCanceladas = 0;
        String sql = "SELECT COUNT(*) as contagem FROM documento WHERE confirmacao_venda = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, false);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                retornoVendaCanceladas = rs.getInt("contagem");
            }
            
            return retornoVendaCanceladas;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public double totalArrecadado(){
        Connection conn = conexao.getConnection();
        double retornoArrecadacao = 0;
        String sql = "SELECT SUM(total_venda) as total FROM documento WHERE confirmacao_venda = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                retornoArrecadacao = rs.getInt("total");
            }
            
            return retornoArrecadacao;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    
         
}
