package jiayu0304迭代分形;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Picture{

    public void showUI(){
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Hello!");
        jFrame.setSize(900,800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        jFrame.getContentPane().setBackground(Color.black);

        JPanel east_panel = new JPanel();
        east_panel.setPreferredSize(new Dimension(60,0));
        east_panel.setBackground(Color.lightGray);
        jFrame.add(east_panel,BorderLayout.EAST);

        JPanel center_panel = new JPanel();
        center_panel.setBackground(Color.black);
        jFrame.add(center_panel);

        JButton jbu = new JButton("迭代1");
        jbu.setPreferredSize(new Dimension(60,55));
        east_panel.add(jbu);

        JButton jbut = new JButton("迭代2");
        jbut.setPreferredSize(new Dimension(60,55));
        east_panel.add(jbut);

        String[] name = {"a=","b=","c=","d="};
        for(int ix = 0; ix < 4; ix++){
            JTextField jte = new JTextField();
            jte.setPreferredSize(new Dimension(60,55));

            JLabel content = new JLabel(name[ix]);

            east_panel.add(content);
            east_panel.add(jte);
        }

        Buttonlistener001 buttonlistener001 = new Buttonlistener001();
        jbu.addActionListener(buttonlistener001);
        jbut.addActionListener(buttonlistener001);

        jFrame.setVisible(true);

        Graphics g = center_panel.getGraphics();
        center_panel.addMouseListener(buttonlistener001);
        buttonlistener001.gr = g;
        buttonlistener001.number();

    }

    public static void main(String[] args) {
        Picture picture = new Picture();
        picture.showUI();
    }
}
