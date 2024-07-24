package jiayu0405迭代分形;

import javax.swing.*;
import java.awt.*;

public class Question {

    public void showUI(){
        JFrame jf = new JFrame();
        jf.setLocationRelativeTo(null);
        jf.setSize(900,800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Panel north_panel = new Panel();
        north_panel.setPreferredSize(new Dimension(0,60));
        jf.add(north_panel,BorderLayout.NORTH);

        Panel center_panel = new Panel();
        center_panel.setBackground(Color.black);
        jf.add(center_panel,BorderLayout.CENTER);

        JButton jbu = new JButton("骰子");
        Dimension dm = new Dimension(80,55);
        jbu.setPreferredSize(dm);
        north_panel.add(jbu);

        clickMouse cM = new clickMouse();
        jbu.addActionListener(cM);

        jf.setVisible(true);

        Graphics g = center_panel.getGraphics();
        center_panel.addMouseListener(cM);
        cM.gr = g;
        cM.DrawLine();
    }

    public static void main(String[] args){
        Question ui = new Question();
        ui.showUI();
    }
}
