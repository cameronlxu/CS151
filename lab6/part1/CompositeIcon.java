package lab6;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import javax.swing.Icon;

public class CompositeIcon implements Icon {

	private ArrayList<Icon> list;

	public CompositeIcon() {
		list = new ArrayList<Icon>();
	}

	void addIcon(Icon Icon) {
		list.add(Icon);
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		int width = 0;
		for (int i = 0; i < list.size(); i++) {
			list.get(i).paintIcon(c, g, x + width, y);
			width += list.get(i).getIconWidth();
		}
	}

	@Override
	public int getIconWidth() {
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getIconWidth();
		}
		return total;
	}

	@Override
	public int getIconHeight() {
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (max < list.get(i).getIconHeight()) {
				max = list.get(i).getIconHeight();
			}
		}
		return max;
	}

}
