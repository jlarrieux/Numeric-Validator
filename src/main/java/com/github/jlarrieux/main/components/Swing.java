package com.github.jlarrieux.main.components;



import javax.swing.*;
import java.awt.*;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class Swing extends AbstractComponent {

    public Swing(){

    }

    @Override
    public void invokeError() {
        swingTextField.setBorder(BorderFactory.createLineBorder(Color.red, 2));
    }



    @Override
    public void reset() {
        swingTextField.setBorder(UIManager.getBorder("textField.border"));
    }


    public void setTextField(JTextField textField){
        swingTextField = textField;
    }



    @Override
    public String getText() {
        return swingTextField.getText();
    }
}
