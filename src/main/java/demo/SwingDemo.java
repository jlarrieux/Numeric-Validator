package com.github.jlarrieux.main.demo;



import com.github.jlarrieux.main.NumericValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * Created by jlarrieux on 5/19/2017.
 */
public class SwingDemo extends JFrame implements ActionListener {

    JTextField textField;
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

        panel.add(textField);

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
        NumericValidator validator = new NumericValidator(NumericValidator.TypeOfNumber.DOUBLE);
        validator.validate(textField);
    }
}
