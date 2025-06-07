package View;

import DAO.CategoriaDAO;
import Model.Produto;
import DAO.ProdutoDAO;
import DAO.CategoriaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmCadastrarProduto extends javax.swing.JFrame {

    private Produto objproduto;
    private ProdutoDAO produtoDAO;
            
    public FrmCadastrarProduto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.objproduto = new Produto();
        this.produtoDAO = new ProdutoDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nome_produto = new javax.swing.JTextField();
        tamanho = new javax.swing.JTextField();
        precoUnitario = new javax.swing.JTextField();
        embalagem = new javax.swing.JTextField();
        unidade = new javax.swing.JTextField();
        quantidadeEstoque = new javax.swing.JTextField();
        quantidadeMinima = new javax.swing.JTextField();
        quantidadeMaxima = new javax.swing.JTextField();
        nome_categoria = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de produto");

        jLabel6.setText("Quantidade Maxima");

        jLabel8.setText("Tamanho");

        jLabel7.setText("Categoria");

        jLabel9.setText("Embalagem");

        nome_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_produtoActionPerformed(evt);
            }
        });

        embalagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embalagemActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Preço");

        jLabel3.setText("Unidade");

        jLabel4.setText("Quantidade Estoque");

        jLabel5.setText("Quantidade Minima");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(embalagem))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tamanho))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_produto))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoUnitario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unidade))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_categoria))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidadeMaxima))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidadeEstoque))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidadeMinima)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(precoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(quantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(quantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(quantidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nome_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(embalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nome_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_produtoActionPerformed

    }//GEN-LAST:event_nome_produtoActionPerformed

    private void embalagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_embalagemActionPerformed

    }//GEN-LAST:event_embalagemActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        
        try {
    if (this.nome_produto.getText().trim().length() <= 3) {
        throw new Mensagens("Nome do produto deve conter ao menos 3 caracteres.");
    }

    if (this.precoUnitario.getText().trim().isEmpty()) {
        throw new Mensagens("Preço deve ser informado.");
    }
    
    if (this.unidade.getText().trim().isEmpty()) {
        throw new Mensagens("Informe uma unidade válida.");
    }
    
    if (this.quantidadeEstoque.getText().trim().isEmpty()) {
        throw new Mensagens("Informe uma quantidade de estoque válida.");
    }
    
    if (this.quantidadeMinima.getText().trim().isEmpty()) {
        throw new Mensagens("Informe uma quantidade mínima válida.");
    }
    
    if (this.quantidadeMaxima.getText().trim().isEmpty()) {
        throw new Mensagens("Informe uma quantidade máxima válida.");
    }

    String nome_produto = this.nome_produto.getText().trim();
    double precoUnitario = Double.parseDouble(this.precoUnitario.getText().trim());
    String unidade = this.unidade.getText().trim();
    int quantidadeEstoque = Integer.parseInt(this.quantidadeEstoque.getText().trim());
    int quantidadeMinima = Integer.parseInt(this.quantidadeMinima.getText().trim());
    int quantidadeMaxima = Integer.parseInt(this.quantidadeMaxima.getText().trim());

    String nome_categoria = this.nome_categoria.getText().trim();
    String tamanho = this.tamanho.getText().trim();
    String embalagem = this.embalagem.getText().trim();

    if (nome_categoria.length() <= 3) {
        throw new Mensagens("Nome da categoria deve conter ao menos 3 caracteres.");
    }
    if (tamanho.length() <= 0) {
        throw new Mensagens("Informe um tamanho válido.");
    }
    if (embalagem.length() <= 0) {
        throw new Mensagens("Informe uma embalagem válida.");
    }

    CategoriaDAO categoriaDAO = new CategoriaDAO();
    int id_categoria = categoriaDAO.inserirOuBuscarCategoria(nome_categoria, tamanho, embalagem);

    if (id_categoria == -1) {
        throw new Mensagens("Erro ao criar/buscar categoria!");
    }

    if (precoUnitario <= 0) {
        throw new Mensagens("Preço deve ser maior que zero.");
    }
    
    if (quantidadeEstoque < 0) {
        throw new Mensagens("Quantidade em estoque não pode ser negativa.");
    }
    
    if (quantidadeMinima < 0) {
        throw new Mensagens("Quantidade mínima não pode ser negativa.");
    }
    
    if (quantidadeMaxima <= 0) {
        throw new Mensagens("Quantidade máxima deve ser maior que zero.");
    }
    
    if (quantidadeMaxima < quantidadeMinima) {
        throw new Mensagens("Quantidade máxima deve ser maior ou igual à quantidade mínima.");
    }

    this.objproduto.setNome_produto(nome_produto);
    this.objproduto.setPrecoUnitario(precoUnitario);
    this.objproduto.setUnidade(unidade);
    this.objproduto.setQuantidadeEstoque(quantidadeEstoque);
    this.objproduto.setQuantidadeMinima(quantidadeMinima);
    this.objproduto.setQuantidadeMaxima(quantidadeMaxima);
    this.objproduto.setId_categoria(id_categoria);

    this.produtoDAO.inserir(this.objproduto);
    
    JOptionPane.showMessageDialog(rootPane, "Produto cadastrado com sucesso!");
    
    limparCampos();
    
    System.out.println("Produtos cadastrados:");
    try {
        this.produtoDAO.listarTodosProdutos().forEach(p -> {
            System.out.println("ID: " + p.getId_produto() + 
                             " - Nome: " + p.getNome_produto() + 
                             " - Preço: " + p.getPrecoUnitario());
        });
    } catch (SQLException ex) {
        Logger.getLogger(FrmCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
    }
    
} catch (Mensagens erro) {
    JOptionPane.showMessageDialog(null, erro.getMessage());
} catch (NumberFormatException erro2) {
    JOptionPane.showMessageDialog(null, "Erro: Verifique se os campos numéricos estão preenchidos corretamente.");
} catch (SQLException erro3) {
    JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + erro3.getMessage());
    erro3.printStackTrace();
}
    }//GEN-LAST:event_JBCadastrarActionPerformed

    private void limparCampos() {
        this.nome_produto.setText("");
        this.precoUnitario.setText("");
        this.unidade.setText("");
        this.quantidadeEstoque.setText("");
        this.quantidadeMinima.setText("");
        this.quantidadeMaxima.setText("");
        this.nome_categoria.setText("");
        this.tamanho.setText("");
        this.embalagem.setText("");
    }
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCadastrarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField embalagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nome_categoria;
    private javax.swing.JTextField nome_produto;
    private javax.swing.JTextField precoUnitario;
    private javax.swing.JTextField quantidadeEstoque;
    private javax.swing.JTextField quantidadeMaxima;
    private javax.swing.JTextField quantidadeMinima;
    private javax.swing.JTextField tamanho;
    private javax.swing.JTextField unidade;
    // End of variables declaration//GEN-END:variables
}