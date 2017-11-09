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
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.ArrayList;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class Validator {

    private  AbstractFactory componentFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.COMPONENT);
    private  AbstractFactory validatorFactory = FactoryProducer.getFactory(FactoryProducer.FactoryType.VALIDATOR);
    private Multimap<String, String> errorList = ArrayListMultimap.create();
    private boolean allowPopUp = true;

    public  enum NumberType {
        DOUBLE, INTEGER, Plain
    }


    public enum ComponentType {
        SWING, JAVAFX
    }


    public boolean validate(JTextField textField, Validator.NumberType type, String componentName, Integer... numberOfCharacter){

        Swing swing = (Swing)  componentFactory.getComponent(ComponentType.SWING);
        swing.setTextField(textField);
        ValidationObject object = new ValidationObject(swing,(AbstractValidator) validatorFactory.getValidator(type));
        boolean result = object.validate();
        interpretResult(componentName, object.getError(), result);
        return object.validate();

    }


    public boolean validate(TextField textField, Validator.NumberType type, String componentName, Integer... numberOfCharacter){

        JavaFX fx = (JavaFX) componentFactory.getComponent(Validator.ComponentType.JAVAFX);
        fx.setTextField(textField);
        ValidationObject object = new ValidationObject(fx,(AbstractValidator) validatorFactory.getValidator(type));
        boolean result = object.validate();
        interpretResult(componentName, object.getError(), result);

        return result;
    }



    private void interpretResult(String componentName, String error, boolean result) {
        if(!result){
            errorList.put(componentName, error);
            if(allowPopUp) createErrorDialog();
        }
    }



    public boolean validate(SwingValidationObject swingValidationObject){
        return validate(swingValidationObject.getTextField(),swingValidationObject.getType(),swingValidationObject.getName());

    }

    public boolean validate(JavaFXValidationObject javaFXValidationObject){
        return validate(javaFXValidationObject.getTextField(),javaFXValidationObject.getType(),javaFXValidationObject.getName());
    }


    public boolean validate(ArrayList<AbstractComponentValidationObject> swingList){
        setAllowPopUp(false);
        int i=0;
        boolean  result = false;
        for(AbstractComponentValidationObject validationObject: swingList){
            if(validationObject instanceof JavaFXValidationObject) result = validate((JavaFXValidationObject)validationObject);
            else if(validationObject instanceof SwingValidationObject) result = validate((SwingValidationObject) validationObject);

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

        JOptionPane.showMessageDialog(null,generateErrorList(),"Error",JOptionPane.ERROR_MESSAGE );
    }





}
