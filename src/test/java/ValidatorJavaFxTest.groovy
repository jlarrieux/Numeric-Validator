import com.github.jlarrieux.main.Validator
import spock.lang.Specification
/**
 * Created by jlarrieux on 5/19/2017.
 */
class ValidatorJavaFxTest extends Specification{

    Validator val;


    def setup(){
        val = new Validator(Validator.NumberType.INTEGER)
        val.setAllowPopUp(false);
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
