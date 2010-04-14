package jxSpinner;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SpinnerModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author rafael
 */
public class SliderSpinner extends JPanel implements PropertyChangeListener {

    public static enum SpinnerPosition {

        BEGIN {

            @Override
            Object getBorderPosition(Orientation orientation) {
                return (orientation == Orientation.HORIZONTAL) ? BorderLayout.WEST : BorderLayout.NORTH;
            }
        },
        END {

            @Override
            Object getBorderPosition(Orientation orientation) {
                return (orientation == Orientation.HORIZONTAL) ? BorderLayout.EAST : BorderLayout.SOUTH;
            }
        };

        abstract Object getBorderPosition(Orientation orientation);
    }

    public static enum Orientation {

        HORIZONTAL(JSlider.HORIZONTAL), VERTICAL(JSlider.VERTICAL);
        private final int sliderOrientation;

        private Orientation(int sliderOrientation) {
            this.sliderOrientation = sliderOrientation;
        }

        int getSliderOrientation() {
            return sliderOrientation;
        }
    }
    public static final String PROP_TITULO = "titulo";
    public static final String PROP_ORDER = "order";
    public static final String PROP_SLIDER_POSITION = "sliderPosition";
    public static final String PROP_EXTENDED_STEP = JXSpinner.PROP_EXTENDED_STEP;
    public static final String PROP_MAXIMUM = JXSpinner.PROP_MAXIMUM;
    public static final String PROP_MINIMUM = JXSpinner.PROP_MINIMUM;
    public static final String PROP_PATTERN = JXSpinner.PROP_PATTERN;
    public static final String PROP_STEP = JXSpinner.PROP_STEP;
    public static final String PROP_VALUE = JXSpinner.PROP_VALUE;
    private static final Set<String> JXSPINNER_PROPERTIES = new HashSet<String>(Arrays.asList(PROP_EXTENDED_STEP, PROP_MAXIMUM, PROP_MINIMUM, PROP_PATTERN, PROP_STEP, PROP_VALUE));

    /** Creates new form BeanForm */
    public SliderSpinner() {
        this.sliderPosition = SpinnerPosition.END;
        this.orientation = Orientation.HORIZONTAL;
        initComponents();
        this.changeSliderPosition();
    }

    private TitledBorder getTitledBorder() {
        return (TitledBorder) this.getBorder();
    }

    private Dimension invertDimension(Dimension d) {
        return new Dimension(d.height, d.width);
    }

    private void changeOrientation() {
        this.slider.setOrientation(this.getOrientation().getSliderOrientation());
        this.slider.setSize(this.invertDimension(this.slider.getSize()));
        this.slider.setMaximumSize(this.invertDimension(this.slider.getMaximumSize()));
        this.slider.setMinimumSize(this.invertDimension(this.slider.getMinimumSize()));

        changeOrder();
    }

    private void changeOrder() {
        this.remove(this.pnlSlider);
        this.add(this.pnlSlider, this.getSliderPosition().getBorderPosition(this.getOrientation()));
    }

    private int valueToSlider() {
        int position;

        if (this.getValue().equals(this.getMinimum())) {
            position = this.slider.getMinimum();
        } else if (this.getValue().equals(this.getMaximum())) {
            position = this.slider.getMaximum();
        } else {
            final int numeratorValue = (int) (this.getValue().doubleValue() - this.getMinimum().doubleValue());
            final int numeratorPosition = this.slider.getMaximum() - this.slider.getMinimum();
            final int denominatorValue = (int) (this.getMaximum().doubleValue() - this.getMinimum().doubleValue());
            position = numeratorValue * numeratorPosition / denominatorValue + this.slider.getMinimum();
        }

        return position;
    }
    
    private void changeSliderPosition() {
        System.out.println(this.valueToSlider());
        this.slider.setValue(this.valueToSlider());
    }

    private Number sliderToValue() {
        Number value;

        if (this.slider.getValue() == this.slider.getMaximum()) {
            value = this.getMaximum();
        } else if (this.slider.getValue() == this.slider.getMinimum()) {
            value = this.getMinimum();
        } else {
            final int numeratorPosition = this.slider.getValue() - this.slider.getMinimum();
            final int denominatorPosition = this.slider.getMaximum() - this.slider.getMinimum();
            if (this.getStep() instanceof Integer) {
                final int numeratorValue = this.getMaximum().intValue() - this.getMinimum().intValue();
                value = numeratorPosition * numeratorValue / denominatorPosition + this.getMinimum().intValue();
            } else if (this.getStep() instanceof Double) {
                final double numeratorValue = this.getMaximum().doubleValue() - this.getMinimum().doubleValue();
                value = numeratorPosition * numeratorValue / denominatorPosition + this.getMinimum().intValue();
            } else if (this.getStep() instanceof BigDecimal) {
                final BigDecimal numeratorValue = ((BigDecimal) this.getMaximum()).subtract((BigDecimal) this.getMinimum());
                value = (new BigDecimal(numeratorPosition)).multiply(numeratorValue).divide(new BigDecimal(denominatorPosition)).add((BigDecimal) this.getMinimum());
            } else {
                throw new IllegalStateException("Step class unknown: " + this.getStep().getClass());
            }
        }

        return value;
    }

    private void validateNewValue(Object value, String fieldName) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " can not be null.");
        }
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
        pnlSlider = new javax.swing.JPanel();
        spinner = new jxSpinner.JXSpinner();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setLayout(new java.awt.BorderLayout(5, 5));

        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMinimumSize(new java.awt.Dimension(200, 31));
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });
        add(slider, java.awt.BorderLayout.CENTER);

        pnlSlider.add(spinner);
        this.spinner.addPropertyChangeListener(this);

        add(pnlSlider, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        System.out.println(this.slider.getValue());
        this.setValue(this.sliderToValue());
    }//GEN-LAST:event_sliderStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlSlider;
    private javax.swing.JSlider slider;
    private jxSpinner.JXSpinner spinner;
    // End of variables declaration//GEN-END:variables
    private SpinnerPosition sliderPosition;
    private Orientation orientation;

    public String getTitulo() {
        return this.getTitledBorder().getTitle();
    }

    public void setTitulo(String titulo) {
        String oldValue = this.getTitledBorder().getTitle();
        this.getTitledBorder().setTitle(titulo);
        super.repaint();
        super.firePropertyChange(PROP_TITULO, oldValue, titulo);
    }

    public SpinnerPosition getSliderPosition() {
        return sliderPosition;
    }

    public void setSliderPosition(SpinnerPosition order) {
        this.validateNewValue(order, "Slider Position");

        if (order != this.sliderPosition) {
            Object oldValue = this.sliderPosition;
            this.sliderPosition = order;
            super.firePropertyChange(PROP_ORDER, oldValue, this.sliderPosition);
            this.changeOrder();
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.validateNewValue(orientation, "Orientation");

        if (this.orientation != orientation) {
            Object oldValue = this.orientation;
            this.orientation = orientation;
            super.firePropertyChange(PROP_SLIDER_POSITION, oldValue, this.orientation);
            this.changeOrientation();
        }
    }

    public void setStep(Number step) {
        this.validateNewValue(step, "Step");
        
        Object oldValue = this.getStep();
        spinner.setStep(step);
        super.firePropertyChange(PROP_STEP, oldValue, step);
    }

    public void setPattern(String pattern) {
        this.validateNewValue(pattern, "Pattern");

        Object oldValue = this.getPattern();
        spinner.setPattern(pattern);
        super.firePropertyChange(PROP_PATTERN, oldValue, pattern);
    }

    public void setModel(SpinnerModel model) {
        this.validateNewValue(model, "Spinner Model");

        Object oldValue = this.spinner.getModel();
        spinner.setModel(model);
        //super.firePropertyChange(PROP_, oldValue, step);
    }

    public void setMinimum(Number minimum) {
        this.validateNewValue(minimum, "Minumum");

        Object oldValue = this.getMinimum();
        spinner.setMinimum(minimum);
        this.changeSliderPosition();
        super.firePropertyChange(PROP_MINIMUM, oldValue, minimum);
    }

    public void setMaximum(Number maximum) {
        this.validateNewValue(maximum, "Maximum");

        Object oldValue = this.getMaximum();
        spinner.setMaximum(maximum);
        this.changeSliderPosition();
        super.firePropertyChange(PROP_MAXIMUM, oldValue, maximum);
    }

    public void setExtendedStep(Number extendedStep) {
        this.validateNewValue(extendedStep, "Extended Step");
        Object oldValue = this.getExtendedStep();
        spinner.setExtendedStep(extendedStep);
        super.firePropertyChange(PROP_EXTENDED_STEP, oldValue, extendedStep);
    }

    public void setEditor(JComponent editor) {
        this.validateNewValue(editor, "Editor");

        Object oldValue = this.spinner.getEditor();
        spinner.setEditor(editor);
        //super.firePropertyChange(PROP_, oldValue, editor);
    }

    public Number getStep() {
        return spinner.getStep();
    }

    public String getPattern() {
        return spinner.getPattern();
    }

    public Number getMinimum() {
        return spinner.getMinimum();
    }

    public Number getMaximum() {
        return spinner.getMaximum();
    }

    public Number getExtendedStep() {
        return spinner.getExtendedStep();
    }

    public void setValue(Number value) {
        spinner.setValue(value);
        this.changeSliderPosition();
    }

    public Number getValue() {
        return (Number) spinner.getValue();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getPropertyName() + ": From " + evt.getOldValue() + " to " + evt.getNewValue());
        if(evt.getPropertyName().equals(JXSpinner.PROP_VALUE)) {
            this.changeSliderPosition();
        }
        super.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    }

    @Override
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        super.addPropertyChangeListener(propertyName, listener);
        if (JXSPINNER_PROPERTIES.contains(propertyName)) {
            this.spinner.addPropertyChangeListener(propertyName, listener);
        }
    }
}
