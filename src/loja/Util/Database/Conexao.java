package loja.Util.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    Connection conexao; 
   public Connection getConnection(){
       
    try{
        String stringConexao = "jdbc:postgresql://localhost:5432/";
        String nomeBanco = "loja_database";
        String usuarioBanco = "postgres";
        String senhaBanco = "1234";
        
            Class.forName("org.postgresql.Driver");
    
        conexao = DriverManager.getConnection(stringConexao+nomeBanco,
                usuarioBanco, senhaBanco);
        
        
    } catch(SQLException e){
        e.printStackTrace();
        conexao = null;
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        conexao = null;
    }
    
    return conexao;
    }
    
    public void fecharConexaoBanco(){
        try {  
            conexao.close();
    
        } catch (SQLException e) {  
             e.printStackTrace();  
        }  
    }
    
}
