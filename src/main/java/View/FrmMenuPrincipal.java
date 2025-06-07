package View;

public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        JMenuEstoque = new javax.swing.JMenu();
        JMenuItemCadastrarProduto = new javax.swing.JMenuItem();
        JMenuItemGerenciarProdutos = new javax.swing.JMenuItem();
        JMenuMovimentacao = new javax.swing.JMenu();
        JMenuItemEntradaSaida = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Estoque");

        JMenuEstoque.setText("Estoque");

        JMenuItemCadastrarProduto.setText("Cadastrar Produto");
        JMenuItemCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemCadastrarProdutoActionPerformed(evt);
            }
        });
        JMenuEstoque.add(JMenuItemCadastrarProduto);

        JMenuItemGerenciarProdutos.setText("Gerenciar Produtos");
        JMenuItemGerenciarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemGerenciarProdutosActionPerformed(evt);
            }
        });
        JMenuEstoque.add(JMenuItemGerenciarProdutos);

        jMenuBar1.add(JMenuEstoque);

        JMenuMovimentacao.setText("Movimentação");

        JMenuItemEntradaSaida.setText("Entrada e Saída");
        JMenuItemEntradaSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemEntradaSaidaActionPerformed(evt);
            }
        });
        JMenuMovimentacao.add(JMenuItemEntradaSaida);

        jMenuBar1.add(JMenuMovimentacao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMenuItemCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemCadastrarProdutoActionPerformed
       FrmCadastrarProduto objeto = new FrmCadastrarProduto();
       objeto.setVisible(true);
    }//GEN-LAST:event_JMenuItemCadastrarProdutoActionPerformed

    private void JMenuItemGerenciarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemGerenciarProdutosActionPerformed
        FrmGerenciarProduto objeto = new FrmGerenciarProduto();
                objeto.setVisible(true);
    }//GEN-LAST:event_JMenuItemGerenciarProdutosActionPerformed

    private void JMenuItemEntradaSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemEntradaSaidaActionPerformed
            FrmMovimentacao objeto = new FrmMovimentacao();
            objeto.setVisible(true);
    }//GEN-LAST:event_JMenuItemEntradaSaidaActionPerformed

    
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
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenuEstoque;
    private javax.swing.JMenuItem JMenuItemCadastrarProduto;
    private javax.swing.JMenuItem JMenuItemEntradaSaida;
    private javax.swing.JMenuItem JMenuItemGerenciarProdutos;
    private javax.swing.JMenu JMenuMovimentacao;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
