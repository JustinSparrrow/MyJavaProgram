package wodesaolei;

import java.awt.*;

/*
* 工具类
* 存放静态参数
* 工具方法
*/
public class GameUtil {
    static int RAY_MAX = 100; //定义地雷的个数
    static int MAP_W = 36; //地图的宽
    static int MAP_H = 17; //地图的高
    static int OFFSET = 45; //雷区的偏移量
    static int SQUARE_LENGTH = 50; //格子边长

    static int FLAG_NUM = 0;  //旗子的数量

    //鼠标相关参数
    static int MOUSE_X;  //鼠标点击位置的横坐标
    static int MOUSE_Y;  //鼠标点击位置的纵坐标
    static boolean LEFT = false;
    static boolean RIGHT = false;

    static long START_TIME;  //开始游戏的时间
    static long END_TIME;  //结束游戏的时间

    //游戏状态   初始状态为0  胜利为1  失败为2  难度选择为3
    static int state = 3;

    static int level;


    //底层元素  -1代表雷  0代表空   1-8代表对应数字
    static int[][] DATA_BOTTOM = new int[MAP_W + 2][MAP_H + 2];

    //顶层元素  -1代表无覆盖 0表示有覆盖 1代表插旗 2代表插错旗
    static int[][] DATA_TOP = new int[MAP_W + 2][MAP_H + 2];

    //载入图片
    static Image lei = Toolkit.getDefaultToolkit().getImage("image/lei.JPEG");

    static Image top = Toolkit.getDefaultToolkit().getImage("image/top.JPEG");
    static Image flag = Toolkit.getDefaultToolkit().getImage("image/flag.JPEG");
    static Image noflag = Toolkit.getDefaultToolkit().getImage("image/noflag.JPEG");

    static Image face = Toolkit.getDefaultToolkit().getImage("image/face.JPEG");
    static Image win = Toolkit.getDefaultToolkit().getImage("image/win.JPEG");
    static Image lose = Toolkit.getDefaultToolkit().getImage("image/lose.JPEG");

    static Image[] images = new Image[9];
    static {
        for (int i = 0; i <= 8; i++){
            images[i] = Toolkit.getDefaultToolkit().getImage("image/"+i+".JPEG");
        }
    }

    static void drawWord(Graphics g,String str, int x,int y,int size,Color color){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}
