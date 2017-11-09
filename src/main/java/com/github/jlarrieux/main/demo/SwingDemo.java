package com.github.jlarrieux.main.demo;



import com.github.jlarrieux.main.Validator;
import com.github.jlarrieux.main.ValidationObject.AbstractComponentValidationObject;
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
//        Validator validator = new Validator(Validator.NumberType.DOUBLE);
//        validator.validate(textField);


        Validator val2 = new Validator();
//        val2.validate(textField, Validator.NumberType.DOUBLE,"text");
        ArrayList<AbstractComponentValidationObject> validationObjects = new ArrayList<>();

        validationObjects.add(new SwingValidationObject(textField, "textfield1", Validator.NumberType.DOUBLE));
        validationObjects.add(new SwingValidationObject(textField2,"textfield2", Validator.NumberType.INTEGER));
        val2.validate(validationObjects);

    }
}
