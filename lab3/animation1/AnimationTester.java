package lab3;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

import javax.swing.*;

/**
   This program implements an animation that moves
   a car shape.
*/
public class AnimationTester
{
   public static void main(String[] args)
   {
      HashSet<Car> carSet = new HashSet<Car>();
      JFrame frame = new JFrame();

      for(int i = 0; i < 2; i++) {
          carSet.add(new Car());
      }

      frame.setLayout(new FlowLayout());
      for(Car test : carSet) {
          frame.add(test.getLabel());
      }

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);

      final int DELAY = 100;
      // Milliseconds between timer ticks
      Timer t = new Timer(DELAY, event ->
         {
            for(Car c : carSet) {
                c.updateStatus();
            }
         });
      t.start();
   }

   private static final int ICON_WIDTH = 400;
   private static final int ICON_HEIGHT = 100;
   private static final int CAR_WIDTH = 100;
}
