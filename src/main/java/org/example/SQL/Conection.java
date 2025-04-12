package org.example.SQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

    public static Connection connect() throws Exception{
        String url = "jdbc:postgresql://localhost:5432/seguranca-banco-de-dados-BD2";
        String usuario = "postgres";
        String senha = "1234";

        return DriverManager.getConnection(url, usuario, senha);
    }
}
