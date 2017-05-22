package com.github.jlarrieux.main.Validators;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class PlainValidator extends AbstractValidator {


    @Override
    public boolean validate(String text) {
        return isNotEmpty(text);
    }



    @Override
    protected boolean numberValidation(String text) {
        return false;
    }
}
