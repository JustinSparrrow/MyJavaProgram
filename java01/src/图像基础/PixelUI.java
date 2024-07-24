package jiayu0520图像基础;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PixelUI extends JPanel{
    public void initUI(){
        PixelMouse mouse = new PixelMouse();

        JFrame jf = new JFrame();
        jf.setSize(900,800);
        jf.setTitle("图像处理");
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //创建菜单组建
        JMenuBar jMenuBar = new JMenuBar();
        jf.add(jMenuBar, BorderLayout.NORTH);

        //菜单选项
        JMenu jMenu = new JMenu("文件");
        jMenuBar.add(jMenu);
        JMenu jMenu1 = new JMenu("滤镜");
        jMenuBar.add(jMenu1);

        //子菜单
        JMenuItem jMenuItem = new JMenuItem("打开");
        jMenu.add(jMenuItem);

        String[] function = {"向左翻转","向右翻转","原图","模糊","灰度"};
        for(int i = 0; i < 5; i++){
            JMenuItem jMenuItem1m = new JMenuItem(function[i]);
            jMenu1.add(jMenuItem1m);
            jMenuItem1m.addActionListener(mouse);
        }

        //显示画图面板
        jf.add(this,BorderLayout.CENTER);
        this.setBackground(Color.white);

        JPanel sPanel = new JPanel();
        jf.add(sPanel,BorderLayout.SOUTH);

        JLabel jLabel = new JLabel("缩放:");
        sPanel.add(jLabel);

        JSlider js = new JSlider();
        js.setPreferredSize(new Dimension(400,40));
        sPanel.add(js);
        js.addChangeListener((ChangeListener) mouse);

        jf.setVisible(true);

        mouse.setGr(this.getGraphics());

    }

    public static void main(String[] args) {
        PixelUI ui = new PixelUI();
        ui.initUI();
    }
}
