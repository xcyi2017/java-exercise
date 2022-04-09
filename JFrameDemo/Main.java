package JFrameDemo;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;

        int N = 20;

        Circle[] circles = new Circle[N];
        // for (int i = 0; i < N; i++) {
        // int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
        // int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
        // int vx = (int) (Math.random() * 11) - 5;
        // int vy = (int) (Math.random() * 11) - 5;
        // circles[i] = new Circle(x, y, R, vx, vy);
        // }
        generateCircles(circles, sceneWidth, sceneHeight);
        EventQueue.invokeLater(() -> { // 放进新的线程中
            AlgoFrame frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {
                while (true) {
                    // 绘制数据
                    frame.render(circles);
                    AlgoVisHelper.pause(30);
                    // 更新数据
                    for (Circle circle : circles) {
                        circle.move(0, 0, sceneWidth, sceneHeight);
                    }
                }
            }).start();

        });
    }

    public static void generateCircles(Circle[] circles, int sceneWidth, int sceneHeight) {
        int R = 50;

        // 生成第一个圆心
        int totalCircleNum = circles.length;
        int currentCircleNum = 0;
        while (currentCircleNum < totalCircleNum) {
            System.out.println(currentCircleNum);
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            Circle circle = new Circle(x, y, R, vx, vy);
            if (currentCircleNum == 0) {
                circles[currentCircleNum] = circle;
                currentCircleNum++;
                continue;
            }
            if (AlgoVisHelper.checkIsValid(circles, circle)) {
                circles[currentCircleNum] = circle;
                currentCircleNum++;
            }
        }
    }

}
