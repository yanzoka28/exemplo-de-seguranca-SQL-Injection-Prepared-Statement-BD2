package org.example.Methods;

import org.example.Domain.Usuario;
import org.example.SQL.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginSeguro {

    public static boolean autenticar(Usuario u) throws Exception {

        Connection conn = Conection.connect();
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getSenha());

        ResultSet rs = stmt.executeQuery();
        return  rs.next();
    }
}
