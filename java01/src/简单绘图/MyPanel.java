package jiayu0313简单绘图;

import javax.swing.*;
import java.awt.*;

//自定义窗体，用来添加功能
public class MyPanel extends JPanel {
    public Shape[] shapeArr;

    public void paint(Graphics g){
        super.paint(g);

        //System.out.println("paint");

        for (Shape shape : shapeArr) {
            //System.out.println("shape = " + shape);
            if (shape != null) {
                shape.drawShape(g);
            } else break;
        }
    }
}
