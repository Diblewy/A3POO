
package View;

import DAO.ProdutoDAO;
import Model.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class FrmMovimentacao extends javax.swing.JFrame {

    private Produto objproduto;
    private ProdutoDAO produtoDAO;
    private int produtoSelecionadoId = -1;


    public FrmMovimentacao() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.objproduto = new Produto();
        this.produtoDAO = new ProdutoDAO();
        this.carregaTabela();
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTableRelatorio2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JBCancelar = new javax.swing.JButton();
        JBComprar = new javax.swing.JButton();
        nome_produto = new javax.swing.JTextField();
        JBVender = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        quantidadeEstoque = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada e saida de produtos");

        JTableRelatorio2.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableRelatorio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRelatorio2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableRelatorio2);
        if (JTableRelatorio2.getColumnModel().getColumnCount() > 0) {
            JTableRelatorio2.getColumnModel().getColumn(0).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(1).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(2).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(3).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(4).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(5).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(6).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(7).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(8).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(9).setResizable(false);
            JTableRelatorio2.getColumnModel().getColumn(10).setResizable(false);
        }

        jLabel1.setText("Nome");

        JBCancelar.setText("Cancelar");
        JBCancelar.setMinimumSize(new java.awt.Dimension(80, 27));
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBComprar.setText("Comprar");
        JBComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBComprarActionPerformed(evt);
            }
        });

        JBVender.setText("Vender");
        JBVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVenderActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade");

        quantidadeEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nome_produto))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(JBVender)
                        .addGap(39, 39, 39)
                        .addComponent(JBComprar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidadeEstoque)))
                .addGap(292, 292, 292))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(quantidadeEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBComprar)
                    .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBVender))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBComprarActionPerformed
        try {
            if (produtoSelecionadoId == -1) {
                throw new Mensagens("Primeiro selecione um produto na tabela!");
            }
            
            if (this.quantidadeEstoque.getText().trim().isEmpty()) {
                throw new Mensagens("Informe a quantidade a ser comprada!");
            }

            int quantidadeCompra = Integer.parseInt(this.quantidadeEstoque.getText().trim());

            if (quantidadeCompra <= 0) {
                throw new Mensagens("A quantidade deve ser maior que zero!");
            }

            int resposta = JOptionPane.showConfirmDialog(null, 
                "Confirma a compra de " + quantidadeCompra + " unidades do produto: " + this.nome_produto.getText() + "?",
                "Confirmar Compra", 
                JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                produtoDAO.comprarProduto(produtoSelecionadoId, quantidadeCompra);

                JOptionPane.showMessageDialog(null, 
                    "Compra realizada com sucesso!\nQuantidade adicionada: " + quantidadeCompra + " unidades",
                    "Compra Concluída", 
                    JOptionPane.INFORMATION_MESSAGE);

                limparCampos();
                carregaTabela();
        }

    } catch (Mensagens erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException erro2) {
        JOptionPane.showMessageDialog(null, "Erro: Digite apenas números inteiros para a quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException erro3) {
        JOptionPane.showMessageDialog(null, "Erro ao realizar compra: " + erro3.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        erro3.printStackTrace();
    }

    }//GEN-LAST:event_JBComprarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTableRelatorio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRelatorio2MouseClicked
        
        if (this.JTableRelatorio2.getSelectedRow() != -1) {
            int selectedRow = this.JTableRelatorio2.getSelectedRow();
            int modelRow = this.JTableRelatorio2.convertRowIndexToModel(selectedRow);

            DefaultTableModel model = (DefaultTableModel) this.JTableRelatorio2.getModel();

            produtoSelecionadoId = Integer.parseInt(model.getValueAt(modelRow, 0).toString());
            String nomeProduto = model.getValueAt(modelRow, 1).toString();
            String estoqueAtual = model.getValueAt(modelRow, 4).toString();

            this.nome_produto.setText(nomeProduto);
            this.quantidadeEstoque.setText("");

            JOptionPane.showMessageDialog(null, 
                "Produto selecionado: " + nomeProduto + "\nEstoque atual: " + estoqueAtual + " unidades",
                "Produto Selecionado", 
                JOptionPane.INFORMATION_MESSAGE);
            }
    }//GEN-LAST:event_JTableRelatorio2MouseClicked

    private void JBVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVenderActionPerformed
       try {
        if (produtoSelecionadoId == -1) {
            throw new Mensagens("Primeiro selecione um produto na tabela!");
        }

        if (this.quantidadeEstoque.getText().trim().isEmpty()) {
            throw new Mensagens("Informe a quantidade a ser vendida!");
        }

        int quantidadeVenda = Integer.parseInt(this.quantidadeEstoque.getText().trim());

        if (quantidadeVenda <= 0) {
            throw new Mensagens("A quantidade deve ser maior que zero!");
        }

        int resposta = JOptionPane.showConfirmDialog(null, 
            "Confirma a venda de " + quantidadeVenda + " unidades do produto: " + this.nome_produto.getText() + "?",
            "Confirmar Venda", 
            JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            produtoDAO.venderProduto(produtoSelecionadoId, quantidadeVenda);

            JOptionPane.showMessageDialog(null, 
                "Venda realizada com sucesso!\nQuantidade vendida: " + quantidadeVenda + " unidades",
                "Venda Concluída", 
                JOptionPane.INFORMATION_MESSAGE);

            limparCampos();
            carregaTabela();
        }

    } catch (Mensagens erro) {
        JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException erro2) {
        JOptionPane.showMessageDialog(null, "Erro: Digite apenas números inteiros para a quantidade!", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException erro3) {
        JOptionPane.showMessageDialog(null, "Erro ao realizar venda: " + erro3.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        erro3.printStackTrace();
    }

    }//GEN-LAST:event_JBVenderActionPerformed

    private void quantidadeEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeEstoqueActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMovimentacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBComprar;
    private javax.swing.JButton JBVender;
    private javax.swing.JTable JTableRelatorio2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome_produto;
    private javax.swing.JTextField quantidadeEstoque;
    // End of variables declaration//GEN-END:variables

    
@SuppressWarnings("unchecked")
private void carregaTabela() {
    DefaultTableModel modelo = (DefaultTableModel) this.JTableRelatorio2.getModel();
    modelo.setNumRows(0);

    List<Produto> minhalista = new ArrayList<>();
    try {
        minhalista = objproduto.listarTodosProdutos();
    } catch (SQLException ex) {
        Logger.getLogger(FrmMovimentacao.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Erro ao carregar produtos: " + ex.getMessage());
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


private void limparCampos() {
    this.nome_produto.setText("");
    this.quantidadeEstoque.setText("");
    this.produtoSelecionadoId = -1;
    this.JTableRelatorio2.clearSelection();
}


private void configurarOrdenacaoTabela() {
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>((DefaultTableModel) JTableRelatorio2.getModel());
    JTableRelatorio2.setRowSorter(sorter);
    
    sorter.setComparator(0, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
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
    
    sorter.setComparator(4, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer) o1;
            Integer i2 = (Integer) o2;
            return i1.compareTo(i2);
        }
    });
    
    sorter.setSortsOnUpdates(true);
    JTableRelatorio2.setAutoCreateRowSorter(false);
}

}
