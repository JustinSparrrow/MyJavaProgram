package jiayu0313简单绘图;

import javax.swing.*;
import java.awt.*;

public class DrawUI {

    public void showUI(){
        JFrame jf = new JFrame();
        jf.setSize(1000,800);
        jf.setTitle("绘画");
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Panel north_jPanel = new Panel();
        north_jPanel.setBackground(Color.black);
        north_jPanel.setPreferredSize(new Dimension(0,80));
        jf.add(north_jPanel,BorderLayout.NORTH);

        MyPanel center_jpanel = new MyPanel();
        center_jpanel.setBackground(Color.white);
        jf.add(center_jpanel,BorderLayout.CENTER);

        DrawMouse mouse = new DrawMouse();
        Dimension dm = new Dimension(80,50);

        String[] nameArr = {"直线","矩形","圆","三角形","多边形","✏️","橡皮"};
        for(int ix = 0; ix < 7; ix++) {
            JButton jbu = new JButton(nameArr[ix]);
            jbu.setPreferredSize(dm);
            north_jPanel.add(jbu);
            jbu.addActionListener(mouse);
        }

        String[] ColorArr = {"红","黄","蓝","绿"};
        for(int ix = 0; ix < 4; ix++){
            JButton jbu = new JButton(ColorArr[ix]);
            switch (ix) {
                case 0 -> {
                    jbu.setBackground(Color.red);
                    jbu.setForeground(Color.red);
                }
                case 1 -> {
                    jbu.setBackground(Color.yellow);
                    jbu.setForeground(Color.yellow);
                }
                case 2 -> {
                    jbu.setBackground(Color.blue);
                    jbu.setForeground(Color.blue);
                }
                case 3 -> {
                    jbu.setBackground(Color.green);
                    jbu.setForeground(Color.green);
                }
                default -> jbu.setBackground(Color.black);
            }
            jbu.setPreferredSize(dm);
            north_jPanel.add(jbu);
            jbu.addActionListener(mouse);
        }

        jf.setVisible(true);

        Graphics g = center_jpanel.getGraphics();

        center_jpanel.addMouseListener(mouse); //调用了addMouseListener方法，mouse是方法中的类型，包括点击、按压、释放、进入、离开
        center_jpanel.addMouseMotionListener(mouse);  //调用了addMouseMotionListener里的方法，mouse是方法中的类型，包括鼠标拖动和鼠标移动
        mouse.gr = g; //给画笔对象传递给这个类

        //把数组从DrawMouse类传递给MyFrame类
        center_jpanel.shapeArr = mouse.shapeArr; //赋值
    }

    public static void main(String[] args){
        DrawUI ui = new DrawUI();
        ui.showUI();
    }
}
