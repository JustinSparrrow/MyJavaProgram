package lab3_2;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;
import java.util.Random;

public class Circle extends Canvas {

    public void paint(Graphics g) {
        for(int i = 0; i < 10; i++) {
            int x = new SecureRandom().nextInt(300);
            int y = new SecureRandom().nextInt(300);
            int r = new SecureRandom().nextInt(200);

            Random random = new Random();

            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            Color randomColor = new Color(red, green, blue);

            g.setColor(randomColor);

            g.fillOval(x, y, r, r);
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        Circle circle = new Circle();
        circle.setSize(450, 450);
        jFrame.add(circle);
        jFrame.pack();      //根据组件大小调整窗体大小
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);

        jFrame.setVisible(true);
    }
}
