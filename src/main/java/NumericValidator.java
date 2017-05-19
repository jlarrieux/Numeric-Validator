package com.github.jlarrieux.main;



import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;



/**
 * Created by jlarrieux on 5/11/2017.
 */
public class NumericValidator {


    public static final String ERROR = "error";
    private TypeOfNumber numericType;
    private validationType vType;
    private JTextField currentTextField;
    private StringBuilder errorString= new StringBuilder();
    private TextField textField;
    public static final String RED_BORDER_CSS = "/RedBorder.css";
    public boolean allowPopUpOnError=true;


    public  enum TypeOfNumber{
        DOUBLE, INTEGER
    }


    private enum validationType{
        SWING, JAVAFX
    }

    public NumericValidator(TypeOfNumber numericType){
        this.numericType = numericType;
    }



    public TypeOfNumber getNumericType() {
        return numericType;
    }



    public void setAllowPopUpOnError(boolean allowPopUpOnError) {
        this.allowPopUpOnError = allowPopUpOnError;
    }



    public boolean validate(JTextField textField){
        vType = validationType.SWING;
        currentTextField = textField;
        errorString = new StringBuilder();
        currentTextField.setBorder(UIManager.getBorder("TextField.border"));
        String text = textField.getText();
        boolean result= lengthValidation(text) && validateNumber(text);
        invokeError();

        return result;
    }

    public boolean validate(TextField textField, Stage dialogStage){
        vType = validationType.JAVAFX;
        this.textField = textField;
        errorString = new StringBuilder();
        dialogStage.getScene().getStylesheets().add(getClass().getResource(RED_BORDER_CSS).toExternalForm());
        this.textField.getStyleClass().remove(ERROR);
        String text = textField.getText();
        boolean result = lengthValidation(text) && validateNumber(text);
        invokeError();
        return result;

    }


    private boolean lengthValidation(String text){
        boolean result = text.length() !=0;
        if(!result) errorCompilation(MessagePOJO.NO_TEXT_ERROR);
        return result;
    }


    private boolean validateNumber(String text){
        if(numericType == TypeOfNumber.DOUBLE) return isNumericTypeDouble(text);
        else return isNumericTypeInteger(text);
    }

    private void errorCompilation(String text){
        if(errorString.toString().length()>0) errorString.append("\n");
        errorString.append(text);
    }

    private boolean isNumericTypeDouble(String text){

        if (Pattern.matches("^-?\\d*\\.?\\d*", text)) return true;
        else {
            errorCompilation(MessagePOJO.NOT_DOUBLE);
            return false;
        }
    }

    private boolean isNumericTypeInteger(String text){
        if (Pattern.matches("^-?\\d*$", text)) return true;
        else {
            errorCompilation(MessagePOJO.NOT_INT);
            return false;
        }
    }

    private void invokeError(){
        if(errorString.toString().length()>0){
            if(vType== validationType.JAVAFX) javaFxError();
            else if(vType==validationType.SWING)swingError();
        }
    }


    private void javaFxError(){
        textField.getStyleClass().add(ERROR);
        if(allowPopUpOnError) createErrorDialog();

    }




    private void swingError(){
        currentTextField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        if(allowPopUpOnError) createErrorDialog();
    }



    private void createErrorDialog() {
        JOptionPane.showMessageDialog(null,errorString.toString(),"Error",JOptionPane.ERROR_MESSAGE );
    }



    public String getErrorString() {
        return errorString.toString();
    }
}
