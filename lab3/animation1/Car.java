package lab3;

import javax.swing.JLabel;

public class Car {
    MoveableShape ms;
    ShapeIcon si;
    JLabel label;

    public Car() {
        ms = new CarShape(0, 0, CAR_WIDTH);
        si = new ShapeIcon(ms, ICON_WIDTH, ICON_HEIGHT);
        label = new JLabel(si);
    }

    public void updateStatus() {
        ms.move();
        label.repaint();
    }

    public JLabel getLabel() {
        return label;
    }

    private static final int ICON_WIDTH = 400;
    private static final int ICON_HEIGHT = 100;
    private static final int CAR_WIDTH = 100;
}
