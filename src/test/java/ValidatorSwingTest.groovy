import com.github.jlarrieux.main.Validator
import spock.lang.Specification

import javax.swing.*
/**
 * Created by jlarrieux on 5/11/2017.
 */
class ValidatorSwingTest extends Specification{

    Validator val;

    def setup(){
        val = new Validator()
        val.setAllowPopUp( false);
    }

    def "validate an integer"(){
        given:
        JTextField textField = new JTextField()


        expect:
        textField.setText(String.valueOf(a))
        b == val.validate(textField, Validator.NumberType.INTEGER, "B")

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, false, false, false,true]
    }


    def "validate a double"(){
        given:

        JTextField textField = new JTextField()


        expect:
        textField.setText(String.valueOf(a))
        b== val.validate(textField, Validator.NumberType.DOUBLE, "a")

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, true, false, false, true]
    }




















}
