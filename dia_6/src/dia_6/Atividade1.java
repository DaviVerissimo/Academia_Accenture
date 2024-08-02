package dia_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/biblioteca";
        String username = "userAppHelpMind";
        String password = "jh4545&&%&KKK)*&$#@!";
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Consultas consulta = new Consultas();
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Menu:");
                System.out.println("1. Listar livros");
                System.out.println("2. Criar livro");
                System.out.println("3. Deletar livro");
                System.out.println("4. Atualizar livro");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consumir nova linha

                switch (option) {
                    case 1:
                        consulta.listar(connection);
                        break;
                    case 2:
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Ano de Publicação: ");
                        int anoPublicacao = scanner.nextInt();
                        consulta.criar(connection, titulo, autor, anoPublicacao);
                        break;
                    case 3:
                        System.out.print("ID do livro a ser deletado: ");
                        int idDeletar = scanner.nextInt();
                        consulta.deletar(connection, idDeletar);
                        break;
                    case 4:
                        System.out.print("ID do livro a ser atualizado: ");
                        int idAtualizar = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha
                        System.out.print("Novo Título: ");
                        String novoTitulo = scanner.nextLine();
                        System.out.print("Novo Autor: ");
                        String novoAutor = scanner.nextLine();
                        System.out.print("Novo Ano de Publicação: ");
                        int novoAnoPublicacao = scanner.nextInt();
                        consulta.atualizar(connection, idAtualizar, novoTitulo, novoAutor, novoAnoPublicacao);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }
            
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
