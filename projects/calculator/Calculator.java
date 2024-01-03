/*
 * Author: Christopher Perez
 * Date: January 3, 2024
 * Description: This program demonstrates implementing basic arithmetic and UI.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    // buttons on calculator 0 through 9
    JButton[] numberButtons = new JButton[10];
    // buttons for operations add, multiply, divide, and so on
    JButton[] functionButtons = new JButton[9];
    // name of operation buttons
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    // panel where our number buttons are going to be
    JPanel panel;

    Font myFont = new Font("Consolas", Font.BOLD, 30);

    double num1 = 0.0;
    double num2 = 0.0;

    char operator;
    double result;

    public Calculator() {
        // the calculator shape
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // the display of the text
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // adding value to our operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        // adding operator buttons to the array of buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // instantiate operator buttons
        for(int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // instantiate number buttons
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        
        // placing the negative, delete, and clear button
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.GRAY);

        // adding our number and operator buttons to our grid layout panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
   
        // adding our panel, negative button, clear button, delete button and display to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    public void actionPerformed(ActionEvent e) {
        // displaying number when user clicks on the number
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // displaying decimal
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        // if user clicks on the add button the display is then cleared to make room for the next number and store first number
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        // if user clicks on the subtract button the display is then cleared to make room for the next number and store first number
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        // if user clicks on the multiply button the display is then cleared to make room for the next number and store first number
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        // if user clicks on the division button the display is then cleared to make room for the next number and store first number
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        // if user clicks on the equals button we store the second number 
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            // determines what math operation we use
            switch(operator) {
                case '+': result = num1 + num2;
                break;
                case '-': result = num1 - num2;
                break;
                case '*': result = num1 * num2;
                break;
                case '/': result = num1 / num2;
                break;
            }
            // display the answer
            textField.setText(String.valueOf(result));
            // set num1 as the result incase the user wants the expand on the answer
            num1 = result;
        }
        // if the user clicks on the clear button we set the display to an empty string
        if(e.getSource() == clrButton) {
            textField.setText("");
        }
        // we make a string of the display and then removes a char from the string display 
        if(e.getSource() == delButton) {
            String textLine = textField.getText();
            textField.setText("");
            for(int i = 0; i < textLine.length() - 1; i++) {
                textField.setText(textField.getText() + textLine.charAt(i));
            }
        }
        // going to take the value in the text field and assign it into the temp variable and then just multiply it by -1
        if(e.getSource() == negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}