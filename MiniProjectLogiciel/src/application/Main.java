package application;

import javafx.application.Application;
import javafx.stage.Stage;
import modèle.CalculatorModel;
import contrôleur.CalculatorControler;
import vue.CalculatorGUI;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // 1. Instanciate Model logic
            CalculatorModel model = new CalculatorModel();

            // 2. Instanciate Controller
            CalculatorControler controller = new CalculatorControler(model);

            // 3. Instanciate View GUI
            CalculatorGUI gui = CalculatorGUI.createGUI(controller);

            // 4. Configure window
            primaryStage.setTitle("Ma calculette (RPN - MVC)");
            primaryStage.setScene(gui);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}