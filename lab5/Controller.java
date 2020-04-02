package lab5;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Controller {
    Controller(JTextArea display, JTextField enter){
        // Display the input text with a newline on each input & add
        display.setText(display.getText() + enter.getText() + "\n");

        // Clears the text field
        enter.setText("");
    }
}
