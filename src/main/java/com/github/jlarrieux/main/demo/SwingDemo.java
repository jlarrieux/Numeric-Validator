package com.github.jlarrieux.main.demo;



import com.github.jlarrieux.main.NumericValidator;
import com.github.jlarrieux.main.NumericValidator2;
import com.github.jlarrieux.main.ValidationObject.SwingValidationObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



/**
 * Created by jlarrieux on 5/19/2017.
 */
public class SwingDemo extends JFrame implements ActionListener {

    JTextField textField, textField2;

    public SwingDemo(){
        InitUI();
    }



    private void InitUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1, 15,15));

        setTitle("SwingDemo");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200,30));

        textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(200,30));

        panel.add(textField);
        panel.add(textField2);

        JButton button = new JButton("Validate");
        panel.add(button);
        button.addActionListener(this);
        getContentPane().add(panel);

        pack();

    }


    public static void main(String[] args){
        SwingDemo demo = new SwingDemo();
        demo.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
//        NumericValidator validator = new NumericValidator(NumericValidator.NumberType.DOUBLE);
//        validator.validate(textField);
        NumericValidator2 val2 = new NumericValidator2();
//        val2.validate(textField, NumericValidator.NumberType.DOUBLE,"text");
        ArrayList<SwingValidationObject> validationObjects = new ArrayList<>();

        validationObjects.add(new SwingValidationObject(textField, "textfield1", NumericValidator.NumberType.DOUBLE));
        validationObjects.add(new SwingValidationObject(textField2,"textfield2", NumericValidator.NumberType.INTEGER));
        val2.validate(validationObjects);

    }
}
