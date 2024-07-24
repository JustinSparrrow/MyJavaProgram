package jiayu0313简单绘图;

import java.awt.*;
import java.awt.event.*;

//事件处理类
//继承接口一定要重写接口中所有的抽象方法
public  class DrawMouse implements MouseListener, ActionListener, MouseMotionListener {


    public Graphics gr;
    public int x1,y1,x2,y2,x3,y3,x4,y4,h,w;
    public Shape[] shapeArr = new Shape[10000];
    public int index = 0;

    public boolean flag = true;
    String button = "✏️";
    String color = "黑";
    int state = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        color = e.getActionCommand(); //不与类型冲突，重新给颜色建立一个新的名字

        if("红".equals(color)) {
            gr.setColor(Color.red);
            state = 1;
        }
        else if("蓝".equals(color)) {
            gr.setColor(Color.blue);
            state = 2;
        }
        else if("绿".equals(color)){
            gr.setColor(Color.green);
            //gr.setFont(new Font("仿宋",Font.BOLD,10));
            state = 3;
        }
        else if("黄".equals(color)){
            gr.setColor(Color.yellow);
            state = 4;
        }
        else {
            //获取按钮上内容
            button =  e.getActionCommand();
        }
    }


    public void mouseClicked(MouseEvent e) {
        System.out.println("点击!");

        x3 = e.getX();
        y3 = e.getY();

        if("三角形".equals(button)) {
            gr.drawLine(x3, y3, x1, y1);
            gr.drawLine(x3, y3, x2, y2);
            flag = true;
        }

        if("多边形".equals(button)){
            gr.drawLine(x2,y2,x3,y3);
            x2 = x3;
            y2 = y3;
            if(e.getClickCount() == 2){
                gr.drawLine(x1,y1,x3,y3);
                flag = true;
            }
        }
    }
    public void mousePressed(MouseEvent e) {
        System.out.println("按压");
        //获取当前坐标值
        if (flag) {
            x1 = e.getX();
            y1 = e.getY();
            System.out.println("坐标一： "+x1 + " " + y1);
        }
    }
    public void mouseReleased(MouseEvent e) {
        System.out.println("释放!");
        if (flag) {
            x2 = e.getX();
            y2 = e.getY();
            System.out.println("坐标二： "+x2 + " " + y2);

            //绘制图形
            if ("圆".equals(button)) {
                int r = Math.abs(x2 - x1);
                if (x2 > x1 && y2 > y1)
                    gr.drawOval(x1, y1, r, r);
                if (x2 > x1 && y2 < y1)
                    gr.drawOval(x1, y2, r, r);
                if (x2 < x1 && y2 > y1)
                    gr.drawOval(x2, y1, r, r);
                if (x2 < x1 && y2 < y1)
                    gr.drawOval(x2, y2, r, r);
            }
            if ("三角形".equals(button)) {
                gr.drawLine(x1,y1,x2,y2);
                flag = false;
            }
            if("多边形".equals(button)){
                gr.drawLine(x1,y1,x2,y2);
                flag = false;
            }
        }

        //重绘图形
        Shape shape = new Shape(x1, y1, x2, y2,w,h,button,state);
        //保存到数组中
        shapeArr[index++]=shape;
    }
    public void mouseDragged(MouseEvent e) {
        //System.out.println("拖动");
        if ("直线".equals(button)) {
            gr.setColor(Color.white);
            gr.drawLine(x1, y1, x4, y4);
            x4 = e.getX();
            y4 = e.getY();
            switch (state) {
                case 1 -> gr.setColor(Color.red);
                case 2 -> gr.setColor(Color.blue);
                case 3 -> gr.setColor(Color.green);
                case 4 -> gr.setColor(Color.yellow);
                default -> gr.setColor(Color.black);
            }
            gr.drawLine(x1, y1, x4, y4);

        }


        if ("✏️".equals(button)) {
            x4 = e.getX();
            y4 = e.getY();
            gr.drawLine(x1, y1, x4, y4);
            x1 = x4;
            y1 = y4;
        }

        if ("矩形".equals(button)) {
            w = Math.abs(x4 - x1);
            h = Math.abs(y4 - y1);

            gr.setColor(Color.white);
            gr.drawRect(Math.min(x1,x4),Math.min(y1,y4),w,h);
            x4 = e.getX();
            y4 = e.getY();
            switch (state) {
                case 1 -> gr.setColor(Color.red);
                case 2 -> gr.setColor(Color.blue);
                case 3 -> gr.setColor(Color.green);
                case 4 -> gr.setColor(Color.yellow);
                default -> gr.setColor(Color.black);
            }

            gr.drawRect(Math.min(x1,x4),Math.min(y1,y4),w,h);
        }

        if ("橡皮".equals(button)) {
            x4 = e.getX();
            y4 = e.getY();
            gr.setColor(Color.white);
            //gr.setFont(Font.getFont(0.2f));
            gr.drawLine(x1, y1, x4, y4);
            x1 = x4;
            y1 = y4;
        }

    }

    public void mouseMoved(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }



}
