package org.example;

import org.example.DAO.UsuarioDAO;
import org.example.Domain.Usuario;
import org.example.Methods.LoginInseguro;
import org.example.Methods.LoginSeguro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("ESCOLHA UMA OPCAO:");
        int opcao = 0;

        while (opcao != 3){
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Cadastrar novo usuario");
            System.out.println("3 - Alterar senha");

            switch (opcao){
                case 1:
                    String login = scanner.nextLine();
                    String senha = scanner.nextLine();

                    Usuario usuario = new Usuario(login, senha);
                  //  boolean result = LoginInseguro.autenticar(usuario);      //Login Inseguro;
                    boolean result = LoginSeguro.autenticar(usuario);          //Login Seguro utilizando PreparedStatement.
                    if(result){
                        System.out.println("Login bem-sucedido");
                    }else {
                        System.out.println("Usuario ou senha invalidos");
                    }

                case 2:
                    String cadastrar = scanner.nextLine();
                    String login1 = scanner.nextLine();
                    String senha2 = scanner.nextLine();

                    Usuario usuarioNovo = new Usuario(login1, senha2);
                    boolean resultNovoUser = UsuarioDAO.cadastrar(usuarioNovo);
                    if(resultNovoUser){
                        System.out.println("Login bem-sucedido");
                    }else {
                        System.out.println("Usuario ou senha invalidos");
                    }

                case 3:

                    String updateSenha = scanner.nextLine();
                    String login3 = scanner.nextLine();
                    String senha3 = scanner.nextLine();

                    Usuario usuarioUpdate = new Usuario(login3, senha3);
                    boolean resultUpdate = UsuarioDAO.atualizar(usuarioUpdate);
                    if(resultUpdate){
                        System.out.println("Login bem-sucedido");
                    }else {
                        System.out.println("Usuario ou senha invalidos");
                    }

            }


        }




    }
}