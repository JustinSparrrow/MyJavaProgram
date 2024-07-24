import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// 游戏逻辑类
public class ThreadListener  implements ActionListener, KeyListener {
    public Graphics g;
    public int x, y;
    public JPanel jPanel;
    public ThreadGame tb;
    public ArrayList<Bullet> listBullet = new ArrayList<>();  //列表(动态数组)
    public MTank mTank;
    public int speedX=6,speedY=3;
    public ArrayList<MoveObject> listMoveObject = new ArrayList<>();  //保存敌人

    //初始化属性
    public ThreadListener(Graphics g, JPanel jPanel) {
        this.g = g;
        this.jPanel = jPanel;
    }

    public void actionPerformed(ActionEvent e) {
        //让窗体获取焦点
        jPanel.requestFocus();
    }

    public void keyTyped(KeyEvent e){

    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_W:
                mTank.setSpeedY(-speedY);
                break;
            case KeyEvent.VK_A:
                mTank.setSpeedX(-speedX);
                break;
            case KeyEvent.VK_D:
                mTank.setSpeedX(speedX);
                break;
            case KeyEvent.VK_S:
                mTank.setSpeedY(speedY);
                break;
            case KeyEvent.VK_SPACE:
                if(mTank == null) {
                    // 创建坦克
                    mTank = new MTank(400, 700 ,jPanel);
                    //限制线程只启动一次
                    //单例模式
                    //空格控制游戏启动
                    tb = new ThreadGame(g, mTank, listBullet);
                    new Thread(tb).start();
                }
                break;
            case KeyEvent.VK_J:
                Bullet bullet = new Bullet(mTank.getX(), mTank.getY());
                listBullet.add(bullet);
                break;
        }
        System.out.println("按下  key = "+key);
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W:

                break;
            case KeyEvent.VK_A:
                mTank.setSpeedX(0);
                break;
            case KeyEvent.VK_D:
                mTank.setSpeedX(0);
                break;
        }
    }

}
