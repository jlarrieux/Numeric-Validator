package com.github.jlarrieux.main.factory;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class FactoryProducer {
    public enum FactoryType{
        COMPONENT, VALIDATOR
    }

    public static AbstractFactory getFactory(FactoryType type){
        if(type ==FactoryType.COMPONENT) return new ComponentFactory();
        else if(type==FactoryType.VALIDATOR) return new ValidatorFactory();
        return null;

    }


}
