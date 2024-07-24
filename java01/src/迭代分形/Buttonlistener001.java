package jiayu0304迭代分形;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class Buttonlistener001 implements ActionListener , MouseListener {

    Graphics gr;

    public double x = 0, y = 0;
    public double a, b, c, d;
    public String button;

    public JTextField number;

    Scanner scanner = new Scanner(System.in);
    public void number(){
        System.out.println("请输入a，b，c，d的值：");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        d = scanner.nextDouble();
        System.out.println("a:"+a+" b:"+b+" c:"+c+" d:"+d);
    }

    public void actionPerformed(ActionEvent e){


        button = e.getActionCommand();
        //System.out.println("点击");
        gr.setColor(Color.white);
        if("迭代1".equals(button)){
        for(int ix = 0; ix < 100000; ix++) {
            x = Math.sin(a * y) - Math.cos(b * x);
            y = Math.sin(c * x) - Math.cos(d * y);
            int m = (int) ((x * 100) + 330);
            int n = (int) ((y * 100) + 350);
            gr.drawLine(m, n, m, n);
        }
        }
        else {
            for(int ix = 0; ix < 100000; ix++){
                x = d*Math.sin(a*x)-Math.sin(b*y);
                y = c*Math.cos(a*x)+Math.cos(b*y);
                int m = (int)(d*Math.sin(a*x) - Math.sin(b*y)*100+330);
                int n = (int)(c*Math.cos(a*x) + Math.cos(b*y)*100+350);
                gr.setColor(new Color(250,ix%255,ix%255));
                gr.drawLine(m,n,m,n);
            }
        }
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }
}
