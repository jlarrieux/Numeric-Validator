import com.github.jlarrieux.main.MessagePOJO
import com.github.jlarrieux.main.NumericValidator
import spock.lang.Specification

import javax.swing.*
/**
 * Created by jlarrieux on 5/11/2017.
 */
class NumericValidatorSwingTest extends Specification{

    NumericValidator val;

    def setup(){
        val = new NumericValidator(NumericValidator.NumberType.INTEGER)
        val.allowPopUpOnError = false;
    }

    def "validate an integer"(){
        given:
        JTextField textField = new JTextField()


        expect:
        textField.setText(String.valueOf(a))
        b == val.validate(textField)

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, false, false, false,true]
    }


    def "validate a double"(){
        given:
        val.setNumericType(NumericValidator.NumberType.DOUBLE)
        JTextField textField = new JTextField()


        expect:
        textField.setText(String.valueOf(a))
        b== val.validate(textField)

        where:
        a <<[1,2.0,'a',null,-1]
        b <<[true, true, false, false, true]
    }


    def "get the correct error when not an Int"(){
        given:
        def a = 'a'
        JTextField textField = new JTextField(a)


        when:
        val.validate(textField)


        then:
        val.getErrorString() == MessagePOJO.NOT_INT

    }




    def "get correct error when not a Double"(){
        given:
        val.setNumericType(NumericValidator.NumberType.DOUBLE)
        def b = 'b'
        JTextField textField = new JTextField(b)

        when:
        val.validate(textField)

        then:
        val.getErrorString()==MessagePOJO.NOT_DOUBLE
    }



    def "get correct error when no text"(){
        given:
        val.setNumericType(NumericValidator.NumberType.DOUBLE)
        JTextField textField = new JTextField()

        when:
        val.validate(textField)

        then:
        val.getErrorString()==MessagePOJO.NO_TEXT_ERROR
    }
















}
