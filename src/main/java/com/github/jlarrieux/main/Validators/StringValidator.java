package com.github.jlarrieux.main.Validators;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class StringValidator extends AbstractValidator {

    private int numberOfCharacterMin, numberOfCharacterMax;

    @Override
    public boolean isValid(String text) {
        return isNotEmpty(text);
    }



    @Override
    protected boolean numberValidation(String text) {
        return false;
    }
}
