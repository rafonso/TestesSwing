/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TesteTabela.java
 *
 * Created on 11/03/2010, 22:14:50
 */
package testeswing;

import testeswing.tabela.TableNumber;

/**
 *
 * @author rafael
 */
public class TesteTabela2 extends javax.swing.JFrame {

    /** Creates new form TesteTabela */
    public TesteTabela2() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlControle = new javax.swing.JPanel();
        btnDados = new javax.swing.JButton();
        scpNumeros = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 400));

        btnDados.setText("Entrar Dados");
        btnDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlControleLayout = new javax.swing.GroupLayout(pnlControle);
        pnlControle.setLayout(pnlControleLayout);
        pnlControleLayout.setHorizontalGroup(
            pnlControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(pnlControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlControleLayout.createSequentialGroup()
                    .addGap(0, 152, Short.MAX_VALUE)
                    .addComponent(btnDados)
                    .addGap(0, 153, Short.MAX_VALUE)))
        );
        pnlControleLayout.setVerticalGroup(
            pnlControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
            .addGroup(pnlControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlControleLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btnDados)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlControle, java.awt.BorderLayout.SOUTH);

        scpNumeros.setMinimumSize(new java.awt.Dimension(100, 100));
        getContentPane().add(scpNumeros, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDadosActionPerformed
        DialogDados dialogDados = new DialogDados(this, true);
        
    }//GEN-LAST:event_btnDadosActionPerformed

    private void criarNovaTabela(int size) {

        //this.scpNumeros.setViewportView(new TableNumber(size));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TesteTabela2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDados;
    private javax.swing.JPanel pnlControle;
    private javax.swing.JScrollPane scpNumeros;
    // End of variables declaration//GEN-END:variables

}
