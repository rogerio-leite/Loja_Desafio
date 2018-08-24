package loja;

import loja.Models.Usuario;
import loja.Util.Database.Conexao;
import loja.Views.Login.LoginView;
import loja.Views.Principal.TelaInicialView;

public class Principal {
    
    public static  Usuario usuarioSessao = new Usuario();

    public static void main(String[] args) {
       new LoginView().setVisible(true);

//new TelaInicialView().setVisible(true);
    }
    
}
