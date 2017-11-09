package com.github.jlarrieux.main.ValidationObject;



import com.github.jlarrieux.main.Validator;
import javafx.scene.control.TextField;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class JavaFXValidationObject extends AbstractComponentValidationObject {
    TextField textField;

    public JavaFXValidationObject(TextField textField, String componentName, Validator.NumberType type){
        this.textField = textField;
        this.setName(componentName);
        this.setType(type);
    }



    public TextField getTextField() {
        return textField;
    }
}
