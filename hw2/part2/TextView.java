package hw2p2;

import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextView extends Box implements Observer {

	private DataModel dataModel;
	private JTextField[] textFields;
	private int currentUpdate = -1;
	private int currentChangedUpdate = -1;

	public TextView(DataModel aModel) {
	      super(BoxLayout.Y_AXIS);
	      this.dataModel = aModel;
	      textFields = new JTextField[dataModel.size()];
	      for(int i = 0; i < textFields.length; i++) {
	    	  textFields[i] = new JTextField(20);
	    	  textFields[i].setText(dataModel.getValue(i) + "");
	    	  textFields[i].getDocument().addDocumentListener(new MyDocumentListener(i));
	    	  add(textFields[i]);
	      }

	      dataModel.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		currentUpdate = (int) arg;
		if(currentChangedUpdate != currentUpdate) {
			textFields[currentUpdate].setText(dataModel.getValue(currentUpdate) + "");
		}
		currentUpdate = -1;
	}

	private class MyDocumentListener implements DocumentListener {
		private int index;

		public MyDocumentListener(int index) {
			this.index = index;
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			changedText();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			changedText();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			changedText();
		}

		private void changedText() {
			currentChangedUpdate = index;

			if(currentUpdate != index) {
				try {
					dataModel.setValue(index, Integer.parseInt(textFields[index].getText()));
				} catch (NumberFormatException e) {
					System.out.println("Error: " + e.getMessage());
				}
			}

			currentChangedUpdate = -1;
		}
	}
}
