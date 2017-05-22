# Numeric-Validator
Validate numeric input (int or double) for Java GUI (Swing and JavaFX)


# Usage
## Gradle
import the project from maven as follow:

```compile 'com.github.jlarrieux:numeric-validator:1.+'```

## Maven

```
<dependency>
   <groupId>com.github.jlarrieux</groupId>
   <artifactId>numeric-validator</artifactId>
   <version>1.0.2</version>
</dependency>
```


# Example
## Java Swing

```NumericValidator validator = new NumericValidator(NumericValidator.TypeOfNumber.DOUBLE);
boolean result = validator.validate(textField);```


## Java FX

For JavaFX, you must add the `RedBorder.css` to your project and call the code as follow

```dialogStage.getScene().getStylesheets().add(getClass().getResource("/css/RedBorder.css").toExternalForm());
NumericValidator val = new NumericValidator(NumericValidator.TypeOfNumber.INTEGER);
boolean result = validator.validate(textField);```
If you don't have the css, it won't highlight the appropriate input in red.

        
     




