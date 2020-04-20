package lab6p2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

public class BoxedIcon implements Icon {

	private Icon icon;

	public BoxedIcon(Icon icon) {
		this.icon = icon;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {

		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Rectangle2D.Double(x, y, getIconWidth() - 2, getIconHeight() - 2));
		icon.paintIcon(c, g, x + 10, y + 10);
	}

	@Override
	public int getIconWidth() {
		return icon.getIconWidth() + 25;
	}

	@Override
	public int getIconHeight() {
		return icon.getIconHeight() + 25;
	}

}
