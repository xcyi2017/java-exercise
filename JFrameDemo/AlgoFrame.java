package JFrameDemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BasicStroke;

public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();

        // this.setSize(canvasWidth, canvasHeight);
        // canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        setContentPane(canvas);
        pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private Circle[] circles;

    public void render(Circle[] circles) {
        this.circles = circles;
        this.repaint();
    }

    private class AlgoCanvas extends JPanel {
        public AlgoCanvas() {
            super(true); // 打开支持双缓存
        }

        @Override
        public void paintComponent(Graphics g) { // 绘制的上下文环境
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.setColor(g2d, Color.RED);

            for (Circle circle : circles) {
                // System.out.println(circle.x + circle.y + circle.getR());
                AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());

            }

            for (int i = 0; i < circles.length; i++) {
                for (int j = 0; j < circles.length; j++) {
                    if (i != j) {
                        circles[i].checkCollision_(circles[j]);
                    }
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }

    }
}
