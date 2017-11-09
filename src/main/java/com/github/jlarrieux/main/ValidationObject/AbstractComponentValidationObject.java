package com.github.jlarrieux.main.ValidationObject;



<<<<<<< HEAD
import com.github.jlarrieux.main.Validator;
=======
import com.github.jlarrieux.main.Constraints.AbstractContraint;
import com.github.jlarrieux.main.NumericValidator;
>>>>>>> 90703b37038f73e3e0a566cff0abb31aaab02433



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class AbstractComponentValidationObject {

    private String name;
<<<<<<< HEAD
    private Validator.NumberType type;
=======
    private NumericValidator.NumberType type;
    AbstractContraint greaterThan;
    AbstractContraint lessThan;
>>>>>>> 90703b37038f73e3e0a566cff0abb31aaab02433



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
