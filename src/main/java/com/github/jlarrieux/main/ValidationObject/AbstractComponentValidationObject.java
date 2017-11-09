package com.github.jlarrieux.main.ValidationObject;



import com.github.jlarrieux.main.Validator;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class AbstractComponentValidationObject {

    private String name;
    private Validator.NumberType type;



    public String getName() {
        return name;
    }



    protected void setName(String name) {
        this.name = name;
    }



    public Validator.NumberType getType() {
        return type;
    }



    protected void setType(Validator.NumberType type) {
        this.type = type;
    }
}
