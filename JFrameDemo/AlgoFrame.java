package JFrameDemo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;


public class AlgoFrame extends JFrame {
    private final int canvasWidth;
    private final int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();

        setContentPane(canvas);
        pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
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
            AlgoVisHelper.setColor(g2d, templates.AlgoVisHelper.LightGreen);

            for (Circle circle : circles) {
                if (!circle.isFilled) {
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                } else {
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                }

            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }

    }
}
