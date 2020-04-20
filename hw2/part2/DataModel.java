package hw2p2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Observable;

public class DataModel extends Observable {

	private static final int INITIAL = 5;

	private int[] data;
	private int size;

	public DataModel() {
		data = new int[INITIAL];
		size = 0;
	}

	public void addValue(int val) {
		// Grow array to accommodate arbitrary size input
		if(data.length == size) {
			int[] newData = new int[2 * size];
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;		// re-assign back to data variable
		}

		data[size++] = val;
	}

	public void setValue(int index, int val) {
		data[index] = val;
		setChanged();
		notifyObservers(index);
	}

	public int getValue(int index) {
		return data[index];
	}

	public int size() {
		return size;
	}

	public void save(String file) {
		// saving output file
		PrintWriter pw;
		try {
			pw = new PrintWriter(file);
			for(int i = 0; i < size(); i++) {
				pw.println(data[i]);
			}
			pw.close();
		} catch (FileNotFoundException e){
			System.out.println("Error: " + e.getMessage());
		}
	}
}
