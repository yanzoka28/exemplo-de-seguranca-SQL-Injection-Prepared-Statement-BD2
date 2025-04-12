package org.example.DAO;

import org.example.Domain.Usuario;
import org.example.SQL.Conection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public static boolean cadastrar(Usuario u) throws Exception {

        Connection conn = Conection.connect();
        String sql = "INSERT INTO usuarios (login, senha) VALUES (?, ?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, u.getLogin());
        stmt.setString(2, u.getSenha());

        ResultSet rs = stmt.executeQuery();
        return  rs.next();
    }

    public static  boolean atualizar(Usuario u) throws Exception{

        Connection connection = Conection.connect();
        String sql = "UPDATE usuarios u SET u.senha WHERE u.login = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getLogin());

        ResultSet rs = stmt.executeQuery();
        return  rs.next();
    }

    public static  boolean verificacao(Usuario u) throws Exception{

        Connection connection = Conection.connect();
        String sql = "SELECT login FROM usuarios WHERE login = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, u.getLogin());

        ResultSet rs = stmt.executeQuery();
        return rs.next();
    }


}
