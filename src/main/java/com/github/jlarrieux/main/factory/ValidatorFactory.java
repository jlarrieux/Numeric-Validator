package com.github.jlarrieux.main.factory;



import com.github.jlarrieux.main.Validator;
import com.github.jlarrieux.main.Validators.DoubleValidator;
import com.github.jlarrieux.main.Validators.IntegerValidator;
import com.github.jlarrieux.main.Validators.StringValidator;
import com.github.jlarrieux.main.components.Component;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class ValidatorFactory extends AbstractFactory {


    @Override
    public Component getComponent(Validator.ComponentType componentType) {
        return null;
    }



    @Override
    public com.github.jlarrieux.main.Validators.Validator getValidator(Validator.NumberType numberType) {
        if(numberType == Validator.NumberType.DOUBLE) return new DoubleValidator();
        else if(numberType== Validator.NumberType.INTEGER) return new IntegerValidator();
        else if(numberType== Validator.NumberType.Plain) return new StringValidator();
        return null;
    }
}
