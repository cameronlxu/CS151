package lab3;

import javax.swing.JLabel;

public class Ball {
    MoveableShape s;
    ShapeIcon i;
    JLabel l;

    public Ball() {
        s = new BouncingBall(0,0,BALL_WIDTH);
        i = new ShapeIcon(s, ICON_WIDTH, ICON_HEIGHT);
        l = new JLabel(i);
    }

    public void update() {
        s.move();
        l.repaint();
    }

    public JLabel getLabel() {
        return l;
    }

    private static final int ICON_WIDTH = 100;
    private static final int ICON_HEIGHT = 400;
    private static final int BALL_WIDTH = 50;
}
