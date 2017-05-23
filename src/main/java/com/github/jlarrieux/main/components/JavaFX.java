package com.github.jlarrieux.main.components;



import javafx.scene.control.TextField;



/**
 * Created by jlarrieux on 5/22/2017.
 */
public class JavaFX extends AbstractComponent {

    private static final String ERROR = "-fx-focus-color: #d35244; " +
                                        "-fx-faint-focus-color: #d3524422; " +
                                        "-fx-highlight-fill: -fx-accent; " +
                                        "-fx-highlight-text-fill: white; " +
                                        "-fx-background-color: " +
                                        "-fx-focus-color, " +
                                        "-fx-control-inner-background, " +
                                        "-fx-faint-focus-color, " +
                                        "linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background); " +
                                        "-fx-background-insets: -0.2, 1, -1.4, 3; " +
                                        "-fx-background-radius: 3, 2, 4, 0; " +
                                        "-fx-prompt-text-fill: transparent;";

    public JavaFX(){

    }



    @Override
    public String getText() {
        return fxTextField.getText();
    }



    @Override
    public void invokeError() {
        System.out.println("invoking error");
        createErrorStyle();
    }



    @Override
    public void reset() {
        fxTextField.setStyle(null);
    }

    private void createErrorStyle(){
        System.out.println("style was:"+fxTextField.getStyle());
        fxTextField.setStyle(ERROR);
    }




    public void setTextField(TextField textField) {
        fxTextField = textField;
    }
}
