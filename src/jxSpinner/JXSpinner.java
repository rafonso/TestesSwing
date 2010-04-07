package jxSpinner;

import java.awt.event.MouseWheelListener;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

/**
 *
 * @author rafael
 */
public class JXSpinner extends JSpinner implements Serializable {

    public static final String PROP_EXTENDED_STEP = "extendedStep";
    public static final String PROP_MAXIMUM = "maximum";
    public static final String PROP_MINIMUM = "minimum";
    public static final String PROP_PATTERN = "pattern";
    public static final String PROP_STEP = "step";
    public static final String PROP_VALUE = "value";
    private Number step = 1;
    private Number extendedStep = 1;
    private Number minimum = 0;
    private Number maximum = 10;
    private String pattern = "00";

    /** Creates new form BeanForm */
    public JXSpinner() {
        super();
        initComponents();
        initModel();
    }

    public JXSpinner(SpinnerModel model) {
        super(model);
        initComponents();
        initModel();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setModel(new XSpinnerNumberModel.IntXSpinnerNumberModel());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private void initModel() {
        this.getModelAsXModel().setExtendedStep(extendedStep);
        this.getModelAsXModel().setStepSize(step);
        this.getModelAsXModel().setMaximum(maximum);
        this.getModelAsXModel().setMinimum(minimum);
    }

    private XNumberEditor createNewEditor(String pattern) {
        for (MouseWheelListener l : super.getMouseWheelListeners()) {
            if (l instanceof XNumberEditor) {
                super.removeMouseWheelListener(l);
            }
        }

        XNumberEditor editor = new XNumberEditor(this, pattern);
        super.addMouseWheelListener(editor);

        return editor;
    }

    private XSpinnerNumberModel getModelAsXModel() {
        return (XSpinnerNumberModel) super.getModel();
    }

    private XNumberEditor getEditorAsXEditor() {
        return (XNumberEditor) super.getEditor();
    }

    @Override
    protected JComponent createEditor(SpinnerModel model) {
        return createNewEditor("00");
    }

    public Number getExtendedStep() {
        return extendedStep;
    }

    public void setExtendedStep(Number extendedStep) {
        Number oldValue = this.extendedStep;
        this.extendedStep = extendedStep;
        this.getModelAsXModel().setExtendedStep(this.extendedStep);
        super.firePropertyChange(PROP_EXTENDED_STEP, oldValue, this.extendedStep);
    }

    public Number getMaximum() {
        return maximum;
    }

    public void setMaximum(Number maximum) {
        Number oldValue = this.maximum;
        this.maximum = maximum;
        this.getModelAsXModel().setMaximum(this.maximum);
        super.firePropertyChange(PROP_MAXIMUM, oldValue, this.maximum);
    }

    public Number getMinimum() {
        return minimum;
    }

    public void setMinimum(Number minimum) {
        Number oldValue = this.minimum;
        this.minimum = minimum;
        this.getModelAsXModel().setMinimum(this.minimum);
        super.firePropertyChange(PROP_MINIMUM, oldValue, this.minimum);
    }

    @Override
    public void setEditor(JComponent editor) {
        final XNumberEditor xEditor = (XNumberEditor) editor;
        super.removeMouseWheelListener(this.getEditorAsXEditor());
        super.addMouseWheelListener(xEditor);
        super.setEditor(xEditor);
    }

    @Override
    public void setModel(SpinnerModel model) {
        super.setModel((XSpinnerNumberModel) model);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        String oldValue = this.pattern;
        this.pattern = pattern;
        super.setEditor(this.createNewEditor(pattern));
        super.firePropertyChange(PROP_PATTERN, oldValue, this.pattern);
    }

    public Number getStep() {
        return step;
    }

    public void setStep(Number step) {
        Number oldValue = this.step;
        this.step = step;
        this.getModelAsXModel().setStepSize(step);
        super.firePropertyChange(PROP_STEP, oldValue, this.step);
    }
}