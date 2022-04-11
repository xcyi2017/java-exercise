package GetPI;
import java.awt.Point;


public class MonteCarloExperiment {
    private int squreSide;
    private int N;

    public MonteCarloExperiment(int squreSide, int N) {
        if (squreSide <= 0 || N <= 0) {
            throw new IllegalArgumentException("squareSize and N must larger than 0");
        }

        this.squreSide = squreSide;
        this.N = N;
    }

    public void run() {
        Circle circle = new Circle(squreSide / 2, squreSide / 2, squreSide / 2);
        MonteCarloData data = new MonteCarloData(circle);

        for (int i = 0; i < N; i++) {
            if (i % 100 == 0) {
                System.out.println(data.estimatePi());
            }

            int x = (int) (Math.random() * squreSide);
            int y = (int) (Math.random() * squreSide);

            data.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {
        int squreSide = 800;
        int N = 10000;

        MonteCarloExperiment exp = new MonteCarloExperiment(squreSide, N);
        exp.run();
    }
}
