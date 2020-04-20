package hw2p2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.util.*;

public class GraphView extends JPanel implements Observer {

	private static final int HEIGHT = 30;
	private DataModel dataModel;

	public GraphView(DataModel dataModel) {
		this.dataModel = dataModel;

		setPreferredSize(new Dimension(500, dataModel.size() * HEIGHT));
		dataModel.addObserver(this);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = e.getY()/HEIGHT;
				if(index >= 0 && index < dataModel.size()) {
					dataModel.setValue(index, e.getX());
				}
			}
		});
	}

	public void paintComponent(Graphics g)
	   {
	      super.paintComponent(g);
	      Graphics2D g2 = (Graphics2D)g;

	      for(int i = 0; i < dataModel.size(); i++) {
	    	  int width = dataModel.getValue(i);
	    	  g2.drawRect(0, i * HEIGHT, width, HEIGHT);
	      }
	   }

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
