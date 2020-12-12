package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        // Variables
         Deque coolNames = new Deque();
//        int desiredCapacity;

        // Text
        Text topDescription = new Text("Array-Based Deque");
        topDescription.setFont(new Font("Verdana", 20));
        topDescription.setFill(Color.BLACK);

        // Label for Array Elements
        Label arrayDequeDisplayLabel = new Label();

        VBox topDescriptionAndDequeDisplayVBox = new VBox(10, topDescription, arrayDequeDisplayLabel);
        topDescriptionAndDequeDisplayVBox.setAlignment(Pos.CENTER);
        topDescriptionAndDequeDisplayVBox.setPadding(new Insets(10));


        // enterACapacity controls
        Label enterACapacityLabel = new Label("Enter a Capacity amount: ");
        TextField enterACapacityTextField = new TextField();
        Button confirmButton = new Button("Confirm");




        HBox enterACapacityHBox = new HBox(10, enterACapacityLabel, enterACapacityTextField, confirmButton );
        enterACapacityHBox.setAlignment(Pos.CENTER);
        enterACapacityHBox.setPadding(new Insets(10));

        // Button Event Handling
        confirmButton.setOnAction(e->
        {
            // Create an instance of deque
            final int desiredCapacity = Integer.parseInt(enterACapacityTextField.getText());
            coolNames.setCapacity(desiredCapacity);

        });

        // addFront controls
        Button addFrontButton = new Button("addFront");
        TextField addFrontTextField = new TextField();

        addFrontButton.setOnAction(e->
        {
            // Create an instance of deque
            String inputValue  = addFrontTextField.getText();
            coolNames.addFront(inputValue);

            arrayDequeDisplayLabel.setText(coolNames.toString());

        });


        HBox addFrontHBox = new HBox(10, addFrontButton, addFrontTextField);
        addFrontHBox.setAlignment(Pos.CENTER);
        addFrontHBox.setPadding(new Insets(10));

        // removeFront controls
        Button removeFrontButton = new Button("removeFront");
        TextField removeFrontTextField = new TextField();

        removeFrontButton.setOnAction(e->
        {
            // call removeFront method and update removeFrontTextField
            removeFrontTextField.setText(coolNames.removeFront());

            // update arrayDequeDisplayLabel
            arrayDequeDisplayLabel.setText(coolNames.toString());
        });

        HBox removeFrontHBox = new HBox(10, removeFrontButton, removeFrontTextField);
        removeFrontHBox.setAlignment(Pos.CENTER);
        removeFrontHBox.setPadding(new Insets(10));




        // addRear controls
        Button addRearButton = new Button("addRear");
        TextField addRearTextField = new TextField();

        addRearButton.setOnAction(e->
        {
            // Create an instance of deque
            String inputValue  = addRearTextField.getText();
            coolNames.addRear(inputValue);

            arrayDequeDisplayLabel.setText(coolNames.toString());

        });

        HBox addRearHBox = new HBox(10, addRearButton, addRearTextField);
        addRearHBox.setAlignment(Pos.CENTER);
        addRearHBox.setPadding(new Insets(10));

        // removeRear
        Button removeRearButton = new Button("removeRear");
        TextField removeRearTextField = new TextField();

        removeRearButton.setOnAction(e->
        {
            // call removeRear method and update removeRearTextfield
            removeRearTextField.setText(coolNames.removeRear());

            // update arrayDequeDisplayLabel
            arrayDequeDisplayLabel.setText(coolNames.toString());


        });

        HBox removeRearHBox = new HBox(10, removeRearButton, removeRearTextField);
        removeRearHBox.setAlignment(Pos.CENTER);
        removeRearHBox.setPadding(new Insets(10));

        VBox allControlsVBox = new VBox(10, topDescriptionAndDequeDisplayVBox,  enterACapacityHBox, addFrontHBox, addRearHBox, removeFrontHBox, removeRearHBox);
        allControlsVBox.setAlignment(Pos.CENTER);
        allControlsVBox.setPadding(new Insets(10));


        // Scene
        Scene scene = new Scene(allControlsVBox, 500, 500);

        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chapter 20 Problem 2");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
