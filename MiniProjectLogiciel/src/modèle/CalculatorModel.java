package modèle;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
    
    private Stack<Double> memory;
    private String accu;

    public CalculatorModel() {
        this.memory = new Stack<>();
        this.accu = "0";
    }

    public String getAccu() {
        return accu;
    }

    public void setAccu(String accu) {
        this.accu = accu;
    }

    public Stack<Double> getMemory() {
        return memory;
    }

    @Override
    public void push() {
        try {
            double val = Double.parseDouble(accu);
            memory.push(val);
            accu = "0";
        } catch (NumberFormatException e) {
            System.err.println("Invalid input in accumulator: " + accu);
        }
    }

    @Override
    public void add() {
        if (!memory.isEmpty()) {
            double op1 = memory.pop();
            double op2 = Double.parseDouble(accu);
            accu = String.valueOf(op1 + op2);
        }
    }

    @Override
    public void substract() {
        if (!memory.isEmpty()) {
            double op1 = memory.pop();
            double op2 = Double.parseDouble(accu);
            accu = String.valueOf(op1 - op2);
        }
    }

    @Override
    public void multiply() {
        if (!memory.isEmpty()) {
            double op1 = memory.pop();
            double op2 = Double.parseDouble(accu);
            accu = String.valueOf(op1 * op2);
        }
    }

    @Override
    public void divide() {
        if (!memory.isEmpty()) {
            double op2 = Double.parseDouble(accu);
            if (op2 == 0) {
                System.err.println("Error: Division by zero!");
                return;
            }
            double op1 = memory.pop();
            accu = String.valueOf(op1 / op2);
        }
    }

    @Override
    public void opposite() {
        try {
            double val = Double.parseDouble(accu);
            accu = String.valueOf(-val);
        } catch (NumberFormatException e) {
            System.err.println("Cannot invert non-numeric accu");
        }
    }

    @Override
    public void pop() {
        if (!memory.isEmpty()) {
            accu = String.valueOf(memory.pop());
        }
    }

    @Override
    public void drop() {
        if (!memory.isEmpty()) {
            memory.pop();
        }
    }

    @Override
    public void swap() {
        if (!memory.isEmpty()) {
            double topStack = memory.pop();
            double currentAccu = Double.parseDouble(accu);
            memory.push(currentAccu);
            accu = String.valueOf(topStack);
        }
    }

    @Override
    public void clear() {
        memory.clear();
        accu = "0";
    }
}