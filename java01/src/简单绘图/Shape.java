package jiayu0313简单绘图;

import java.awt.*;

public class Shape {

    public int x1, y1, x2, y2;
    public int h, w;
    public String button;
    public int state;
    public Shape(int x1, int y1, int x2, int y2,int h,int w, String button,int state){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.h = h;
        this.w = w;

        this.button = button;
        this.state = state;
    }

    //根据保存的数据还原图像
    public void drawShape(Graphics g){
        switch (state) {
            case 0 -> g.setColor(Color.black);
            case 1 -> g.setColor(Color.red);
            case 2 -> g.setColor(Color.blue);
            case 3 -> g.setColor(Color.green);
            case 4 -> g.setColor(Color.yellow);
        }
        switch (button) {
            case "直线" -> g.drawLine(x1, y1, x2, y2);

//            case "矩形":{
//                g.drawRect(x1,y1,w,h);
//                g.setColor(Color.white);
//                g.fillRect(x1,y1,w,h);
//            }
//            break;
            case "三角形" -> {

            }
        }

    }

}
