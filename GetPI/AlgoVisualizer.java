package GetPI;

import java.awt.*;

public class AlgoVisualizer {

    private static int DELAY = 40;

    private MonteCarloData data;
    private int N; // 数据
    private AlgoFrame frame; // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        if (sceneHeight != sceneWidth) {
            throw new IllegalArgumentException("This demo must be run in a squre window!");
        }

        // 初始化数据
        this.N = N;
        Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneWidth / 2);
        data= new MonteCarloData(circle);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get Pi with Monte Carlo", sceneWidth, sceneHeight);
            new Thread(this::run).start();
        });
    }

    // 动画逻辑
    private void run() {

        for (int i = 0; i < N; i++) {

            if (i % 100 == 0) { // 优化
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println("Current Pi = " + data.estimatePi());
            }

            int x = (int) (Math.random() * frame.getCanvasWidth());
            int y = (int) (Math.random() * frame.getCanvasHeight());

            Point p = new Point(x, y);
            data.addPoint(p);

        }
    }

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10000;

        new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
