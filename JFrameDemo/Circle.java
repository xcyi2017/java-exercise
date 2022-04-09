package JFrameDemo;

public class Circle {
    public int x, y;
    private int r;
    public int vx, vy;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxx, int maxy) {
        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy);
    }

    // 边缘碰撞检测
    private void checkCollision(int minx, int miny, int maxx, int maxy) {
        if (x - r < minx) {
            x = r;
            vx = -vx;
        }
        if (x + r >= maxx) {
            x = maxx - r;
            vx = -vx;
        }
        if (y - r < miny) {
            y = r;
            vy = -vy;
        }
        if (y + r >= maxy) {
            y = maxy - r;
            vy = -vy;
        }
    }

    // 两球之间碰撞检测
    public void checkCollision_(Circle circle) {
        int dx = this.x - circle.x;
        int dy = this.y - circle.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance <= this.r + circle.getR()) {
            // System.out.println("碰撞了");
            // vx = -vx;
            // vy = -vy;
        
            circle.vx = -circle.vx;
            circle.vy = -circle.vy;
        }
    }

}
