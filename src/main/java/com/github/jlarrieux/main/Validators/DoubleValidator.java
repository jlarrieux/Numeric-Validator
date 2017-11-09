package com.github.jlarrieux.main.Validators;



import java.util.regex.Pattern;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class DoubleValidator extends AbstractValidator {


    @Override
    public boolean isValid(String text) {
        if(isNotEmpty(text) && numberValidation(text)) return true;
        return false;
    }



    @Override
    public boolean numberValidation(String text) {
        if(Pattern.matches("^-?\\d*\\.?\\d*", text) )return true;
        else{
            addError(NOT_DOUBLE);
            return false;
        }
    }
}
