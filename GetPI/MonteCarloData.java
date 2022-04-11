package GetPI;

import java.util.LinkedList;
import java.awt.Point;

public class MonteCarloData {
    private Circle circle;
    private LinkedList<Point> points;
    private int insideCircle = 0;

    public MonteCarloData(Circle circle) {
        this.circle = circle;
        points = new LinkedList<Point>();
    }

    public Circle getCircle() {
        return circle;
    }

    public Point getPoint(int i) {
        if (i < 0 || i > points.size()) {
            throw new IllegalArgumentException("Out of bound in getPoint!");
        }
        return points.get(i);
    }

    public int getPointsNumber() {
        return points.size();
    }

    public void addPoint(Point p) {
        points.add(p);
        if (circle.contain(p)) {
            insideCircle++;
        }
    }

    public double estimatePi() {
        if (points.size() == 0)
            return 0.0;

        int circleArea = insideCircle;
        int suqareArea = points.size();

        return (double) circleArea * 4 / suqareArea;
    }
}
