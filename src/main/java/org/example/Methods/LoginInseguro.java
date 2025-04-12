package org.example.Methods;

import org.example.Domain.Usuario;
import org.example.SQL.Conection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginInseguro {

    public static  boolean autenticar(Usuario u) throws Exception{

        Connection conn = Conection.connect();
        String sql = "SELECT * FROM usuarios WHERE login = '" + u.getLogin() + "'AND senha = '" + u.getSenha() + "'";
        System.out.println("SQL gerada = " + sql);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        return rs.next();
    }
}
