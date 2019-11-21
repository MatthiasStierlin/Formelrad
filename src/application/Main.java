package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Formulawheel Application
 *
 * @author Carlo Schmid, Matthias Stierlin
 * @version 21.11.2019
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Pane root = new Pane();

            // Creating an image
            Image image = new Image(getClass().getResourceAsStream("formulawheelElectronic.gif"));
            ImageView imageView = new ImageView(image);
            imageView.setX(10);
            imageView.setY(10);
            imageView.setFitHeight(300);
            imageView.setFitWidth(300);
            imageView.setPreserveRatio(true);
            root.getChildren().add(imageView);

            Label lbPower = new Label("Power:");
            lbPower.relocate(10, 285);
            lbPower.setFont(Font.font(15));
            root.getChildren().add(lbPower);

            TextField txPower = new TextField();
            txPower.relocate(100, 285);
            txPower.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txPower);

            Label lblVoltage = new Label("Voltage:");
            lblVoltage.relocate(10, 325);
            lblVoltage.setFont(Font.font(15));
            root.getChildren().add(lblVoltage);

            TextField txVoltage = new TextField();
            txVoltage.relocate(100, 325);
            txVoltage.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txVoltage);

            Label lblCurrent = new Label("Current:");
            lblCurrent.relocate(10, 365);
            lblCurrent.setFont(Font.font(15));
            root.getChildren().add(lblCurrent);

            TextField txCurrent = new TextField();
            txCurrent.relocate(100, 365);
            txCurrent.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txCurrent);

            Label lblResistance = new Label("Resistance:");
            lblResistance.relocate(10, 405);
            lblResistance.setFont(Font.font(15));
            root.getChildren().add(lblResistance);

            TextField txResistance = new TextField();
            txResistance.relocate(100, 405);
            txResistance.setFont(Font.font("Verdana", 15));
            root.getChildren().add(txResistance);

            Button btnCalculate = new Button();
            btnCalculate.relocate(100, 445);
            btnCalculate.setText("Calculate");
            root.getChildren().add(btnCalculate);

            Button btnReset = new Button();
            btnReset.relocate(200, 445);
            btnReset.setText("Reset");
            root.getChildren().add(btnReset);

            btnCalculate.setOnAction(e -> {
                        double power = 0.0;
                        double tension = 0.0;
                        double current = 0.0;
                        double resistance = 0.0;
                        txPower.setStyle("-fx-text-inner-color: red;");
                        txVoltage.setStyle("-fx-text-inner-color: red;");
                        txCurrent.setStyle("-fx-text-inner-color: red;");
                        txResistance.setStyle("-fx-text-inner-color: red;");
                        if (!txPower.getText().trim().isEmpty()) {
                            power = Double.parseDouble(txPower.getText());
                            txPower.setStyle("-fx-text-inner-color: black;");
                        }
                        if (!txVoltage.getText().trim().isEmpty()) {
                            tension = Double.parseDouble(txVoltage.getText());
                            txVoltage.setStyle("-fx-text-inner-color: black;");
                        }
                        if (!txCurrent.getText().trim().isEmpty()) {
                            current = Double.parseDouble(txCurrent.getText());
                            txCurrent.setStyle("-fx-text-inner-color: black;");
                        }
                        if (!txResistance.getText().trim().isEmpty()) {
                            resistance = Double.parseDouble(txResistance.getText());
                            txResistance.setStyle("-fx-text-inner-color: black;");
                        }
                        Calculator myCalculator = new Calculator(power, tension, current, resistance);
                        myCalculator.calculate();
                        if (myCalculator.getTooManyValues()) {
                            txPower.setText("Bitte nur zwei Werte");
                            txVoltage.clear();
                            txCurrent.clear();
                            txResistance.clear();
                            return;
                        }

                        txPower.setText(Double.toString(myCalculator.getPower()));
                        txVoltage.setText(Double.toString(myCalculator.getVoltage()));
                        txCurrent.setText(Double.toString(myCalculator.getCurrent()));
                        txResistance.setText(Double.toString(myCalculator.getResistance()));
                    }

            );

            btnReset.setOnAction(e -> {
                txPower.setText("");
                txVoltage.setText("");
                txCurrent.setText("");
                txResistance.setText("");
            });


            Scene scene = new Scene(root, 330, 490);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Formula Wheel");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
