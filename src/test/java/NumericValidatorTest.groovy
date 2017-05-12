import javax.swing.JTextField

/**
 * Created by jlarrieux on 5/11/2017.
 */
class NumericValidatorTest  extends spock.lang.Specification{

    def "set type of Integer"(){
        given:
        NumericValidator val = new NumericValidator(a)

        expect:
        b == val.getNumericType()


        where:
        a<<[NumericValidator.TypeOfNumber.DOUBLE, NumericValidator.TypeOfNumber.INTEGER]
        b<<[NumericValidator.TypeOfNumber.DOUBLE, NumericValidator.TypeOfNumber.INTEGER]

    }



    def "validate an integer"(){
        given:
        NumericValidator val = new NumericValidator(NumericValidator.TypeOfNumber.INTEGER)
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
        NumericValidator val = new NumericValidator(NumericValidator.TypeOfNumber.DOUBLE)
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
        NumericValidator val = new NumericValidator(NumericValidator.TypeOfNumber.INTEGER)
        def a = 'a'
        JTextField textField = new JTextField(a)


        when:
        val.validate(textField)


        then:
        val.getErrorString() == MessagePOJO.NOT_INT

    }




    def "get correct error when not a Double"(){
        given:
        NumericValidator val = new NumericValidator(NumericValidator.TypeOfNumber.DOUBLE)
        def b = 'b'
        JTextField textField = new JTextField(b)

        when:
        val.validate(textField)

        then:
        val.getErrorString()==MessagePOJO.NOT_DOUBLE
    }



    def "get correct error when no text"(){
        given:
        NumericValidator val = new NumericValidator(NumericValidator.TypeOfNumber.DOUBLE)
        JTextField textField = new JTextField()

        when:
        val.validate(textField)

        then:
        val.getErrorString()==MessagePOJO.NO_TEXT_ERROR
    }















}
