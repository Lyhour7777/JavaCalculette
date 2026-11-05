package vue;

import java.util.List;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import contrôleur.CalculatorControler;

public class CalculatorGUI extends Scene implements CalculatorGUIInterface {

    private CalculatorControler controller;
    
    // UI components for screen display (4 stack lines + 1 accu line)
    private List<Label> stackLabels;
    private Label accuLabel;

    public CalculatorGUI(Parent root, double width, double height, CalculatorControler controller) {
        super(root, width, height);
        this.controller = controller;
        this.controller.setView(this);
    }

    public static CalculatorGUI createGUI(CalculatorControler controller) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        CalculatorGUI gui = new CalculatorGUI(root, 300, 450, controller);
        gui.buildUI(root);
        return gui;
    }

    private void buildUI(VBox root) {
        // --- 1. Screen Displays (Stack + Accumulator) ---
        VBox screenBox = new VBox(5);
        screenBox.setStyle("-fx-border-color: gray; -fx-padding: 5; -fx-background-color: #f4f4f4;");

        stackLabels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Label label = new Label("0.0");
            label.setMaxWidth(Double.MAX_VALUE);
            label.setAlignment(Pos.CENTER_RIGHT);
            label.setStyle("-fx-font-size: 14px; -fx-border-color: #dcdcdc; -fx-padding: 2;");
            stackLabels.add(label);
            screenBox.getChildren().add(label);
        }

        accuLabel = new Label("0");
        accuLabel.setMaxWidth(Double.MAX_VALUE);
        accuLabel.setAlignment(Pos.CENTER_RIGHT);
        accuLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-border-color: #a0a0a0; -fx-padding: 4;");
        screenBox.getChildren().add(accuLabel);

        // --- 2. Button Grid ---
        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setAlignment(Pos.CENTER);

        // Digit & Basic Buttons
        String[][] buttonLabels = {
            {"7", "8", "9", "+"},
            {"4", "5", "6", "-"},
            {"1", "2", "3", "*"},
            {"0", ".", "+/-", "/"},
            {"Push", "Pop", "Drop", "<>"}
        };

        for (int row = 0; row < buttonLabels.length; row++) {
            for (int col = 0; col < buttonLabels[row].length; col++) {
                String text = buttonLabels[row][col];
                Button btn = new Button(text);
                btn.setPrefSize(60, 40);

                // Attach event handlers to controller
                btn.setOnAction(e -> handleButtonClick(text));
                grid.add(btn, col, row);
            }
        }

        root.getChildren().addAll(screenBox, grid);
    }

    private void handleButtonClick(String text) {
        if (text.matches("[0-9]")) {
            controller.handleNumberInput(text);
        } else if (text.equals(".")) {
            controller.handleNumberInput(".");
        } else if (text.equals("+")) {
            controller.handleAdd();
        } else if (text.equals("-")) {
            controller.handleSubstract();
        } else if (text.equals("*")) {
            controller.handleMultiply();
        } else if (text.equals("/")) {
            controller.handleDivide();
        } else if (text.equals("+/-")) {
            controller.handleOpposite();
        } else if (text.equals("Push")) {
            controller.handlePush();
        } else if (text.equals("Pop")) {
            controller.handlePop();
        } else if (text.equals("Drop")) {
            controller.handleDrop();
        } else if (text.equals("<>")) {
            controller.handleSwap();
        }
    }

    @Override
    public void affiche() {
        // UI is displayed via JavaFX Stage launch
    }

    @Override
    public void change(String accu) {
        accuLabel.setText(accu);
    }

    @Override
    public void change(List<Double> stackData) {
        int size = stackData.size();
        for (int i = 0; i < 4; i++) {
            int stackIndex = size - 1 - i;
            if (stackIndex >= 0) {
                stackLabels.get(3 - i).setText(String.valueOf(stackData.get(stackIndex)));
            } else {
                stackLabels.get(3 - i).setText("");
            }
        }
    }
}