package jiayu0303登陆界面;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttonlistener implements ActionListener {

    public JTextField user_ID;
    public JTextField user_password;

    public void actionPerformed(ActionEvent e) {

        String user_id = user_ID.getText();
        String user_pass = user_password.getText();

        if("2518835772".equals(user_id) && "123456".equals(user_pass)){
            JFrame login_successfully = new JFrame();
            login_successfully.setSize(300,200);
            login_successfully.setTitle("登陆成功!");
            login_successfully.setLocationRelativeTo(null);
            login_successfully.setDefaultCloseOperation(2);

            JLabel content = new JLabel("登陆成功！",JLabel.CENTER);
            login_successfully.add(content);

            login_successfully.setVisible(true);
        }
        else{
            JFrame login_successfully = new JFrame();
            login_successfully.setSize(300,200);
            login_successfully.setTitle("登陆失败!");
            login_successfully.setLocationRelativeTo(null);
            login_successfully.setDefaultCloseOperation(2);


            JLabel content = new JLabel("登陆失败！",JLabel.CENTER);
            login_successfully.add(content);

            login_successfully.setVisible(true);
        }
    }

}
