package com.github.jlarrieux.main.ValidationObject;



import com.github.jlarrieux.main.NumericValidator;

import javax.swing.*;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class SwingValidationObject extends AbstractComponentValidationObject {

    JTextField textField;


    public SwingValidationObject(JTextField textField, String componentName, NumericValidator.NumberType type){
        this.textField = textField;
        this.setName(componentName);
        this.setType(type);
    }



    public JTextField getTextField() {
        return textField;
    }
}
