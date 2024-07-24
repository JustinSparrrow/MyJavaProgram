package wodesaolei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.time.OffsetDateTime;

public class GameWin extends JFrame//具有监听鼠标键盘事件的功能
{
    //方法
    //窗体设置
    int wigth = 2 * GameUtil.OFFSET + GameUtil.MAP_W * GameUtil.SQUARE_LENGTH;
    int height = 4 * GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH;

    Image offScreenImage = null;

    MapBottom mapButton = new MapBottom();
    MapTop mapTop = new MapTop();
    GameSelect gameSelect = new GameSelect();
    boolean begin = false;

    void launch() {
        GameUtil.START_TIME = System.currentTimeMillis();
        this.setVisible(true); //方法是否可见
        if(GameUtil.state == 3){
            this.setSize(500,500);
        }
        else{
            this.setSize(wigth,height);
        }
        this.setLocationRelativeTo(null); //窗体位置
        this.setTitle("扫雷"); //命名
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //能关闭

        //鼠标事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (GameUtil.state){
                    case 0:
                        if(e.getButton() == 1){
                            GameUtil.MOUSE_X = e.getX();
                            GameUtil.MOUSE_Y = e.getY();
                            GameUtil.LEFT = true;
                        }
                        if(e.getButton() == 3){
                            GameUtil.MOUSE_X = e.getX();
                            GameUtil.MOUSE_Y = e.getY();
                            GameUtil.RIGHT = true;
                        }
                    case 1:

                    case 2:
                        if(e.getButton() == 1){
                            if(e.getX() > GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2)&&
                            e.getX() < GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2) + GameUtil.SQUARE_LENGTH
                            && e.getY() > GameUtil.OFFSET
                            && e.getY() < GameUtil.OFFSET + GameUtil.SQUARE_LENGTH){
                                mapButton.reGame();
                                mapTop.reGame();
                                GameUtil.FLAG_NUM = 0;
                                GameUtil.START_TIME = System.currentTimeMillis();
                                GameUtil.state = 0;
                            }
                        }
                        if(e.getButton() == 2){
                            GameUtil.state = 3;
                            begin = true;
                        }
                        break;
                    case 3:
                        if(e.getButton() == 1){
                            GameUtil.MOUSE_X = e.getX();
                            GameUtil.MOUSE_Y = e.getY();
                            begin = gameSelect.hard();
                        }

                    default:
                }
            }
        });

        while (true) {
            repaint();
            begin();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void begin(){
        if(begin){
            begin = false;
            gameSelect.hard(GameUtil.level);
            dispose();
            GameWin gameWin = new GameWin();
            GameUtil.START_TIME = System.currentTimeMillis();
            GameUtil.FLAG_NUM = 0;
            mapButton.reGame();
            mapTop.reGame();
            gameWin.launch();
        }
    }

    //组件一，网格线
    public void paint(Graphics g) //Graphics为画笔
    {
        if(GameUtil.state == 3){
            g.setColor(Color.white);
            g.fillRect(0,0,500,500);
            gameSelect.paintSelf(g);
        }
        else {
            offScreenImage = this.createImage(wigth, height);
            Graphics gImage = offScreenImage.getGraphics();
            gImage.setColor(Color.white);
            gImage.fillRect(0, 0, wigth, height);
            mapButton.paintSelf(gImage);
            mapTop.paintSelf(gImage);
            g.drawImage(offScreenImage, 0, 0, null);
        }
    }

    public static void main(String[] args){
        GameWin gamewin = new GameWin();
        gamewin.launch();
    }
}
