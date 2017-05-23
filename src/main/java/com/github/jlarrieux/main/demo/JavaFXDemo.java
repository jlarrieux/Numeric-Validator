package com.github.jlarrieux.main.demo;



import com.github.jlarrieux.main.NumericValidator;
import com.github.jlarrieux.main.ValidationObject.AbstractComponentValidationObject;
import com.github.jlarrieux.main.ValidationObject.JavaFXValidationObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.event.ActionEvent.ACTION;



/**
 * Created by jlarrieux on 5/19/2017.
 */
public class JavaFXDemo extends Application{

    private Stage primaryStage;
    TextField textField, textField2;
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
        textField2 = (TextField) lookUp("#text2");
        button = (Button) lookUp("#validate");

        button.addEventHandler(ACTION, event -> handleClick());
    }



    private void handleClick() {
//        NumericValidator validator = new NumericValidator(NumericValidator.NumberType.DOUBLE);
//        validator.validate(textField,primaryStage);
//        System.out.println(validator.getErrorString());
        NumericValidator validator2 = new NumericValidator();
//        validator2.validate(textField, NumericValidator.NumberType.DOUBLE, "red");

        ArrayList<AbstractComponentValidationObject> list = new ArrayList<>();
        list.add(new JavaFXValidationObject(textField,"text1", NumericValidator.NumberType.DOUBLE));
        list.add(new JavaFXValidationObject(textField2, "text2", NumericValidator.NumberType.INTEGER));
        validator2.validate(list);
    }



    protected Node lookUp(String name){
        return primaryStage.getScene().lookup(name);
    }

}
