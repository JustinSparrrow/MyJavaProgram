import javax.swing.*;
import java.awt.*;

public class newGameUI {

    public void newShowUI(){

        //窗体
        JFrame jf = new JFrame();
        jf.setTitle("五子棋游戏");
        jf.setSize(900,900);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.getContentPane().setBackground(Color.lightGray);

        //游戏界面
        bottomMap myPanel = new bottomMap();
        myPanel.setBackground(Color.lightGray);
        jf.add(myPanel,BorderLayout.CENTER);

        //菜单栏
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100,0));
        jf.add(panel,BorderLayout.EAST);

        //与按钮事件接口接上
        newGameMouse mouse = new newGameMouse();

        //功能按键
        String[] name = {"人机对战","双人对战", "悔棋", "复盘"};
        for(int ix = 0; ix < 4; ix++){
            JButton jButton = new JButton(name[ix]);
            jButton.setPreferredSize(new Dimension(80,40));
            panel.add(jButton);
            jButton.addActionListener(mouse);
        }

        //将数组传递给底层map进行棋盘的重绘
        myPanel.ChessArr = mouse.ChessArr;

        //设置窗体可见
        jf.setVisible(true);

        //获取画笔对象
        Graphics g = myPanel.getGraphics();

        //添加监听器
        myPanel.addMouseListener(mouse);

        //把画笔对象传递给需要绘制图形的类里
        mouse.gr = g;

        //将修改后的对象的值传递给另一个对象
        mouse.map = myPanel;

        //ai对象
//        AI computer = new AI();
//        computer.ChessArr = newGameMouse.ChessArr;
    }

    public static void main(String[] args) {

        newGameUI showUI = new newGameUI();
        showUI.newShowUI();
    }
}
