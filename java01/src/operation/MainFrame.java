package operation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JButton startButton;
    private JLabel textLabel;

    public MainFrame() {
        startButton = new JButton("开始游戏");
        startButton.addActionListener(e -> {
            // 点击按钮时隐藏当前Frame
            this.setVisible(false);
            // 创建并显示新的Frame
            new SecondFrame().setVisible(true);
        });
        textLabel = new JLabel("这是主界面");
        // 将按钮和文本添加到Frame中
        getContentPane().add(startButton, BorderLayout.PAGE_START);
        getContentPane().add(textLabel, BorderLayout.CENTER);
        // 设置Frame大小和可见性
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

class SecondFrame extends JFrame {
    private JLabel textLabel;

    public SecondFrame() {
        textLabel = new JLabel("游戏界面");
        getContentPane().add(textLabel, BorderLayout.CENTER);
        setSize(300, 200);
        setVisible(false);
    }
}

