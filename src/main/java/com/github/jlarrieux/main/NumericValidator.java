package com.github.jlarrieux.main;



import com.github.jlarrieux.main.ValidationObject.AbstractComponentValidationObject;
import com.github.jlarrieux.main.ValidationObject.JavaFXValidationObject;
import com.github.jlarrieux.main.ValidationObject.SwingValidationObject;
import com.github.jlarrieux.main.ValidationObject.ValidationObject;
import com.github.jlarrieux.main.Validators.AbstractValidator;
import com.github.jlarrieux.main.components.JavaFX;
import com.github.jlarrieux.main.components.Swing;
import com.github.jlarrieux.main.factory.AbstractFactory;
import com.github.jlarrieux.main.factory.FactoryProducer;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class NumericValidator {

    private  AbstractFactory componentFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.COMPONENT);
    private  AbstractFactory validatorFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.VALIDATOR);
    private Multimap<String, String> errorList = ArrayListMultimap.create();
    private boolean allowPopUp = true;
    private ComponentType componentType;

    public  enum NumberType {
        DOUBLE, INTEGER, Plain
    }


    public enum ComponentType {
        SWING, JAVAFX
    }


    public boolean isValid(JTextField textField, String componentName, NumberType type){
        componentType  = ComponentType.SWING;
        Swing swing = (Swing)  componentFactory.getComponent(componentType);
        swing.setTextField(textField);
        ValidationObject object = new ValidationObject(swing,(AbstractValidator) validatorFactory.getValidator(type));
        boolean result = object.isValid();
        interpretResult(componentName, object.getError(), result);
        return result;

    }


    public boolean isValid(TextField textField, String componentName, NumberType type){
        componentType  = ComponentType.JAVAFX;
        JavaFX fx = (JavaFX) componentFactory.getComponent(componentType);
        fx.setTextField(textField);
        ValidationObject object = new ValidationObject(fx,(AbstractValidator) validatorFactory.getValidator(type));
        boolean result = object.isValid();
        interpretResult(componentName, object.getError(), result);

        return result;
    }



    private void interpretResult(String componentName, String error, boolean result) {
        if(!result){
            errorList.put(componentName, error);
            if(allowPopUp) createErrorDialog();
        }
    }



    public boolean isValid(SwingValidationObject swingValidationObject){
        boolean result = isValid(swingValidationObject.getTextField(), swingValidationObject.getName(), swingValidationObject.getType());

        return result;

    }

    public boolean isValid(JavaFXValidationObject javaFXValidationObject){
        return isValid(javaFXValidationObject.getTextField(), javaFXValidationObject.getName(), javaFXValidationObject.getType());
    }


    public boolean isValid(ArrayList<AbstractComponentValidationObject> swingList){
        setAllowPopUp(false);
        int i=0;
        boolean  result = false;
        for(AbstractComponentValidationObject validationObject: swingList){
            if(validationObject instanceof JavaFXValidationObject) result = isValid((JavaFXValidationObject)validationObject);
            else if(validationObject instanceof SwingValidationObject) result = isValid((SwingValidationObject) validationObject);

            if(!result) i++;
        }


        setAllowPopUp(true);
        if(i>0) createErrorDialog();
        return i>0;

    }




    public void setAllowPopUp(boolean allowPopUp) {
        this.allowPopUp = allowPopUp;
    }





    private String generateErrorList(){
        StringBuffer buffer = new StringBuffer();

        for(String k: errorList.keySet()){
            if(buffer.toString().length()>0) buffer.append("\n\n\n");
            buffer.append(k+":\n");
            for(String s: errorList.get(k)) buffer.append("   -"+s+"\n");
        }


        return buffer.toString();
    }




    private void createErrorDialog() {

        if(componentType==ComponentType.SWING) JOptionPane.showMessageDialog(null,generateErrorList(),"Error",JOptionPane.ERROR_MESSAGE );
        else if(componentType==ComponentType.JAVAFX) javaFXalert().showAndWait();
    }


    private Alert javaFXalert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText("Please correct the following error(s)");
        alert.setContentText(generateErrorList());
        return alert;
    }


}
