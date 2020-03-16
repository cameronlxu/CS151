package lab3;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

/**
   This program implements an animation that bounces
   a ball shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      Ball ball = new Ball();

      frame.setLayout(new FlowLayout());
      frame.add(ball.getLabel());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setPreferredSize(new Dimension(200,200));
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 10;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
         {
            ball.update();
         });
      t.start();
   }

}
