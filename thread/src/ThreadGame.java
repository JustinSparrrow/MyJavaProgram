import java.awt.*;
import java.util.ArrayList;

//线程方法：
//extend Thread
//implement Runnable
public class ThreadGame implements Runnable {
    public Graphics g;
    public boolean start = false;
    public MTank mTank;  //我方角色
    public ArrayList<Bullet> listBullet;

    //初始化属性
    public ThreadGame(Graphics g, MTank mTank, ArrayList<Bullet> listBullet){
        this.g = g;
        this.mTank = mTank;
        this.listBullet = listBullet;
    }

    public void isStart(boolean start) {
        this.start = start;
    }

    //启动线程后自动执行的方法
    //run 执行完，该线程的内存被回收，不能再启动
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":启动...");
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            if (start) {
                continue;
            }

            //画黑色背景，用来擦除痕迹
            g.setColor(Color.BLACK);
            g.fillRect(0,0,900,900);

            mTank.drawTank(g);
            mTank.move();

            // 子弹
            for(Bullet bullet: listBullet){
                bullet.drawBullet(g);
                bullet.move();
            }
        }
    }

}
