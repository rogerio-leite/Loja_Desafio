/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.Controller;

import loja.DAO.AcessoDAO;
import loja.Models.Usuario;

/**
 *
 * @author Rogerio
 */
public class AcessoController {
    
    AcessoDAO acessoDAO = new AcessoDAO();
    
    public Usuario login(Usuario usuario){
        return acessoDAO.login(usuario);     
    }
    
    
}
