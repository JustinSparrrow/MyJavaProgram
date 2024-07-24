package jiayu0507科赫曲线;

import javax.swing.plaf.IconUIResource;
import java.awt.*;

public class Picture {

    public void draw1(Graphics g, int x1, int y1, int x2, int y2, int depth){
        g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);
        if(depth <= 1)
            return;
        else {
            double x11 = (x1*2+x2)/3;
            double y11 = (y1*2+y2)/3;

        }
    }

    public static void main(String[] args){
    }
}
