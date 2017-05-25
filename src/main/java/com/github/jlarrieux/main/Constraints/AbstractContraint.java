package com.github.jlarrieux.main.Constraints;



/**
 * Created by Jeannius on 5/24/2017.
 */
public class AbstractContraint {


    Number value;
    ConstraintType type;

    public enum ConstraintType{
        GREATER_THAN, LESS_THAN
    }


    public Number getValue(){
        return value;
    }

    public ConstraintType getType(){
        return type;
    }

}
