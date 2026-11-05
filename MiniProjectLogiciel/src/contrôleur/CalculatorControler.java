package contrôleur;

import java.util.List;
import modèle.CalculatorModel;
import vue.CalculatorGUIInterface;

public class CalculatorControler implements CalculatorControlerInterface {
    
    private CalculatorModel model;
    private CalculatorGUIInterface view;

    public CalculatorControler(CalculatorModel model) {
        this.model = model;
    }

    public void setView(CalculatorGUIInterface view) {
        this.view = view;
    }

    // --- Actions triggered by user interface (GUI buttons) ---
    public void handleNumberInput(String digit) {
        if (model.getAccu().equals("0")) {
            model.setAccu(digit);
        } else {
            model.setAccu(model.getAccu() + digit);
        }
        notifyView();
    }

    public void handlePush() {
        model.push();
        notifyView();
    }

    public void handleAdd() {
        model.add();
        notifyView();
    }

    public void handleSubstract() {
        model.substract();
        notifyView();
    }

    public void handleMultiply() {
        model.multiply();
        notifyView();
    }

    public void handleDivide() {
        model.divide();
        notifyView();
    }

    public void handleOpposite() {
        model.opposite();
        notifyView();
    }

    public void handlePop() {
        model.pop();
        notifyView();
    }

    public void handleDrop() {
        model.drop();
        notifyView();
    }

    public void handleSwap() {
        model.swap();
        notifyView();
    }

    public void handleClear() {
        model.clear();
        notifyView();
    }

    // Helper method to update the View interface
    private void notifyView() {
        if (view != null) {
            change(model.getAccu());
            change(model.getMemory());
        }
    }

    // --- Callbacks implementation from CalculatorControlerInterface ---
    @Override
    public void change(String accu) {
        if (view != null) {
            view.change(accu);
        }
    }

    @Override
    public void change(List<Double> stackData) {
        if (view != null) {
            view.change(stackData);
        }
    }
}