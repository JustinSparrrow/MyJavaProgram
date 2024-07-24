package lab11_2;

import javax.swing.*;
import java.awt.*;

public class MainUI {

    public void showUI(){
        JFrame jFrame = new JFrame("学生信息平台");
        jFrame.setSize(700,700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);

        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(600, 700));
        jFrame.add(center, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(580,50));
        bottom.setBackground(Color.lightGray);
        jFrame.add(bottom, BorderLayout.SOUTH);

        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(80,700));
        left.setBackground(Color.GRAY);
        Button addInformation = new Button("新增");
        left.add(addInformation);
        Button deleteInformation = new Button("删除");
        left.add(deleteInformation);
        Button changeInformation = new Button("修改");
        left.add(changeInformation);
        Button inquireInformation = new Button("查询");
        left.add(inquireInformation);
        Button displayInformation = new Button("显示");
        left.add(displayInformation);
        jFrame.add(left, BorderLayout.WEST);

        ButtonListener buttonListener = new ButtonListener(center, bottom, jFrame.getGraphics());
        addInformation.addActionListener(buttonListener);
        displayInformation.addActionListener(buttonListener);
        deleteInformation.addActionListener(buttonListener);
        changeInformation.addActionListener(buttonListener);
        inquireInformation.addActionListener(buttonListener);

        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI().showUI();
    }
}
