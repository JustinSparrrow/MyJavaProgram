import javax.swing.*;
import java.awt.*;

// 游戏界面类
public class GameUI {

    //显示画图界面
    public void initUI() {
        JFrame jf = new JFrame();
        jf.setSize(900, 900);
        jf.setTitle("画图");
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);

        // 游戏面板
        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.GREEN);
        jf.add(gamePanel, BorderLayout.CENTER);

        jf.setVisible(true);

        //鼠标监听器方法
        ThreadListener mouse = new ThreadListener(gamePanel.getGraphics(), gamePanel);
        //键盘监听器   焦点
        jf.addKeyListener(mouse);

        //让窗体获取焦点
        jf.requestFocus();
    }

    public static void main(String[] args) {
        GameUI ui = new GameUI();
        ui.initUI();
    }
}
