package operation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttonlistener1 implements ActionListener {
    public JTextField jtf;

    Name name = new Name();
    calculation cal = new calculation();

    public void actionPerformed(ActionEvent e){
            String button = e.getActionCommand();

            System.out.println("button = " + button);

            if ("0".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("1".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("2".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("3".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("4".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("5".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("6".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("7".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("8".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if ("9".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }
            if (".".equals(button)) {
                jtf.setText(jtf.getText() + button);
            }

            String x1 = jtf.getText();
            double y1 = Double.parseDouble(x1);
            name.num1 = y1;

            if ("+/-".equals(button)) {
                name.num1 = -1 * name.num1;
            }
            if ("C".equals(button)) {
                name.num1 = 0;
                jtf.setText(null);
            }

            if ("➕".equals(button)) {
                name.m = '+';
                jtf.setText(null);
            }

            if ("➖".equals(button)) {
                name.m = '-';
                jtf.setText(null);
            }

            if ("✖️".equals(button)) {
                name.m = '*';
                jtf.setText(null);
            }

            if ("➗".equals(button)) {
                name.m = '/';
                jtf.setText(null);
            }

        String x2 = jtf.getText();
        double y2 = Double.parseDouble(x2);
        name.num2 = y2;

        if ("+/-".equals(button)) {
            name.num2 = -1 * name.num2;
        }
        if ("C".equals(button)) {
            name.num2 = 0;
            jtf.setText(null);
        }

            if ("=".equals(button)){
                switch (name.m){
                    case '+':
                        name.num3 = cal.addition(name.num1, name.num2);
                    break;
                    case '-':
                        name.num3 = cal.subtraction(name.num1, name.num2);
                        break;
                    case '*':
                        name.num3 = cal.multiplication(name.num1, name.num2);
                        break;
                    case '/':
                        name.num3 = cal.division(name.num1, name.num2);
                        break;
                }
                jtf.setText(String.valueOf(name.num3));
            }

    }
}

