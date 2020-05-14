import java.awt.*;
import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 */
public class AnimationTester {
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		// Create CarShapes and Threads
		CarShape carOne = new CarShape(0, 0, CAR_WIDTH, 0);
		MoveableShape car1 = (MoveableShape) carOne;		  
		Runnable r1 = carOne;
		Thread t1 = new Thread(r1);
		
		CarShape carTwo = new CarShape(0, 0, CAR_WIDTH, 3);
		MoveableShape car2 = (MoveableShape) carTwo;
		Runnable r2 = carTwo;
		Thread t2 = new Thread(r2);
		
		CarShape carThree = new CarShape(0, 0, CAR_WIDTH, 6);
		MoveableShape car3 = (MoveableShape) carThree;
		Runnable r3 = carThree;
		Thread t3 = new Thread(r3);

		
		// Create the ShapeIcons and JLabels to display the car
		ShapeIcon icon1 = new ShapeIcon(car1, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon2 = new ShapeIcon(car2, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon3 = new ShapeIcon(car3, ICON_WIDTH, ICON_HEIGHT);

		JLabel label1 = new JLabel(icon1);
		JLabel label2 = new JLabel(icon2);
		JLabel label3 = new JLabel(icon3);
		
		// Set the labels in the CarShape objects so it can be repainted to show movement
		carOne.setLabel(label1);
		carTwo.setLabel(label2);
		carThree.setLabel(label3);
		
		// Run the threads
		t1.start();
		t2.start();
		t3.start();
		
		frame.setLayout(new BorderLayout());
		frame.add(label1, BorderLayout.PAGE_START);
		frame.add(label2, BorderLayout.CENTER);
		frame.add(label3, BorderLayout.PAGE_END);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}