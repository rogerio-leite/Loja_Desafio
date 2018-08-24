/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Util;

import loja.Models.Usuario;

public class Sessao {
    // Variável estática que conterá a instancia da classe
    private static Sessao instance;
    private Usuario usuarioSessao = new Usuario();
    // Construtor privado (suprime o construtor público padrão).
    private Sessao() {}

    // Método público estático de acesso único ao objeto!
    public static Sessao getInstance() {
        if (instance == null)
            instance = new Sessao();
        
        return instance;
    }

    /*
    Pode criar outros métodos que precise aqui, como getters e setters.
    */

    /**
     * @return the usuarioSessao
     */
    public Usuario getUsuarioSessao() {
        return usuarioSessao;
    }

    /**
     * @param usuarioSessao the usuarioSessao to set
     */
    public void setUsuarioSessao(Usuario usuarioSessao) {
        this.usuarioSessao = usuarioSessao;
    }
    
}