package com.github.jlarrieux.main.Validators;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public abstract class AbstractValidator implements Validator {

    public static final String NO_TEXT_ERROR = "No text";
    public static final String NOT_INT = "Not of Expected type int";
    public static final String NOT_DOUBLE = "Not of Expected type double";

    protected StringBuilder errorString = new StringBuilder();

    protected abstract boolean numberValidation(String text);

    protected boolean isNotEmpty(String text){
        if(text.length()!=0) return true;
        else{
            errorString.append(NO_TEXT_ERROR);
            return false;
        }
    }

    protected void addError(String error){
        if(errorString.toString().length()>0)errorString.append("\n");
        errorString.append(error);
    }



    public String getErrorString() {
        return errorString.toString();
    }
}
