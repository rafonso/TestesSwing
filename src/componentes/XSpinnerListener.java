/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package componentes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author rafael
 */
public class XSpinnerListener implements MouseWheelListener, KeyListener {

    public static final String CTRL_END = "CTRL_END";
    public static final String CTRL_HOME = "CTRL_HOME";
    public static final String CTRL_UP = "CTRL_UP";
    public static final String CTRL_DOWN = "CTRL_DOWN";
    private Number extendedStep;

    private ExtendedStepper getStepper(Object currentValue) {
        if (currentValue instanceof Integer) {
            return new IntegerStepper();
        }
        if (currentValue instanceof Double) {
            return new DoubleStepper();
        }

        throw new IllegalArgumentException("Classe irregular para determinar-se o valor seguinte de JSpinner: " + currentValue.getClass().getSimpleName());
    }

    private Object getExtendedNewValue(SpinnerNumberModel model, boolean add) {
        int signal = add ? +1 : -1;
        return this.getStepper(model.getValue()).getNewValue(model, this.extendedStep, signal);
    }

    private Object getSimpleNewValue(SpinnerNumberModel model, boolean add) {
        Object newValue = add ? model.getNextValue() : model.getPreviousValue();

        if (newValue != null) {
            return newValue;
        } else if (add) {
            return model.getMaximum();
        } else {
            return model.getMinimum();
        }
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        JSpinner spinner = (JSpinner) e.getSource();
        SpinnerNumberModel model = (SpinnerNumberModel) spinner.getModel();
        boolean add = (e.getWheelRotation() < 0);

        boolean extender = SwingUtilities.isRightMouseButton(e) || (e.isControlDown());

        Object newValue = extender
                ? this.getExtendedNewValue(model, add)
                : this.getSimpleNewValue(model, add);
        model.setValue(newValue);
    }

    private JSpinner getSpinner(KeyEvent e) {
        JComponent c = (JComponent) e.getSource();
        if (c instanceof JFormattedTextField) {
            JComponent c1 = (JComponent) c.getParent();
            if (c1 instanceof JSpinner.NumberEditor) {
                return (JSpinner) c1.getParent();
            }
        }
        throw new IllegalStateException("Este Listener não está vinculado a um JSPinner");
    }

    public void keyPressed(KeyEvent e) {
        if ((e.getModifiersEx() == KeyEvent.CTRL_DOWN_MASK)) {
            SpinnerNumberModel model = (SpinnerNumberModel) this.getSpinner(e).getModel();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_PAGE_UP:
                    model.setValue(this.getExtendedNewValue(model, true));
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_PAGE_DOWN:
                    model.setValue(this.getExtendedNewValue(model, false));
                    break;
                case KeyEvent.VK_HOME:
                    if (model.getMaximum() != null) {
                        model.setValue(model.getMaximum());
                    }
                    break;
                case KeyEvent.VK_END:
                    if (model.getMinimum() != null) {
                        model.setValue(model.getMinimum());
                    }
                    break;
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        //System.out.println(e);
    }

    public void keyTyped(KeyEvent e) {
        // System.out.println(e);
    }

    public Number getExtendedStep() {
        return extendedStep;
    }

    public void setExtendedStep(Number extendedStep) {
        this.extendedStep = extendedStep;
    }
}
