package com.github.jlarrieux.main.ValidationObject;



import com.github.jlarrieux.main.Constraints.AbstractContraint;
import com.github.jlarrieux.main.Validators.AbstractValidator;
import com.github.jlarrieux.main.components.Component;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class ValidationObject {
    Component component;
    AbstractValidator validator;
    AbstractContraint greaterThan;
    AbstractContraint lessThan;


    public ValidationObject(Component component, AbstractValidator validator){
        this.component = component;
        this.validator= validator;
    }

    public boolean isValid(){
        component.reset();
        boolean result= validator.isValid(component.getText());
        System.out.println("result inside validation object "+ result);
        if(!result)  component.invokeError();
        return result;
    }


    public String getError(){
        return validator.getErrorString();
    }



    public AbstractContraint getGreaterThan() {
        return greaterThan;
    }



    public void setGreaterThan(AbstractContraint greaterThan) {
        this.greaterThan = greaterThan;
    }



    public AbstractContraint getLessThan() {
        return lessThan;
    }



    public void setLessThan(AbstractContraint lessThan) {
        this.lessThan = lessThan;
    }
}
