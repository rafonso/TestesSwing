package jxSpinner;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.SwingUtilities;

/**
 *
 * @author rafael
 */
public class XNumberEditor extends NumberEditor implements MouseWheelListener {

    public static final String CTRL_END = "CTRL_END";
    public static final String CTRL_HOME = "CTRL_HOME";
    public static final String CTRL_UP = "CTRL_UP";
    public static final String CTRL_DOWN = "CTRL_DOWN";

    public XNumberEditor(JXSpinner spinner, String decimalFormatPattern) {
        super(spinner, decimalFormatPattern);
    }

    public XNumberEditor(JXSpinner spinner) {
        super(spinner);
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        JXSpinner jXSpinner = (JXSpinner) super.getSpinner();
        XSpinnerNumberModel numberModel = (XSpinnerNumberModel) jXSpinner.getModel();
        boolean add = (e.getWheelRotation() < 0);
        boolean extender = SwingUtilities.isRightMouseButton(e) || (e.isControlDown());

        Object newValue = null;
        if(extender) {
            newValue = add? numberModel.getNextExtendedValue(): numberModel.getPreviousExtendedValue();
        } else {
            newValue = add? numberModel.getNextValue(): numberModel.getPreviousValue();
        }
        numberModel.setValue(newValue);
    }
}
