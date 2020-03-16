package lab3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class BouncingBall implements MoveableShape {

    private int x;
    private int y;
    private int width;
    private boolean down;

    // Constructor
    public BouncingBall(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.down = true;
    }

    @Override
    public void draw(Graphics2D g2) {
        Ellipse2D.Double ball = new Ellipse2D.Double(x, y, width, width);
        Color prevColor = g2.getColor();
        g2.setColor(Color.BLUE);
        g2.fill(ball);
        g2.setColor(prevColor);

    }

    @Override
    public void move() {
        if(down) {
            y++;
            // Once we reach the bottom of the frame
            if(y == 200 - this.width) {
                down = false;
            }
        } else {
            y--;
            // Once we reach the top of the frame
            if (y == 0) {
                down = true;
            }
        }

    }


}
