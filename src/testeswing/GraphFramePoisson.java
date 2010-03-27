package testeswing;

import java.awt.Color;
import org.jdesktop.swingx.JXGraph;

/**
 * GRáfico da Equação y(x) = A * x * e<sup>-B * x</sup>
 * @author rafael
 */
public class GraphFramePoisson extends javax.swing.JFrame {

    /** Creates new form TestGraph5 */
    public GraphFramePoisson() {
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
        lblA = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        spnB = new javax.swing.JSpinner();
        spnA = new javax.swing.JSpinner();
        pnlEquacao = new javax.swing.JPanel();
        lblEquacao = new org.jdesktop.swingx.JXLabel();
        graph = new org.jdesktop.swingx.JXGraph();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A * x * e^(- B * x)");

        lblA.setLabelFor(spnA);
        lblA.setText("A = ");

        lblB.setLabelFor(spnB);
        lblB.setText("B = ");

        spnB.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(0.01d), null, Double.valueOf(0.01d)));
        spnB.setEditor(new javax.swing.JSpinner.NumberEditor(spnB, "0.00"));
        spnB.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnBStateChanged(evt);
            }
        });

        spnA.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), null, null, Double.valueOf(0.01d)));
        spnA.setEditor(new javax.swing.JSpinner.NumberEditor(spnA, "0.00"));
        spnA.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnAStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlControleLayout = new javax.swing.GroupLayout(pnlControle);
        pnlControle.setLayout(pnlControleLayout);
        pnlControleLayout.setHorizontalGroup(
            pnlControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(lblB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlControleLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spnA, spnB});

        pnlControleLayout.setVerticalGroup(
            pnlControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblA)
                    .addComponent(spnA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblB)
                    .addComponent(spnB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ExpandedSpinnerListener.bindSpinner(spnB, 1.0);
        ExpandedSpinnerListener.bindSpinner(spnA, 1.0);

        getContentPane().add(pnlControle, java.awt.BorderLayout.PAGE_END);

        lblEquacao.setText("<html>y(x) = A * x * e<sup>-B * x</sup></html>");
        pnlEquacao.add(lblEquacao);

        getContentPane().add(pnlEquacao, java.awt.BorderLayout.PAGE_START);

        graph.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        graph.setAutoscrolls(true);
        graph.setInputEnabled(false);
        graph.setMajorX(1.0);
        graph.setMajorY(1.0);
        graph.setMinorCountX(2);
        graph.setMinorCountY(2);
        graph.setView(new java.awt.geom.Rectangle2D.Double(0.0, 0.0, 10.0, 10.0));

        javax.swing.GroupLayout graphLayout = new javax.swing.GroupLayout(graph);
        graph.setLayout(graphLayout);
        graphLayout.setHorizontalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        graphLayout.setVerticalGroup(
            graphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 227, Short.MAX_VALUE)
        );

        getContentPane().add(graph, java.awt.BorderLayout.CENTER);
        graph.addPlots(Color.RED, this.plot);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spnAStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnAStateChanged
        this.plot.setA((Double) this.spnA.getValue());
    }//GEN-LAST:event_spnAStateChanged

    private void spnBStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnBStateChanged
        this.plot.setB((Double) this.spnB.getValue());
    }//GEN-LAST:event_spnBStateChanged

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphFramePoisson().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXGraph graph;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private org.jdesktop.swingx.JXLabel lblEquacao;
    private javax.swing.JPanel pnlControle;
    private javax.swing.JPanel pnlEquacao;
    private javax.swing.JSpinner spnA;
    private javax.swing.JSpinner spnB;
    // End of variables declaration//GEN-END:variables

    private PoissonPlot plot = new PoissonPlot();

    private class PoissonPlot extends JXGraph.Plot {

        private double a = 1.0;

        private double b = 1.0;

        public void setA(double a) {
            double oldA = this.a;
            this.a = a;
            super.firePropertyChange("a", oldA, this.a);
        }

        public void setB(double b) {
            double oldB = this.b;
            this.b = b;
            super.firePropertyChange("b", oldB, this.b);
        }

        @Override
        public double compute(double x) {
            return this.a * x * Math.exp(- this.b * x);
        }

    }

}
