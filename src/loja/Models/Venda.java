/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rogerio
 */
public class Venda {
    
    private int numeroVenda;
    private double totalVenda;
    private boolean confirmacaoVenda;
    private List<Produto> listaProdutosVenda = new ArrayList<>();

    /**
     * @return the numeroVenda
     */
    public int getNumeroVenda() {
        return numeroVenda;
    }

    /**
     * @param numeroVenda the numeroVenda to set
     */
    public void setNumeroVenda(int numeroVenda) {
        this.numeroVenda = numeroVenda;
    }

    /**
     * @return the totalVenda
     */
    public double getTotalVenda() {
        return totalVenda;
    }

    /**
     * @param totalVenda the totalVenda to set
     */
    public void setTotalVenda(double totalVenda) {
        this.totalVenda = totalVenda;
    }

    /**
     * @return the confirmacaoVenda
     */
    public boolean isConfirmacaoVenda() {
        return confirmacaoVenda;
    }

    /**
     * @param confirmacaoVenda the confirmacaoVenda to set
     */
    public void setConfirmacaoVenda(boolean confirmacaoVenda) {
        this.confirmacaoVenda = confirmacaoVenda;
    }

    /**
     * @return the listaProdutosVenda
     */
    public List<Produto> getListaProdutosVenda() {
        return listaProdutosVenda;
    }

    /**
     * @param listaProdutosVenda the listaProdutosVenda to set
     */
    public void setListaProdutosVenda(List<Produto> listaProdutosVenda) {
        this.listaProdutosVenda = listaProdutosVenda;
    }
    
}
