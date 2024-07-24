package planeFight;

import java.awt.*;

public class DrawThread extends Thread{

    private Graphics g = null;
    public DrawThread(Graphics g){
        this.g = g;
    }

    //重写其中的run方法，线程要执行的方法代码
    public void run(){
        for (int i = 0; i < 800; i+=2) {
            g.setColor(Color.black);
            g.fillOval(100+i, 400, 30, 30);

            //线程
            try {
                Thread.sleep(50);
            }
            catch (Exception ef){}
            g.setColor(Color.white);
            g.fillOval(100+i,400,30,30);
        }
    }
}
