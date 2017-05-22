package com.github.jlarrieux.main.ValidationObject;



import com.github.jlarrieux.main.NumericValidator;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class AbstractComponentValidationObject {

    private String name;
    private NumericValidator.NumberType type;



    public String getName() {
        return name;
    }



    protected void setName(String name) {
        this.name = name;
    }



    public NumericValidator.NumberType getType() {
        return type;
    }



    protected void setType(NumericValidator.NumberType type) {
        this.type = type;
    }
}
