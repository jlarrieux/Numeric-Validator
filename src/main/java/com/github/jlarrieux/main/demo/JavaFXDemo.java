package com.github.jlarrieux.main.demo;



import com.github.jlarrieux.main.Validator;
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
<<<<<<< HEAD
//        Validator validator = new Validator(Validator.NumberType.DOUBLE);
//        validator.validate(textField,primaryStage);
//        System.out.println(validator.getErrorString());
        Validator validator2 = new Validator();
//        validator2.validate(textField, Validator.NumberType.DOUBLE, "red");

        ArrayList<AbstractComponentValidationObject> list = new ArrayList<>();
        list.add(new JavaFXValidationObject(textField,"text1", Validator.NumberType.DOUBLE));
        list.add(new JavaFXValidationObject(textField2, "text2", Validator.NumberType.INTEGER));
        validator2.validate(list);
=======
//        NumericValidator validator = new NumericValidator(NumericValidator.NumberType.DOUBLE);
//        validator.isValid(textField,primaryStage);
//        System.out.println(validator.getErrorString());
        NumericValidator validator2 = new NumericValidator();
//        validator2.isValid(textField, NumericValidator.NumberType.DOUBLE, "red");

        ArrayList<AbstractComponentValidationObject> list = new ArrayList<>();
        list.add(new JavaFXValidationObject(textField,"text1", NumericValidator.NumberType.DOUBLE));
        list.add(new JavaFXValidationObject(textField2, "text2", NumericValidator.NumberType.INTEGER));
        boolean result=validator2.isValid(list);
        System.out.print(result);
>>>>>>> 90703b37038f73e3e0a566cff0abb31aaab02433
    }



    protected Node lookUp(String name){
        return primaryStage.getScene().lookup(name);
    }

}
