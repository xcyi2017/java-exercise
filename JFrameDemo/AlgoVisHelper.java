package JFrameDemo;

import java.awt.*;
import java.awt.geom.*;


public class AlgoVisHelper {

    private AlgoVisHelper() {
    }

    public static void setStrokeWidth(Graphics2D g2d, int w) {
        int strokeWidth = w;
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void strokeCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.draw(circle);
    }

    public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.fill(circle);
    }

    public static void setColor(Graphics2D g2d, Color color) {
        g2d.setColor(color);
    }

    public static void pause(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            System.out.println("Error in sleeping.");
        }
    }

    public static boolean isCollision(Circle circle1, Circle circle2) {
        int dx = circle1.x - circle2.x;
        int dy = circle1.y - circle2.y;
        int R2 = circle1.getR() + circle2.getR();
        return dx * dx + dy * dy < R2 * R2;
    }

    public static boolean checkIsValid(Circle[] circles, Circle circle) {
        for (Circle cir : circles) {
            if (cir == null) break;
            if (AlgoVisHelper.isCollision(cir, circle)) {
                return false;
            }
        }
        return true;
    }
}
