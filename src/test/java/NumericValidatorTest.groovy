import com.github.jlarrieux.main.NumericValidator
import spock.lang.Specification

/**
 * Created by jlarrieux on 5/19/2017.
 */
class NumericValidatorTest extends Specification{

    def "set type of Integer"(){
        given:
        NumericValidator val = new NumericValidator(a)

        expect:
        b == val.getNumericType()


        where:
        a<<[NumericValidator.TypeOfNumber.DOUBLE, NumericValidator.TypeOfNumber.INTEGER]
        b<<[NumericValidator.TypeOfNumber.DOUBLE, NumericValidator.TypeOfNumber.INTEGER]

    }
}
