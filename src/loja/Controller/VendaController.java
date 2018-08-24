/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Controller;

import loja.DAO.VendaDAO;
import loja.Models.Produto;
import loja.Models.Venda;

/**
 *
 * @author Rogerio
 */
public class VendaController {
    
    VendaDAO vendaDAO = new VendaDAO();
    
    public int retornarNumeroVenda(){
        return vendaDAO.retornarNumeroVenda();
    }
    
    public boolean cancelarVenda(Venda venda){
        return vendaDAO.cancelarVenda(venda);
    }
    
    public boolean confirmarVenda(Venda venda){
        vendaDAO.confirmarVenda(venda);
        return vendaDAO.cadastrarItensVenda(venda);
    }
    
    public int totalVendasConfirmadas(){
        return vendaDAO.totalVendasConfirmadas();
    } 
    
    public int totalVendasCanceladas(){
        return vendaDAO.totalVendasCanceladas();
    } 
    
    public double totalArrecadado(){
        return vendaDAO.totalArrecadado();
    }
    
    
    
}
