import com.github.jlarrieux.main.NumericValidator
import spock.lang.Specification
/**
 * Created by jlarrieux on 5/19/2017.
 */
class NumericValidatorJavaFxTest extends Specification{

    NumericValidator val;


    def setup(){
        val = new NumericValidator(NumericValidator.NumberType.INTEGER)
        val.allowPopUpOnError = false;
    }

//    def "validate an integer"(){
//        given:
//        TextField textField = new TextField()
//
//
//
//        expect:
//        textField.setText(String.valueOf(a))
//        b == val.validate(textField)
//
//        where:
//        a <<[1,2.0,'a',null,-1]
//        b <<[true, false, false, false,true]
//    }



}
