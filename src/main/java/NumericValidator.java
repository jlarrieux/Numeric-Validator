import javax.swing.*;
import java.util.regex.Pattern;



/**
 * Created by jlarrieux on 5/11/2017.
 */
public class NumericValidator {


    private TypeOfNumber numericType;
    private validationType validationType;
    private JTextField currentTextField;
    private StringBuilder errorString= new StringBuilder();

    public  enum TypeOfNumber{
        DOUBLE, INTEGER
    }


    private enum validationType{
        JTEXTFIELD, TEXTFIELD
    }

    public NumericValidator(TypeOfNumber numericType){
        this.numericType = numericType;
    }



    public TypeOfNumber getNumericType() {
        return numericType;
    }


    public boolean validate(JTextField textField){
        currentTextField = textField;
        currentTextField.setBorder(UIManager.getBorder("TextField.border"));
        String text = textField.getText();
        boolean result = lengthValidation(text) && validateNumber(text);


        return result;
    }


    private boolean lengthValidation(String text){
        boolean result = text.length() !=0;
        if(!result) errorCompilation(MessagePOJO.NO_TEXT_ERROR);
        return result;
    }


    private boolean validateNumber(String text){
        if(numericType == TypeOfNumber.DOUBLE) return isNumericTypeDouble(text);
        else return isNumericTypeInteger(text);
    }

    private void errorCompilation(String text){
        if(errorString.toString().length()>0) errorString.append("\n");
        errorString.append(text);
    }

    private boolean isNumericTypeDouble(String text){

        if (Pattern.matches("^-?\\d*\\.?\\d*", text)) return true;
        else {
            errorCompilation(MessagePOJO.NOT_DOUBLE);
            return false;
        }
    }

    private boolean isNumericTypeInteger(String text){
        if (Pattern.matches("^-?\\d*$", text)) return true;
        else {
            errorCompilation(MessagePOJO.NOT_INT);
            return false;
        }
    }



    public String getErrorString() {
        return errorString.toString();
    }
}
