package lab5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    JButton button;
    JTextField enter;
    JTextArea display;

    // Constructor, creating a new GUI object activates the UI
    GUI(){
        JFrame f=new JFrame("lab5");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display Add Button
        button = new JButton("add");
        button.setBounds(0,0,150,25);
        f.add(button);

        // Enter Text Area
        enter = new JTextField();
        enter.setBounds(0,200,150,25);
        f.add(enter);

        // Display Text Area
        display = new JTextArea();
        display.setBounds(0,25,150,170);
        f.add(display);

        // Set GUI Size
        f.setSize(150,250);
        f.setLayout(null);
        f.setVisible(true);

        // Add Button Functionality
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Controller control = new Controller(display,enter);
            }
        });
    }
}
