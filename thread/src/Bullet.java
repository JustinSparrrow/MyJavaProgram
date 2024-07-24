import java.awt.*;

// 子弹类
public class Bullet extends MoveObject{
    public Bullet(int x, int y) {
        super(x, y);
        setSize(5);
    }

    // 控制子弹
    public void drawBullet(Graphics g){
        g.setColor(Color.red);
        g.fillOval(getX(), getY(), getSize(), getSize());
    }
}
