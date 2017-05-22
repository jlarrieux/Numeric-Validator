package com.github.jlarrieux.main.factory;



import com.github.jlarrieux.main.NumericValidator;
import com.github.jlarrieux.main.Validators.Validator;
import com.github.jlarrieux.main.components.Component;
import com.github.jlarrieux.main.components.JavaFX;
import com.github.jlarrieux.main.components.Swing;
import javafx.scene.control.TextField;

import javax.swing.*;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class ComponentFactory extends AbstractFactory {





    @Override
    public Component getComponent(NumericValidator.ComponentType componentType) {
        if(componentType == NumericValidator.ComponentType.JAVAFX) return new JavaFX();
        else if(componentType == NumericValidator.ComponentType.SWING) return new Swing();
        return null;
    }

    public Component getComponent(JTextField textField){
        Swing swing = new Swing();
        swing.setTextField(textField);
        return swing;
    }

    public Component getComponent(TextField textField){
        JavaFX fx = new JavaFX();
        fx.setTextField(textField);
        return fx;
    }


    @Override
    public Validator getValidator(NumericValidator.NumberType numberType) {
        return null;
    }
}
