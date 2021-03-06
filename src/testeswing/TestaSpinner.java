/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestaSpinner.java
 *
 * Created on 13/03/2010, 00:07:15
 */
package testeswing;

/**
 *
 * @author rafael
 */
public class TestaSpinner extends javax.swing.JFrame {

    public static final String CTRL_UP = "CTRL_UP";
    public static final String CTRL_DOWN = "CTRL_DOWN";

    /** Creates new form TestaSpinner */
    public TestaSpinner() {
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

        lblValor = new javax.swing.JLabel();
        spnValor = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teste de JSpinner");
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        lblValor.setFont(new java.awt.Font("Tahoma", 0, 48));
        lblValor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValor.setMaximumSize(new java.awt.Dimension(100, 58));
        lblValor.setMinimumSize(new java.awt.Dimension(100, 58));
        lblValor.setPreferredSize(new java.awt.Dimension(100, 58));
        getContentPane().add(lblValor);

        spnValor.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        spnValor.setModel(new javax.swing.SpinnerNumberModel(0, -50, 50, 1));
        spnValor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnValorStateChanged(evt);
            }
        });
        getContentPane().add(spnValor);
        ExpandedSpinnerListener.bindSpinner(spnValor, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spnValorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnValorStateChanged
        this.lblValor.setText(this.spnValor.getValue().toString());
    }//GEN-LAST:event_spnValorStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TestaSpinner().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblValor;
    private javax.swing.JSpinner spnValor;
    // End of variables declaration//GEN-END:variables
}
