package Model;

import DAO.CategoriaDAO;
import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produto extends Categoria {
    
    private int id_produto;
    private String nome_produto;
    private double precoUnitario;
    private String unidade;
    private int quantidadeEstoque;
    private int quantidadeMinima;
    private int quantidadeMaxima;

    private String nome_categoria;
    public String getNome_categoria(){
        return nome_categoria;
    }
    public void setNome_categoria(String nome_categoria){
        this.nome_categoria = nome_categoria;
    }
    public Produto() {
    }

    public Produto(int id_produto, String nome_produto, double precoUnitario, String unidade, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Produto(int id_produto, String nome_produto, double precoUnitario, String unidade, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima, String nome_categoria, String tamanho, String embalagem) {
        super(nome_categoria, tamanho, embalagem);
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public Produto(int id_produto, String nome_produto, double precoUnitario, String unidade, int quantidadeEstoque, int quantidadeMinima, int quantidadeMaxima, int id_categoria, String nome_categoria, String tamanho, String embalagem) {
        super(id_categoria, nome_categoria, tamanho, embalagem);
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.precoUnitario = precoUnitario;
        this.unidade = unidade;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }
    
    
    @Override
    public String toString() {
        return "\n Id do produto: " + this.getId_produto()
                + "\n Nome do produto: " + this.getNome_produto()
                + "\n Preco do produto: " + this.getPrecoUnitario()
                + "\n Unidade: " + this.getUnidade()
                + " \n Quantidade do estoque: " + this.getQuantidadeEstoque()
                + " \n Quantidade Minima: " + this.getQuantidadeMinima()
                + " \n Quantidade Maxima: " + this.getQuantidadeMaxima()
                + " \n Id da categoria: " + this.getId_categoria()
                + " \n Nome da categoria " + this.getNome_categoria()
                + " \n Tamanho: " + this.getTamanho()
                + " \n Embalagem: " + this.getEmbalagem()
                + " \n ------------------";
                
    }
    
    
    private ProdutoDAO dao(){
    return new ProdutoDAO();
    }
    public boolean Insertsistema_estoque(String nome_produto, double precoUnitario, String unidade, int quantidadeEstoque,
            int quantidadeMinima, int quantidadeMaxima, String nome_categoria, String tamanho, String embalagem) {
        int id_produto = ProdutoDAO.maiorID() + 1;
        int id_categoria = 0;
        Produto objeto = new Produto(id_produto, nome_produto, precoUnitario, unidade, quantidadeEstoque,
        quantidadeMinima, quantidadeMaxima, id_categoria, nome_categoria, tamanho, embalagem);
        try {
            dao().inserir(objeto);
        } catch (SQLException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean DeleteProdutoBD(int id_produto) {
            try {
                //chamar metodo excluir do DAO que faz a exclusão no BD
                dao().excluir(id_produto);
                return true;
                
            }catch (SQLException ex) {
                Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            
            }
    }


    public boolean UpdateProdutoBD(int id_produto, String nome_produto, double precoUnitario, String unidade, int quantidadeEstoque,
            int quantidadeMinima, int quantidadeMaxima, int id_categoria, String nome_categoria, String tamanho, String embalagem) {
        
            try {

                Produto produto = new Produto(id_produto, nome_produto, precoUnitario, unidade, quantidadeEstoque, 
                        quantidadeMinima, quantidadeMaxima, id_categoria, nome_categoria, tamanho, embalagem);
            

                dao().atualizar(produto);
            
                return true;
            }catch (SQLException ex) {
                Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            
            }
    }

    private int procuraIndice(int id_produto) {
        int indice = -1;
        for(int i = 0; i< ProdutoDAO.dao().size(); i++) {
            if(ProdutoDAO.dao().get(i).getId_produto() == id_produto) {
                indice = i;
            }
        }
        return indice;
    }
    public List<Produto> listarTodosProdutos() throws SQLException {
        return dao().listarTodosProdutos();
    }
}   

