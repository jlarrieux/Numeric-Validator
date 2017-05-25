package com.github.jlarrieux.main.Validators;



import java.util.regex.Pattern;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class IntegerValidator extends AbstractValidator {


    @Override
    public boolean isValid(String text) {
        if (isNotEmpty(text) && numberValidation(text) ) return true;
        return false;
    }



    @Override
    public boolean numberValidation(String text) {
        if(Pattern.matches("^-?\\d*$", text) )return true;
        else{
            addError(NOT_INT);
            return false;
        }
    }
}
