package jiayu0303登陆界面;

import javax.swing.*;
import java.awt.*;

public class LOGIN {
    //属性

    //方法
    /*登陆界面要有窗体，然后再有输入框、按钮、图片等
    先定义窗体，窗体得有大小，得有名称，下面再将组件加入其中
     */
    public void showUI(){
        //窗体
        JFrame jf = new JFrame(); //创建窗口类
        jf.setSize(500,500); //窗口大小用setSize调整，基本单位为像素点
        jf.setTitle("登陆"); //设置窗口的名称
        jf.setLocationRelativeTo(null); //控制窗口出现的位置，null是指居中
        jf.setDefaultCloseOperation(3); //使得其能后台直接退出

        //流式布局管理器，用来控制组件在窗口上的位置
        FlowLayout flow = new FlowLayout(); //类名创建
        jf.setLayout(flow); //使得jf对象可以使用FlowLayout所创建的类（flow这个对象被包含进去）

        //下面开始在窗口上加组件

        //加载图片
        ImageIcon image= new ImageIcon("image/1.jpeg"); //创建图片类，并且读取图片地址
        //标签，相当于图片的容器
        JLabel jla = new JLabel(image); //括号里面输入图片对象名称
        Dimension y = new Dimension(550,280);
        jla.setPreferredSize(y);
        jf.add(jla); //在窗口上加入该标签（图片）

        //用户提示
        JLabel user = new JLabel("账号：");
        jf.add(user);

        //账号（输入框）
        JTextField jtf = new JTextField();
        //除了JFrame,其它组件设置大小都是该方法
        //类 本身就是一种数据类型(引用类型/自定义类型)
        Dimension dm = new Dimension(420, 20);
        jtf.setPreferredSize(dm);
        jf.add(jtf);

        JLabel password = new JLabel("密码：");
        jf.add(password);

        JTextField jte = new JTextField();
        Dimension dn = new Dimension(420,20);
        jte.setPreferredSize(dn);
        jf.add(jte);

        //按钮
        JButton jbu = new JButton("登陆");
        Dimension x = new Dimension(80,50);
        jbu.setPreferredSize(x);
        jf.add(jbu);

        Buttonlistener buttonlistener = new Buttonlistener();
        jbu.addActionListener(buttonlistener);
        buttonlistener.user_ID = jtf;
        buttonlistener.user_password = jte;

        JLabel space = new JLabel();
        Dimension sq = new Dimension(600,20);
        space.setPreferredSize(sq);
        jf.add(space);

        JLabel reg = new JLabel("没有账号？/忘记密码？");
        jf.add(reg);

        JButton lar = new JButton("注册账号");
        jbu.setPreferredSize(x);
        jf.add(lar);

        //设置可见
        jf.setVisible(true);
    }
    public static void main(String[] args){
        LOGIN log = new LOGIN();
        log.showUI();
    }
}
