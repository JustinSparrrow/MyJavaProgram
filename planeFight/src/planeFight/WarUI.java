package planeFight;

import javax.swing.*;
import java.awt.*;

public class WarUI extends JFrame {

    public void initUI(){

        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //流式布局
        FlowLayout fl = new FlowLayout();
        this.setLayout(fl);

        //增加按钮
        JButton buSend = new JButton("发射");
        this.add(buSend);

        //设置窗口可见
        this.setVisible(true);

        //新建画笔对象
        Graphics g = this.getGraphics();

        //添加按钮监听器
        BuAction ba = new BuAction(g);
        buSend.addActionListener(ba);
    }

    public static void main(String[] args) {
        WarUI wu = new WarUI();
        wu.initUI();
    }
}
