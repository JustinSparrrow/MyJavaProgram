package operation;

import javax.swing.*;
import java.awt.*;

public class operation {

    public static void main(String[] args){

        JFrame jf = new JFrame();
        jf.setSize(450,600);
        jf.setTitle("计算器");
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);

        FlowLayout flow = new FlowLayout();
        jf.setLayout(flow);

        JLabel space = new JLabel();
        Dimension dn = new Dimension(420,20);
        space.setPreferredSize(dn);
        jf.add(space);

        Dimension dm = new Dimension(420,120);
        JTextField jte = new JTextField();
        jte.setPreferredSize(dm);
        jf.add(jte);

        Dimension x = new Dimension(100,75);

        JButton jbu1 = new JButton("C");
        jbu1.setPreferredSize(x);
        jf.add(jbu1);

        JButton jbu2 = new JButton("+/-");
        jbu2.setPreferredSize(x);
        jf.add(jbu2);

        JButton jbu3 = new JButton("%");
        jbu3.setPreferredSize(x);
        jf.add(jbu3);

        JButton jbu4 = new JButton("➗");
        jbu4.setPreferredSize(x);
        jf.add(jbu4);

        JButton jbu5 = new JButton("7");
        jbu5.setPreferredSize(x);
        jf.add(jbu5);

        JButton jbu6 = new JButton("8");
        jbu6.setPreferredSize(x);
        jf.add(jbu6);

        JButton jbu7 = new JButton("9");
        jbu7.setPreferredSize(x);
        jf.add(jbu7);

        JButton jbu8 = new JButton("✖");
        jbu8.setPreferredSize(x);
        jf.add(jbu8);

        JButton jbu9 = new JButton("4");
        jbu9.setPreferredSize(x);
        jf.add(jbu9);

        JButton jbu10 = new JButton("5");
        jbu10.setPreferredSize(x);
        jf.add(jbu10);

        JButton jbu11 = new JButton("6");
        jbu11.setPreferredSize(x);
        jf.add(jbu11);

        JButton jbu12 = new JButton("➖");
        jbu12.setPreferredSize(x);
        jf.add(jbu12);

        JButton jbu13 = new JButton("1");
        jbu13.setPreferredSize(x);
        jf.add(jbu13);

        JButton jbu14 = new JButton("2");
        jbu14.setPreferredSize(x);
        jf.add(jbu14);

        JButton jbu15 = new JButton("3");
        jbu15.setPreferredSize(x);
        jf.add(jbu15);

        JButton jbu16 = new JButton("➕");
        jbu16.setPreferredSize(x);
        jf.add(jbu16);

        Dimension y = new Dimension(200,75);
        JButton jbu17 = new JButton("0");
        jbu17.setPreferredSize(y);
        jf.add(jbu17);

        JButton jbu19 = new JButton(".");
        jbu19.setPreferredSize(x);
        jf.add(jbu19);

        JButton jbu20 = new JButton("=");
        jbu20.setPreferredSize(x);
        jf.add(jbu20);

        Buttonlistener1 listener1 = new Buttonlistener1();
        listener1.jtf = jte;
        jbu1.addActionListener(listener1);
        jbu2.addActionListener(listener1);
        jbu3.addActionListener(listener1);
        jbu4.addActionListener(listener1);
        jbu5.addActionListener(listener1);
        jbu6.addActionListener(listener1);
        jbu7.addActionListener(listener1);
        jbu8.addActionListener(listener1);
        jbu9.addActionListener(listener1);
        jbu10.addActionListener(listener1);
        jbu11.addActionListener(listener1);
        jbu12.addActionListener(listener1);
        jbu13.addActionListener(listener1);
        jbu14.addActionListener(listener1);
        jbu15.addActionListener(listener1);
        jbu16.addActionListener(listener1);
        jbu17.addActionListener(listener1);
        jbu19.addActionListener(listener1);
        jbu20.addActionListener(listener1);

        /*Buttonlistener2 listener2 = new Buttonlistener2();
        listener2.jtf = jte;
        jbu2.addActionListener(listener2);
        jbu3.addActionListener(listener2);
        jbu5.addActionListener(listener2);
        jbu6.addActionListener(listener2);
        jbu7.addActionListener(listener2);
        jbu9.addActionListener(listener2);
        jbu10.addActionListener(listener2);
        jbu11.addActionListener(listener2);
        jbu13.addActionListener(listener2);
        jbu14.addActionListener(listener2);
        jbu15.addActionListener(listener2);
        jbu17.addActionListener(listener2);
        jbu19.addActionListener(listener2);
        jbu20.addActionListener(listener2);*/



        jf.setVisible(true);
    }
}
