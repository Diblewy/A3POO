package DAO;


import static DAO.ProdutoDAO.dao;
import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriaDAO {

    public static ArrayList<Categoria> dao() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        Connection conn = null;
        try {
            conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNome_categoria(rs.getString("nome_categoria"));
                categoria.setTamanho(rs.getString("tamanho"));
                categoria.setEmbalagem(rs.getString("embalagem"));
                categorias.add(categoria);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
            e.printStackTrace();
        } finally {
            ConexaoDB.fecharConexao(conn);
        }

        return categorias;
    }
    
    public int buscarIdPorNome(String nome_categoria, String tamanho, String embalagem) {
        int id_categoria = -1;

        String sql = "SELECT id_categoria FROM categoria WHERE nome_categoria = ? AND tamanho = ? AND embalagem = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome_categoria);
            stmt.setString(2, tamanho);
            stmt.setString(3, embalagem);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id_categoria = rs.getInt("id_categoria");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar categoria: " + e.getMessage());
        }

        return id_categoria;
    }

    public int inserirOuBuscarCategoria(String nome_categoria, String tamanho, String embalagem) {
        int id_categoria = buscarIdPorNome(nome_categoria, tamanho, embalagem);

        if (id_categoria == -1) {
            String sql = "INSERT INTO categoria (nome_categoria, tamanho, embalagem) VALUES (?, ?, ?)";

            try (Connection conn = ConexaoDB.getConexao();
                 PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

                stmt.setString(1, nome_categoria);
                stmt.setString(2, tamanho);
                stmt.setString(3, embalagem);
                stmt.executeUpdate();

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    id_categoria = rs.getInt(1);
                }

            } catch (SQLException e) {
                System.err.println("Erro ao inserir categoria: " + e.getMessage());
            }
        }

        return id_categoria;
    }
}