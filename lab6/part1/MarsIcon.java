package lab6;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.Icon;

class MarsIcon implements Icon {
	private int size;

	MarsIcon(int size){
		this.size = size;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D)g;
		Ellipse2D.Double mars = new Ellipse2D.Double(x, y, size, size);
		g2.setColor(Color.RED);
		g2.fill(mars);
	}

	@Override
	public int getIconWidth() {
		return size;
	}

	@Override
	public int getIconHeight() {
		return size;
	}

}
