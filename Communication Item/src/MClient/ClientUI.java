package MClient;

import javax.swing.*;
import java.awt.*;

public class ClientUI {
    public static void main(String[] args) {
        ClientUI ui = new ClientUI();
        ui.loginUI();
    }

    public void loginUI(){
        JFrame jFrame = new JFrame("登录");
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(650, 500);
        jFrame.setLayout(new BorderLayout());

        // 图片logo
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(400, 120));
        logoPanel.setBackground(Color.decode("#ec7895"));
        String iconPath = "assets/logo.png";
        ImageIcon imageIcon = new ImageIcon(iconPath);
        JLabel logoLabel = new JLabel(imageIcon);
        logoPanel.setPreferredSize(new Dimension(50,50));
        logoPanel.add(logoLabel);
        jFrame.add(logoPanel, BorderLayout.NORTH);

        // 账号密码输入框
        JPanel inputPanel = new JPanel();
        JPanel accountPanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JLabel account = new JLabel("账号：");
        JLabel password = new JLabel("密码：");


        // 登录注册按钮

        jFrame.setVisible(true);
    }
}
