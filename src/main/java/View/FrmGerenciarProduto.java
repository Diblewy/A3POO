package View;

import static DAO.ProdutoDAO.dao;
import DAO.ProdutoDAO;
import DAO.CategoriaDAO;
import Model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;

public class FrmGerenciarProduto extends javax.swing.JFrame {

   


    private Produto objproduto;

    public FrmGerenciarProduto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.objproduto = new Produto();
        this.carregaTabela();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nome_produto = new javax.swing.JTextField();
        precoUnitario = new javax.swing.JTextField();
        unidade = new javax.swing.JTextField();
        quantidadeEstoque = new javax.swing.JTextField();
        quantidadeMinima = new javax.swing.JTextField();
        quantidadeMaxima = new javax.swing.JTextField();
        nome_categoria = new javax.swing.JTextField();
        tamanho = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        embalagem = new javax.swing.JTextField();
        JBCancelar = new javax.swing.JButton();
        JBEditar = new javax.swing.JButton();
        JBExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRelatorio1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de produto");

        jLabel11.setText("Nome");

        jLabel12.setText("Preço");

        jLabel13.setText("Unidade");

        jLabel14.setText("Quantidade Estoque");

        jLabel15.setText("Quantidade Minima");

        jLabel16.setText("Quantidade Maxima");

        jLabel18.setText("Categoria");

        jLabel19.setText("Tamanho");

        nome_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_produtoActionPerformed(evt);
            }
        });

        precoUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoUnitarioActionPerformed(evt);
            }
        });

        quantidadeEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeEstoqueActionPerformed(evt);
            }
        });

        tamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanhoActionPerformed(evt);
            }
        });

        jLabel1.setText("Embalagem");

        JBCancelar.setText("Cancelar");
        JBCancelar.setMaximumSize(new java.awt.Dimension(76, 27));
        JBCancelar.setMinimumSize(new java.awt.Dimension(76, 27));
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBEditar.setText("Editar");
        JBEditar.setPreferredSize(new java.awt.Dimension(80, 27));
        JBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEditarActionPerformed(evt);
            }
        });

        JBExcluir.setText("Excluir");
        JBExcluir.setPreferredSize(new java.awt.Dimension(80, 27));
        JBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExcluirActionPerformed(evt);
            }
        });

        JTableRelatorio1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id_produto", "Nome", "Preço", "Unidade", "Qtd. Estoque", "Qtd. Minima", "Qtd. Maxima", "id_categoria", "Categoria", "Tamanho", "Embalagem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRelatorio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRelatorio1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableRelatorio1);
        if (JTableRelatorio1.getColumnModel().getColumnCount() > 0) {
            JTableRelatorio1.getColumnModel().getColumn(0).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(1).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(2).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(3).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(4).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(5).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(6).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(7).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(8).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(9).setResizable(false);
            JTableRelatorio1.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(JBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(embalagem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tamanho))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_categoria))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidadeMaxima))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidadeMinima))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidadeEstoque))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unidade))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoUnitario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(precoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(quantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(quantidadeMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(quantidadeMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(nome_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(embalagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void precoUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoUnitarioActionPerformed

    private void nome_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_produtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_produtoActionPerformed

    private void quantidadeEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeEstoqueActionPerformed

    private void tamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tamanhoActionPerformed

    private void JTableRelatorio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRelatorio1MouseClicked
    if (this.JTableRelatorio1.getSelectedRow() != -1) {

            int selectedRow = this.JTableRelatorio1.getSelectedRow();
            int modelRow = this.JTableRelatorio1.convertRowIndexToModel(selectedRow);
        
                DefaultTableModel model = (DefaultTableModel) this.JTableRelatorio1.getModel();
        
                String nome_produto = model.getValueAt(modelRow, 1).toString();
                String precoUnitario = model.getValueAt(modelRow, 2).toString();
                String unidade = model.getValueAt(modelRow, 3).toString();
                String quantidadeEstoque = model.getValueAt(modelRow, 4).toString();
                String quantidadeMinima = model.getValueAt(modelRow, 5).toString();
                String quantidadeMaxima = model.getValueAt(modelRow, 6).toString();
                
                String nome_categoria = model.getValueAt(modelRow, 8).toString();
                String tamanho = model.getValueAt(modelRow, 9).toString();
                String embalagem = model.getValueAt(modelRow, 10).toString();

                this.nome_produto.setText(nome_produto);
                this.precoUnitario.setText(precoUnitario);
                this.unidade.setText(unidade);
                this.quantidadeEstoque.setText(quantidadeEstoque);
                this.quantidadeMinima.setText(quantidadeMinima);
                this.quantidadeMaxima.setText(quantidadeMaxima);
                
                this.nome_categoria.setText(nome_categoria);
                this.tamanho.setText(tamanho);
                this.embalagem.setText(embalagem);
    }
    }//GEN-LAST:event_JTableRelatorio1MouseClicked

    private void JBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEditarActionPerformed

        try {
        int id_produto = 0;
        
        if (this.JTableRelatorio1.getSelectedRow() == -1) {
            throw new Mensagens("Primeiro selecione um produto para alterar");
        } else {
            int selectedRow = this.JTableRelatorio1.getSelectedRow();
            int modelRow = this.JTableRelatorio1.convertRowIndexToModel(selectedRow);
                DefaultTableModel model = (DefaultTableModel) this.JTableRelatorio1.getModel();
                id_produto = Integer.parseInt(model.getValueAt(modelRow, 0).toString());
        }
        

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


        String nomeProduto = this.nome_produto.getText().trim();
        double precoProduto = Double.parseDouble(this.precoUnitario.getText().trim());
        String unidadeProduto = this.unidade.getText().trim();
        int qtdEstoque = Integer.parseInt(this.quantidadeEstoque.getText().trim());
        int qtdMinima = Integer.parseInt(this.quantidadeMinima.getText().trim());
        int qtdMaxima = Integer.parseInt(this.quantidadeMaxima.getText().trim());

        // Obter dados da categoria
        String nomeCategoria = this.nome_categoria.getText().trim();
        String tamanhoCategoria = this.tamanho.getText().trim();
        String embalagemCategoria = this.embalagem.getText().trim();


        if (nomeCategoria.length() <= 3) {
            throw new Mensagens("Nome da categoria deve conter ao menos 3 caracteres.");
        }
        if (tamanhoCategoria.length() <= 0) {
            throw new Mensagens("Informe um tamanho válido.");
        }
        if (embalagemCategoria.length() <= 0) {
            throw new Mensagens("Informe uma embalagem válida.");
        }


        CategoriaDAO categoriaDAO = new CategoriaDAO();
        int id_categoria = categoriaDAO.inserirOuBuscarCategoria(nomeCategoria, tamanhoCategoria, embalagemCategoria);

        if (id_categoria == -1) {
            throw new Mensagens("Erro ao criar/buscar categoria!");
        }


        if (precoProduto <= 0) {
            throw new Mensagens("Preço deve ser maior que zero.");
        }
        
        if (qtdEstoque < 0) {
            throw new Mensagens("Quantidade em estoque não pode ser negativa.");
        }
        
        if (qtdMinima < 0) {
            throw new Mensagens("Quantidade mínima não pode ser negativa.");
        }
        
        if (qtdMaxima <= 0) {
            throw new Mensagens("Quantidade máxima deve ser maior que zero.");
        }
        
        if (qtdMaxima < qtdMinima) {
            throw new Mensagens("Quantidade máxima deve ser maior ou igual à quantidade mínima.");
        }


        if (this.objproduto.UpdateProdutoBD(id_produto, nomeProduto, precoProduto, unidadeProduto, qtdEstoque, qtdMinima,
                qtdMaxima, id_categoria, nomeCategoria, tamanhoCategoria, embalagemCategoria)) {


            this.nome_produto.setText("");
            this.precoUnitario.setText("");
            this.unidade.setText("");
            this.quantidadeEstoque.setText("");
            this.quantidadeMinima.setText("");
            this.quantidadeMaxima.setText("");

            this.nome_categoria.setText("");
            this.tamanho.setText("");
            this.embalagem.setText("");

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
        }


        try {
            System.out.println("Produtos atualizados:");
            this.objproduto.listarTodosProdutos().forEach(p -> {
                System.out.println("ID: " + p.getId_produto() + 
                                 " - Nome: " + p.getNome_produto() + 
                                 " - Preço: " + p.getPrecoUnitario());
            });
        } catch (SQLException ex) {
            Logger.getLogger(FrmGerenciarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

    } catch (Mensagens erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage());
    } catch (NumberFormatException erro2) {
        JOptionPane.showMessageDialog(null, "Erro: Verifique se os campos numéricos estão preenchidos corretamente.");
    } catch (Exception erro3) {
        JOptionPane.showMessageDialog(null, "Erro ao alterar produto: " + erro3.getMessage());
        erro3.printStackTrace();
    } finally {
        carregaTabela();
    }

    }//GEN-LAST:event_JBEditarActionPerformed

    private void JBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExcluirActionPerformed

        try {
            int id_produto = 0;

            if (this.JTableRelatorio1.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro selecione um produto");
            } else {
                int selectedRow = this.JTableRelatorio1.getSelectedRow();
                int modelRow = this.JTableRelatorio1.convertRowIndexToModel(selectedRow);
                    DefaultTableModel model = (DefaultTableModel) this.JTableRelatorio1.getModel();
                    id_produto = Integer.parseInt(model.getValueAt(modelRow, 0).toString());
            }
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR esse produto?");
            if (resposta_usuario == 0) {
                if (this.objproduto.DeleteProdutoBD(id_produto)) {
                    this.nome_produto.setText("");
                    this.precoUnitario.setText("");
                    this.unidade.setText("");
                    this.quantidadeEstoque.setText("");
                    this.quantidadeMinima.setText("");
                    this.quantidadeMaxima.setText("");

                    this.nome_categoria.setText("");
                    this.tamanho.setText("");
                    this.embalagem.setText("");
                    JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
                }
            }
            try {
                System.out.println(this.objproduto.listarTodosProdutos().toString());
            } catch (SQLException ex) {
                Logger.getLogger(FrmGerenciarProduto.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());

        } finally {
            carregaTabela();
        }


    }//GEN-LAST:event_JBExcluirActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(FrmGerenciarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new FrmGerenciarProduto().setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBEditar;
    private javax.swing.JButton JBExcluir;
    private javax.swing.JTable JTableRelatorio1;
    private javax.swing.JTextField embalagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome_categoria;
    private javax.swing.JTextField nome_produto;
    private javax.swing.JTextField precoUnitario;
    private javax.swing.JTextField quantidadeEstoque;
    private javax.swing.JTextField quantidadeMaxima;
    private javax.swing.JTextField quantidadeMinima;
    private javax.swing.JTextField tamanho;
    private javax.swing.JTextField unidade;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("unchecked")
    private void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.JTableRelatorio1.getModel();
        modelo.setNumRows(0);

        List<Produto> minhalista = new ArrayList<>();
        try {
            minhalista = objproduto.listarTodosProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(FrmGerenciarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Produto a : minhalista) {
            modelo.addRow(new Object[]{
                a.getId_produto(),
                a.getNome_produto(),
                a.getPrecoUnitario(),
                a.getUnidade(),
                a.getQuantidadeEstoque(),
                a.getQuantidadeMinima(),
                a.getQuantidadeMaxima(),
                a.getId_categoria(),
                a.getNome_categoria(),
                a.getTamanho(),
                a.getEmbalagem()
            });
        }
    
        configurarOrdenacaoTabela();
    }

private void configurarOrdenacaoTabela() {

    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) JTableRelatorio1.getModel());
    JTableRelatorio1.setRowSorter(sorter);
  
    sorter.setComparator(0, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
        }
    });
    
    sorter.setComparator(1, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString().toLowerCase();
            String s2 = o2.toString().toLowerCase();
            return s1.compareTo(s2);
        }
    });

    sorter.setComparator(2, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Double d1 = (Double) o1;
            Double d2 = (Double) o2;
            return d1.compareTo(d2);
        }
    });

    sorter.setComparator(3, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString().toLowerCase();
            String s2 = o2.toString().toLowerCase();
            return s1.compareTo(s2);
        }
    });

    sorter.setComparator(4, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
        }
    });

    sorter.setComparator(5, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
        }
    });

    sorter.setComparator(6, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
        }
    });

    sorter.setComparator(7, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
        }
    });

    sorter.setComparator(8, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString().toLowerCase();
            String s2 = o2.toString().toLowerCase();
            return s1.compareTo(s2);
        }
    });

    sorter.setComparator(9, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString().toLowerCase();
            String s2 = o2.toString().toLowerCase();
            return s1.compareTo(s2);
        }
    });

    sorter.setComparator(10, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString().toLowerCase();
            String s2 = o2.toString().toLowerCase();
            return s1.compareTo(s2);
        }
    });

    sorter.setSortsOnUpdates(true);
    JTableRelatorio1.setAutoCreateRowSorter(false);
}

}
