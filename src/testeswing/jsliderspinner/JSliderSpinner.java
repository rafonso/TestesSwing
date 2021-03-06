/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JSliderSpinner.java
 *
 * Created on 19/03/2010, 21:58:30
 */
package testeswing.jsliderspinner;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 *
 * @author rafael
 */
public class JSliderSpinner extends javax.swing.JPanel implements ChangeListener {

    /** Creates new form JSliderSpinner */
    public JSliderSpinner() {
        super();

        this.spinnerNumberModel = new SpinnerNumberModel(0.0, 0.0, 1.0, 0.01);
        this.spinnerNumberModel.addChangeListener(this);

        initComponents();

        this.setValor(0.5);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slider = new javax.swing.JSlider();
        spinner = new javax.swing.JSpinner();

        setBorder(javax.swing.BorderFactory.createTitledBorder("borda"));

        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(this);
        slider.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                sliderMouseWheelMoved(evt);
            }
        });

        spinner.setModel(this.spinnerNumberModel);
        spinner.setEditor(new javax.swing.JSpinner.NumberEditor(spinner, "0.00"));
        spinner.addChangeListener(this);
        spinner.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                spinnerMouseWheelMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addComponent(slider, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void spinnerMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_spinnerMouseWheelMoved
        System.out.println(evt);

        Double newValue = (Double)((evt.getWheelRotation() > 0)? this.spinnerNumberModel.getPreviousValue(): this.spinnerNumberModel.getNextValue());
        if(newValue != null) {
            this.spinnerNumberModel.setValue(newValue);
        }
        /*
        int sentido = (evt.getWheelRotation() > 0)? -1: 1;
        double nextValue = ((Double)this.spinner.getValue()) + sentido * ((Double)this.spinnerNumberModel.getStepSize());
        this.spinner.setValue(nextValue);
         * 
         */
    }//GEN-LAST:event_spinnerMouseWheelMoved

    private void sliderMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_sliderMouseWheelMoved
        int sentido = (evt.getWheelRotation() > 0)? -1: 1;
        this.slider.setValue(this.slider.getValue() + sentido);
        // TODO add your handling code here:
    }//GEN-LAST:event_sliderMouseWheelMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider slider;
    private javax.swing.JSpinner spinner;
    // End of variables declaration//GEN-END:variables
    private double valor;
    private SpinnerNumberModel spinnerNumberModel;

    public JSlider getSlider() {
        return slider;
    }

    public JSpinner getSpinner() {
        return spinner;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        double oldValor = this.valor;
        this.valor = valor;
        super.firePropertyChange("valor", oldValor, this.valor);
    }

    public void stateChanged(ChangeEvent e) {
        System.out.println(e);
    }





}
