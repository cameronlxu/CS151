package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ActionTester
{
   private static long counter;
   private static long copyCounter;
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FIELD_WIDTH = 20;
      JTextField textField = new JTextField(FIELD_WIDTH);
      textField.setText("Click a button!");

      JButton helloButton = new JButton("Say Hello");
      JButton goodbyeButton = new JButton("Say Goodbye");
      goodbyeButton.setEnabled(false);      // Start with goodbye button being disabled

      helloButton.addActionListener(event -> {
         textField.setText("Hello " + counter);
         helloButton.setEnabled(false);
         goodbyeButton.setEnabled(true);
         copyCounter = counter;
      });

      goodbyeButton.addActionListener(event ->{
          textField.setText("Goodbye " + copyCounter);
          goodbyeButton.setEnabled(false);
          helloButton.setEnabled(true);
          counter++;
      });

      frame.setLayout(new FlowLayout());

      frame.add(helloButton);
      frame.add(goodbyeButton);
      frame.add(textField);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
   }
}
