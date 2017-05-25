import com.github.jlarrieux.main.NumericValidator
import spock.lang.Specification

import javax.swing.*
/**
 * Created by jlarrieux on 5/11/2017.
 */
class NumericValidatorSwingTest extends Specification{

    NumericValidator val;

    def setup(){
        val = new NumericValidator()
        val.setAllowPopUp( false);
    }

    def "validate an integer"(){
        given:
        JTextField textField = new JTextField()


        expect:
        textField.setText(String.valueOf(a))
        b == val.validate(textField, "B", NumericValidator.NumberType.INTEGER)

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, false, false, false,true]
    }


    def "validate a double"(){
        given:

        JTextField textField = new JTextField()


        expect:
        textField.setText(String.valueOf(a))
        b== val.validate(textField, "a", NumericValidator.NumberType.DOUBLE)

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, true, false, false, true]
    }




















}
