package com.github.jlarrieux.main.ValidationObject;



import com.github.jlarrieux.main.Constraints.AbstractContraint;
import com.github.jlarrieux.main.NumericValidator;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class AbstractComponentValidationObject {

    private String name;
    private NumericValidator.NumberType type;
    AbstractContraint greaterThan;
    AbstractContraint lessThan;



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
