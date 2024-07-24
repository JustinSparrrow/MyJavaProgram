package planeFight;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuAction implements ActionListener {

    //建立画笔
    private Graphics g = null;

    public BuAction(Graphics g){
        this.g = g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("发射");

        //创建一个线程对象，每次点击按钮都会创建一个线程对象
        DrawThread dt = new DrawThread(g);
        dt.start(); //线程的启动函数
    }
}
