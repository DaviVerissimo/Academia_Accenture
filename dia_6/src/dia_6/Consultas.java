package dia_6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {

    public void listar(Connection connection) {
        String sql = "SELECT * FROM livros";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Título: " + resultSet.getString("titulo"));
                System.out.println("Autor: " + resultSet.getString("autor"));
                System.out.println("Ano de Publicação: " + resultSet.getInt("ano_publicacao"));
                System.out.println("______________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criar(Connection connection, String titulo, String autor, int anoPublicacao) {
        String sql = "INSERT INTO livros (titulo, autor, ano_publicacao) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.setInt(3, anoPublicacao);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(Connection connection, int id) {
        String sql = "DELETE FROM livros WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Connection connection, int id, String titulo, String autor, int anoPublicacao) {
        String sql = "UPDATE livros SET titulo = ?, autor = ?, ano_publicacao = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, titulo);
            pstmt.setString(2, autor);
            pstmt.setInt(3, anoPublicacao);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
