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
<<<<<<< HEAD:src/test/java/ValidatorSwingTest.groovy
        b == val.validate(textField, Validator.NumberType.INTEGER, "B")
=======
        b == val.isValid(textField, "B", NumericValidator.NumberType.INTEGER)
>>>>>>> 90703b37038f73e3e0a566cff0abb31aaab02433:src/test/java/NumericValidatorSwingTest.groovy

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, false, false, false,true]
    }


    def "validate a double"(){
        given:

        JTextField textField = new JTextField()


        expect:
        textField.setText(String.valueOf(a))
<<<<<<< HEAD:src/test/java/ValidatorSwingTest.groovy
        b== val.validate(textField, Validator.NumberType.DOUBLE, "a")
=======
        b== val.isValid(textField, "a", NumericValidator.NumberType.DOUBLE)
>>>>>>> 90703b37038f73e3e0a566cff0abb31aaab02433:src/test/java/NumericValidatorSwingTest.groovy

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, true, false, false, true]
    }




















}
