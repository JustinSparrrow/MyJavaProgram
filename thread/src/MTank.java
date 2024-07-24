import javax.swing.*;
import java.awt.*;

// 坦克类
public class MTank extends MoveObject{

    public JPanel jPanel;
    public ImageIcon[] tankImage = new ImageIcon[4];

    public MTank(int x, int y, JPanel jPanel){
        super(x, y);
        this.jPanel = jPanel;

        // 加载图片
        tankImage[0] = new ImageIcon("tank/tank1.png");
        tankImage[1] = new ImageIcon("tank/tank2.png");
        tankImage[2] = new ImageIcon("tank/tank3.png");
        tankImage[3] = new ImageIcon("tank/tank4.png");
    }

    // 绘制坦克
    public void drawTank(Graphics g){
        ImageIcon image = isDirection();
        g.drawImage(image.getImage(), getX(), getY(), getSize(), getSize(), null);
    }

    // 选择方向
    public ImageIcon isDirection(){
        int num = 1;
        if(getSpeedX() > 0){
            num = 2;
        } else if (getSpeedX() < 0){
            num = 1;
        } else if (getSpeedY() > 0){
            num = 3;
        } else if (getSpeedY() < 0) {
            num = 0;
        }
        return tankImage[num];
    }

    // 坦克出界
    public void rebound(){
        if(getX() + getSize() > jPanel.getWidth()){

        }
    }
}
