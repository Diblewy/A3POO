package DAO;

import Model.Produto;
import Model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static ArrayList<Produto> dao() {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        Connection conn = null;
        try {
            conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("id_produto"));
                produto.setNome_produto(rs.getString("nome_produto"));
                produto.setPrecoUnitario(rs.getDouble("preco_unitario"));
                produto.setUnidade(rs.getString("unidade"));
                produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                produto.setQuantidadeMinima(rs.getInt("quantidade_minima"));
                produto.setQuantidadeMaxima(rs.getInt("quantidade_maxima"));
                produto.setId_categoria(rs.getInt("id_categoria"));

                produtos.add(produto);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoDB.fecharConexao(conn);
        }

        return produtos;
    }

    private CategoriaDAO categoriaDAO = new CategoriaDAO();

    private boolean categoriaExiste(int idCategoria) throws SQLException {
        String sql = "SELECT COUNT(*) FROM categoria WHERE id_categoria = ?";
        Connection conn = null;
        boolean existe = false;

        try {
            conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                System.out.println("RESULTADO DE RS GET INT: " + (rs.getInt(1)>0));
                
                existe = rs.getInt(1) > 0;
            }
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
        System.out.println("VALOR DE RETORNO AAAAAAA: " + existe);
        return existe;
    }

    public void inserir(Produto produto) throws SQLException {

        if (!categoriaExiste(produto.getId_categoria())) {
            throw new SQLException("Categoria com ID " + produto.getId_categoria() + " não existe!");
        }

        String sql = "INSERT INTO produto (nome_produto, preco_unitario, unidade, quantidade_estoque, "
                + "quantidade_minima, quantidade_maxima, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;

        try {
            conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome_produto());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getUnidade());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setInt(5, produto.getQuantidadeMinima());
            stmt.setInt(6, produto.getQuantidadeMaxima());
            stmt.setInt(7, produto.getId_categoria());
            stmt.executeUpdate();
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
    }
    
    public void atualizar(Produto produto) throws SQLException {
    
        if(!categoriaExiste(produto.getId_categoria())) {
            throw new SQLException("Categoria com ID " + produto.getId_categoria() + " não existe!");
        }
    
        String sql = "UPDATE produto SET nome_produto = ?, preco_unitario = ?, unidade = ?, "
                +  "quantidade_estoque = ?, quantidade_minima = ?, quantidade_maxima = ?, "
                +  "id_categoria = ? WHERE id_produto = ?";
        Connection conn = null;
        
        try {
            conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome_produto());
            stmt.setDouble(2, produto.getPrecoUnitario());
            stmt.setString(3, produto.getUnidade());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setInt(5, produto.getQuantidadeMinima());
            stmt.setInt(6, produto.getQuantidadeMaxima());
            stmt.setInt(7, produto.getId_categoria());
            stmt.setInt(8, produto.getId_produto());
            
            int rowsAffected = stmt.executeUpdate();
            

            if(rowsAffected == 0) {
                throw new SQLException("Produto com ID " + produto.getId_produto() + "não encontrado!");
            }
            
        }finally{
            ConexaoDB.fecharConexao(conn);
    }
}
    
    public void venderProduto(int produtoId, int quantidadeVendida) throws SQLException {
        String sqlConsulta = "SELECT quantidade_estoque FROM produto WHERE id_produto = ?";
        String sqlUpdate = "UPDATE produto SET quantidade_estoque = quantidade_estoque - ? WHERE id_produto = ?";
        Connection conn = null;
    
    try {
        conn = ConexaoDB.getConexao();
        
        PreparedStatement stmtConsulta = conn.prepareStatement(sqlConsulta);
        stmtConsulta.setInt(1, produtoId);
        ResultSet rs = stmtConsulta.executeQuery();
        
        if (!rs.next()) {
            throw new SQLException("Produto com ID " + produtoId + " não encontrado!");
        }
        
        int estoqueAtual = rs.getInt("quantidade_estoque");
        
        if (estoqueAtual < quantidadeVendida) {
            throw new SQLException("Estoque insuficiente! Estoque atual: " + estoqueAtual + 
                                 ", Quantidade solicitada: " + quantidadeVendida);
        }
        
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setInt(1, quantidadeVendida);
        stmtUpdate.setInt(2, produtoId);
        
        int rowsAffected = stmtUpdate.executeUpdate();
        
        if (rowsAffected == 0) {
            throw new SQLException("Erro ao atualizar estoque do produto ID " + produtoId);
        }
        
        System.out.println("Venda realizada! Quantidade vendida: " + quantidadeVendida + 
                          " | Estoque restante: " + (estoqueAtual - quantidadeVendida));
        
    } finally {
        ConexaoDB.fecharConexao(conn);
    }
}

    public void comprarProduto(int produtoId, int quantidadeComprada) throws SQLException {
        String sqlConsulta = "SELECT quantidade_estoque FROM produto WHERE id_produto = ?";
        String sqlUpdate = "UPDATE produto SET quantidade_estoque = quantidade_estoque + ? WHERE id_produto = ?";
        Connection conn = null;
    
    try {
        conn = ConexaoDB.getConexao();
        
        PreparedStatement stmtConsulta = conn.prepareStatement(sqlConsulta);
        stmtConsulta.setInt(1, produtoId);
        ResultSet rs = stmtConsulta.executeQuery();
        
        if (!rs.next()) {
            throw new SQLException("Produto com ID " + produtoId + " não encontrado!");
        }
        
        int estoqueAtual = rs.getInt("quantidade_estoque");
        
        PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
        stmtUpdate.setInt(1, quantidadeComprada);
        stmtUpdate.setInt(2, produtoId);
        
        int rowsAffected = stmtUpdate.executeUpdate();
        
        if (rowsAffected == 0) {
            throw new SQLException("Erro ao atualizar estoque do produto ID " + produtoId);
        }
        
        System.out.println("Compra realizada! Quantidade adicionada: " + quantidadeComprada + 
                          " | Novo estoque: " + (estoqueAtual + quantidadeComprada));
        
    } finally {
        ConexaoDB.fecharConexao(conn);
    }
}


    public int consultarEstoque(int produtoId) throws SQLException {
        String sql = "SELECT quantidade_estoque FROM produto WHERE id_produto = ?";
        Connection conn = null;
    
    try {
        conn = ConexaoDB.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, produtoId);
        
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return rs.getInt("quantidade_estoque");
        } else {
            throw new SQLException("Produto com ID " + produtoId + " não encontrado!");
        }
        
    } finally {
        ConexaoDB.fecharConexao(conn);
    }
}
    
    
    

    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT p.*, c.nome_categoria, c.tamanho, c.embalagem "
                + "FROM produto p JOIN categoria c ON p.id_categoria = c.id_categoria WHERE p.id_produto = ?";
        Connection conn = null;
        Produto produto = null;

        try {
            conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                produto = criarProdutoFromResultSet(rs);
            }
        } finally {
            ConexaoDB.fecharConexao(conn);
        }

        return produto;
    }

    public List<Produto> listarTodosProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT " +
             "p.id_produto, p.nome_produto, p.preco_unitario, p.unidade, " +
             "p.quantidade_estoque, p.quantidade_minima, p.quantidade_maxima, " +
             "c.id_categoria, c.nome_categoria, c.tamanho, c.embalagem " +
             "FROM produto p " +
             "JOIN categoria c ON p.id_categoria = c.id_categoria";
        Connection conn = null;

        try {
            conn = ConexaoDB.getConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Produto produto = criarProdutoFromResultSet(rs);
                produtos.add(produto);
            }
        } finally {
            ConexaoDB.fecharConexao(conn);
        }

        return produtos;
    }


    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        Connection conn = null;

        try {
            conn = ConexaoDB.getConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            int rowsAffected = stmt.executeUpdate();
            
            if(rowsAffected == 0){
                throw new SQLException("Produto com ID " + id + "não encontrado!");
            }
            
        } finally {
            ConexaoDB.fecharConexao(conn);
        }
    }

    private Produto criarProdutoFromResultSet(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setId_produto(rs.getInt("id_produto"));
        produto.setNome_produto(rs.getString("nome_produto"));
        produto.setPrecoUnitario(rs.getDouble("preco_unitario"));
        produto.setUnidade(rs.getString("unidade"));
        produto.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
        produto.setQuantidadeMinima(rs.getInt("quantidade_minima"));
        produto.setQuantidadeMaxima(rs.getInt("quantidade_maxima"));
        produto.setId_categoria(rs.getInt("id_categoria"));


        try {
            produto.setNome_categoria(rs.getString("nome_categoria"));
            produto.setTamanho(rs.getString("tamanho"));
            produto.setEmbalagem(rs.getString("embalagem"));
        } catch (SQLException e) {

        }

        return produto;
    }

    public static int maiorID() {
        int maiorID = 0;
        ArrayList<Produto> produtos = dao();
        for (Produto produto : produtos) {
            if (produto.getId_produto() > maiorID) {
                maiorID = produto.getId_produto();
            }
        }
        return maiorID;
    }
}