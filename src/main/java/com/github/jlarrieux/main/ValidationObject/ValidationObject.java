package com.github.jlarrieux.main.ValidationObject;



import com.github.jlarrieux.main.Validators.AbstractValidator;
import com.github.jlarrieux.main.components.Component;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class ValidationObject {
    Component component;
    AbstractValidator validator;

    public ValidationObject(Component component, AbstractValidator validator){
        this.component = component;
        this.validator= validator;
    }

    public boolean validate(){
        component.reset();
        boolean result= validator.validate(component.getText());
        if(!result)  component.invokeError();
        return result;
    }


    public String getError(){
        return validator.getErrorString();
    }


}
