package org.example;

import org.example.Domain.Usuario;
import org.example.Methods.LoginInseguro;
import org.example.Methods.LoginSeguro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Login: ");
        String login = scanner.nextLine();

        System.out.println("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(login, senha);

      //  boolean result = LoginInseguro.autenticar(usuario);      //Login Inseguro;
        boolean result = LoginSeguro.autenticar(usuario);          //Login Seguro utilizando PreparedStatement.

        if(result){
            System.out.println("Login bem-sucedido");
        }else {
            System.out.println("Usuario ou senha invalidos");
        }

    }
}