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
import loja.Models.Usuario;
import loja.Util.Database.Conexao;

/**
 *
 * @author Rogerio
 */
public class AcessoDAO {
    
    Conexao conexao = new Conexao();
    
    public Usuario login(Usuario usuario){
        Connection conn = conexao.getConnection();
            
            String sql = "SELECT * FROM acesso INNER JOIN permissoes ON "
                    + "acesso.permissao = permissoes.id WHERE acesso.login = ? "
                    + " AND acesso.senha = ?";
            
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, usuario.getLogin());
                stmt.setString(2, usuario.getSenha());
                
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    usuario.setNome(rs.getString("nome"));
                    usuario.getPermissao().setId(rs.getInt("id"));
                    usuario.getPermissao().setDescricao(rs.getString("descricao"));
                }
                
                
                stmt.close();
                conn.close();
                
                return usuario;
               
                
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }    
    }
    
}
