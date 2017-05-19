package com.github.jlarrieux.main.demo;



import com.github.jlarrieux.main.NumericValidator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.event.ActionEvent.*;



/**
 * Created by jlarrieux on 5/19/2017.
 */
public class JavaFXDemo extends Application{

    private Stage primaryStage;
    TextField textField;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("root.fxml"));
        Scene scene = new Scene(root);
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        Initializer();

    }


    private void Initializer(){
        textField = (TextField) lookUp("#text");
        button = (Button) lookUp("#validate");

        button.addEventHandler(ACTION, event -> handleClick());
    }



    private void handleClick() {
        NumericValidator validator = new NumericValidator(NumericValidator.TypeOfNumber.DOUBLE);
        validator.validate(textField,primaryStage);
        System.out.println(validator.getErrorString());
    }



    protected Node lookUp(String name){
        return primaryStage.getScene().lookup(name);
    }

}
