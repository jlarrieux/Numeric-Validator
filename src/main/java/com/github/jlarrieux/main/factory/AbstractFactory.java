package com.github.jlarrieux.main.factory;



import com.github.jlarrieux.main.Validator;
import com.github.jlarrieux.main.components.Component;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public abstract class AbstractFactory {

    public abstract Component getComponent(Validator.ComponentType componentType);
    public abstract com.github.jlarrieux.main.Validators.Validator getValidator(Validator.NumberType numberType);

}
