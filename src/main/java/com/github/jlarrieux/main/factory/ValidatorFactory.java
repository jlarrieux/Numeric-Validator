package com.github.jlarrieux.main.factory;



import com.github.jlarrieux.main.NumericValidator;
import com.github.jlarrieux.main.Validators.DoubleValidator;
import com.github.jlarrieux.main.Validators.IntegerValidator;
import com.github.jlarrieux.main.Validators.PlainValidator;
import com.github.jlarrieux.main.Validators.Validator;
import com.github.jlarrieux.main.components.Component;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class ValidatorFactory extends AbstractFactory {


    @Override
    public Component getComponent(NumericValidator.ComponentType componentType) {
        return null;
    }



    @Override
    public Validator getValidator(NumericValidator.NumberType numberType) {
        if(numberType == NumericValidator.NumberType.DOUBLE) return new DoubleValidator();
        else if(numberType== NumericValidator.NumberType.INTEGER) return new IntegerValidator();
        else if(numberType== NumericValidator.NumberType.Plain) return new PlainValidator();
        return null;
    }
}
