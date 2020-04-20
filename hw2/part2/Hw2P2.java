package hw2p2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JFrame;

public class Hw2P2 {

	public static void main(String[] args) {
		String values = args[0];

		DataModel dataModel = new DataModel();
		readData(values, dataModel);

		TextView textView = new TextView(dataModel);
		JFrame textViewFrame = new JFrame("Text View");
		textViewFrame.add(textView);
		textViewFrame.pack();
		textViewFrame.setLocation(100, 100);
		textViewFrame.setVisible(true);

		GraphView graphView = new GraphView(dataModel);
		JFrame graphViewFrame = new JFrame("Graph View");
		graphViewFrame.add(graphView);
		graphViewFrame.pack();
		//graphViewFrame.setLocation(400, 100);
		graphViewFrame.setBounds(400, 100, 400, 100);
		graphViewFrame.setVisible(true);

		textViewFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dataModel.save(values);
				graphViewFrame.dispose();
				textViewFrame.dispose();
			}
		});

		graphViewFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dataModel.save(values);
				graphViewFrame.dispose();
				textViewFrame.dispose();
			}
		});
	}

	public static void readData(String file, DataModel dataModel) {
		try {
			Scanner scanner = new Scanner(new File(file));

			while(scanner.hasNextInt()) {
				dataModel.addValue(scanner.nextInt());
			}

			scanner.close();
		} catch(FileNotFoundException e) {
			System.out.println("Error: " + file);
		}
	}

}
