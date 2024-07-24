package jiayu0405迭代分形;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class clickMouse implements MouseListener,ActionListener {

    public int x1,y1,x2,y2,x3,y3,px,py;
    public int state;
    public char st;
    public Graphics gr;

    Random ran = new Random();
    public void DrawLine(){
        double s1,s2,s3;
        x1 = ran.nextInt(900);
        y1 = ran.nextInt(700);
        System.out.println("A("+x1+" "+y1+")");
        x2 = ran.nextInt(900);
        y2 = ran.nextInt(700);
        System.out.println("B("+x2+" "+y2+")");
        x3 = ran.nextInt(900);
        y3 = ran.nextInt(700);
        System.out.println("C("+x3+" "+y3+")");
        s1 = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        s2 = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
        s3 = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
        System.out.println(s1+" "+s2+" "+s3);
        if((s1+s2)<=s3){
            DrawLine();
        }
        px = ran.nextInt(900);
        py = ran.nextInt(700);
    }

    public void actionPerformed(ActionEvent e){
        //System.out.println("点击！");
        gr.setColor(Color.white);
        for(int ix = 0; ix<1000;ix++) {
            state = ran.nextInt(3);
            switch (state) {
                case 0 -> st = 'A';
                case 1 -> st = 'B';
                case 2 -> st = 'C';
            }
            System.out.println(st);
            switch (st) {
                case 'A' -> {
                    px = (x1 + px) / 2;
                    py = (y1 + py) / 2;
                    gr.drawLine(px, py, px, py);
                }
                case 'B' -> {
                    px = (x2 + px) / 2;
                    py = (y2 + py) / 2;
                    gr.drawLine(px, py, px, py);
                }
                case 'C' -> {
                    px = (x3 + px) / 2;
                    py = (y3 + py) / 2;
                    gr.drawLine(px, py, px, py);
                }
            }
            System.out.println("P(" + px + "," + py + ")");
        }
    }

    public void mouseClicked(MouseEvent e){

    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){
        gr.setColor(Color.white);
        gr.drawLine(x1,y1,x2,y2);
        gr.drawLine(x1,y1,x3,y3);
        gr.drawLine(x2,y2,x3,y3);
    }
    public void mouseExited(MouseEvent e){

    }
}
