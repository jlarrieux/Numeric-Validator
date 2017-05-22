package com.github.jlarrieux.main.factory;



import com.github.jlarrieux.main.NumericValidator;
import com.github.jlarrieux.main.Validators.Validator;
import com.github.jlarrieux.main.components.Component;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public abstract class AbstractFactory {

    public abstract Component getComponent(NumericValidator.ComponentType componentType);
    public abstract Validator getValidator(NumericValidator.NumberType numberType);

}
