package roujihomework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    public JTextField user_ID;
    public JTextField user_password;
    public String name;

    public void showUI(){
        this.setTitle("Login");
        this.setSize(600,260);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Panel north_jPanel = new Panel();
        north_jPanel.setBackground(Color.lightGray);
        north_jPanel.setPreferredSize(new Dimension(0,40));
        this.add(north_jPanel,BorderLayout.NORTH);

        JPanel center_jpanel = new JPanel();
        center_jpanel.setBackground(Color.lightGray);
        this.add(center_jpanel,BorderLayout.CENTER);

        JLabel label1 = new JLabel("      ID:     ");
        JLabel label2 = new JLabel("Password:");
        JTextField jt1 = new JTextField();
        Dimension dm = new Dimension(420, 30);
        jt1.setPreferredSize(dm);
        JTextField jt2 = new JTextField();
        jt2.setPreferredSize(dm);
        JButton jbu1 = new JButton("Exist");
        Dimension x = new Dimension(80,50);
        jbu1.setPreferredSize(x);
        JButton jbu2 = new JButton("Submit");
        jbu2.setPreferredSize(x);

        jbu2.addActionListener(this);
        this.user_ID = jt1;
        this.user_password = jt2;

        center_jpanel.add(label1);
        center_jpanel.add(jt1);
        center_jpanel.add(jbu1);
        center_jpanel.add(label2);
        center_jpanel.add(jt2);
        center_jpanel.add(jbu2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String user_id = user_ID.getText();
        String user_pass = user_password.getText();

        if("1001".equals(user_id) && "12345".equals(user_pass)){
            LoginSuccessfully("wang");
        }else if ("1002".equals(user_id)&&"1245".equals(user_pass)){
            LoginSuccessfully("yang");
        }else if("1003".equals(user_id)&&"5426".equals(user_pass)){
            LoginSuccessfully("zhang");
        }else {
            LoginFailure();
        }
    }

    public void LoginSuccessfully(String name){
        JFrame login_successfully = new JFrame();
        login_successfully.setSize(300,200);
        login_successfully.setLocationRelativeTo(null);
        login_successfully.setDefaultCloseOperation(2);

        JLabel content = new JLabel("登陆成功！",JLabel.CENTER);
        JLabel con = new JLabel("Welcome! "+name,JLabel.CENTER);
        login_successfully.add(content);
        login_successfully.add(con);

        login_successfully.setVisible(true);
    }

    public void LoginFailure(){
        JFrame login_successfully = new JFrame();
        login_successfully.setSize(300,200);
        login_successfully.setLocationRelativeTo(null);
        login_successfully.setDefaultCloseOperation(2);


        JLabel content = new JLabel("登陆失败！",JLabel.CENTER);
        login_successfully.add(content);

        login_successfully.setVisible(true);
    }

    public static void main(String[] args) {
        Login ui = new Login();
        ui.showUI();
    }

}