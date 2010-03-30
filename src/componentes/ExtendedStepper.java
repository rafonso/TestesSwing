/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import javax.swing.SpinnerNumberModel;

/**
 *
 * @author rafael
 */
abstract class ExtendedStepper<N extends Number> {

    protected abstract Comparable getWithStep(N currentValue, N step, int signal);

    protected abstract Comparable getWithNoStep(N currentValue, int signal, N modelStep, N min, N max);

    Comparable getNewValue(SpinnerNumberModel model, N extendedStep, int signal) {
        Comparable newValue = (extendedStep != null) ? getWithStep((N) model.getValue(), extendedStep, signal)
                : getWithNoStep((N) model.getValue(), signal, (N) model.getStepSize(), (N) model.getMinimum(), (N) model.getMaximum());

        if ((model.getMinimum() != null) && (newValue.compareTo(model.getMinimum()) < 0)) {
            return model.getMinimum();
        }
        if ((model.getMaximum() != null) && (newValue.compareTo(model.getMaximum()) > 0)) {
            return model.getMaximum();
        }
        return newValue;
    }
}

class IntegerStepper extends ExtendedStepper<Integer> {

        @Override
        protected Comparable getWithStep(Integer currentValue, Integer step, int signal) {
            return currentValue + signal * step;
        }

        @Override
        protected Comparable getWithNoStep(Integer currentValue, int signal, Integer modelStep, Integer min, Integer max) {
            int step = ((min != null) && (max != null)) ? ((max - min) / 10) : 10 * ((Integer) modelStep);
            return currentValue + signal * step;
        }
    }

    class DoubleStepper extends ExtendedStepper<Double> {

        @Override
        protected Comparable getWithStep(Double currentValue, Double step, int signal) {
            return currentValue + signal * step;
        }

        @Override
        protected Comparable getWithNoStep(Double currentValue, int signal, Double modelStep, Double min, Double max) {
            double step = ((min != null) && (max != null)) ? ((max - min) / 10) : 10 * modelStep;
            return currentValue + signal * step;
        }
    }