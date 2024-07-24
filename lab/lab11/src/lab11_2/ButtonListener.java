package lab11_2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class ButtonListener implements ActionListener {
    private ArrayList<StudentInfo> studentInfos = new ArrayList<>();
    int number = 0;
    JPanel jPanel;
    JPanel bottom;
    Graphics g;
    public ButtonListener(JPanel jPanel, JPanel bottom, Graphics g) {
        this.jPanel = jPanel;
        this.bottom = bottom;
        this.g = g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selection = e.getActionCommand();
        System.out.println(selection);
        switch (selection){
            case "新增" -> addInformation();
            case "删除" -> deleteInformation();
            case "修改" -> changeInformation();
            case "查询" -> inquireInformation();
            case "显示" -> displayInformation();
        }
    }

    public void addInformation(){
        JFrame jf = new JFrame("新增学生信息");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(2);
        jf.setLocationRelativeTo(null);

        // 设置BoxLayout为垂直布局
        jf.setLayout(new BoxLayout(jf.getContentPane(), BoxLayout.Y_AXIS));

        JLabel imageLabel = new JLabel();  // 图片显示区域
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.GRAY);  // 在没有图片选择之前，显示区域为灰色

        final ImageIcon[] imageIcon = new ImageIcon[1];

        JButton selectImageButton = new JButton("选择学生头像");
        selectImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();

                // 设置文件过滤器，只显示 .jpg 文件
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
                chooser.setFileFilter(filter);

                int returnValue = chooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();
                    imageIcon[0] = new ImageIcon(new ImageIcon(selectedFile.getPath()).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                    imageLabel.setIcon(imageIcon[0]);
                }
            }
        });

        jf.add(selectImageButton);
        jf.add(imageLabel);

        String[] array = {"请输入学号：","请输入姓名：","请输入电话：","请输入邮箱："};
        JPanel[] jPanels = new JPanel[4];
        TextField[] textField = new TextField[4];

        for(int i = 0; i < 4; i++){
            // 创建新的 JPanel 和 TextField 实例
            jPanels[i] = new JPanel();
            textField[i] = new TextField();

            JLabel jLabel = new JLabel(array[i]);
            textField[i].setPreferredSize(new Dimension(150, 30));
            jPanels[i].add(jLabel);
            jPanels[i].add(textField[i]);

            jf.add(jPanels[i]);
        }

        JButton addInfo = new JButton("确认");
        addInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = textField[0].getText();
                String name = textField[1].getText();
                String phone = textField[2].getText();
                String email = textField[3].getText();

                int n = verify(ID, name, phone, email);

                switch (n){
                    case 0:
                        JOptionPane.showMessageDialog(null, "输入不能为空！", "新增失败！", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "ID不合法！", "新增失败！", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "姓名不合法！", "新增失败！", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "电话号码不合法！", "新增失败！", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "邮箱地址不合法！", "新增失败！", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 1:
                        boolean alreadyExists = false;
                        for (StudentInfo existingStudent : studentInfos) {
                            if (existingStudent.getID().equals(ID)) {
                                alreadyExists = true;
                                JOptionPane.showMessageDialog(null, "已有该学生信息", "新增失败！", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                        }
                        if (!alreadyExists) {
                            StudentInfo studentInfo = new StudentInfo(ID, name, phone, email, imageIcon[0]);
                            studentInfos.add(studentInfo);
                        }
                        break;
                }
            }
        });
        jf.add(addInfo);

        jf.setVisible(true);
    }

    private int verify(String ID, String name, String phone, String email){
        if(ID.isEmpty() ||name.isEmpty() || phone.isEmpty() || email.isEmpty()){
            return 0;
        } else {
            // 验证ID，14位数字
            boolean isIDValid = ID.matches("\\d{14}");
            // 验证名字，可以是英文也可以是中文
            boolean isNameValid = name.matches("^[a-zA-Z\\u4e00-\\u9fa5]+$");
            // 验证电话号码，11位数字
            boolean isPhoneValid = phone.matches("\\d{11}");
            // 验证电子邮件，需要有@和.
            boolean isEmailValid = email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");

            if(!isIDValid) {
                return 2;
            } else if(!isNameValid) {
                return 3;
            } else if(!isPhoneValid) {
                return 4;
            } else if(!isEmailValid) {
                return 5;
            }
        }
        return 1;
    }

    public void deleteInformation(){
        if(!studentInfos.isEmpty()){
            int result = JOptionPane.showConfirmDialog(null, "是否要删除当前学生信息？", "删除信息", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION) {
                studentInfos.remove(number);
                displayInformation();
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "目前无学生信息！", "", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void changeInformation(){
        deleteInformation();
        addInformation();
        updateStudentInfo(studentInfos.get(studentInfos.size()-1).getID(),
                studentInfos.get(studentInfos.size()-1).getName(),
                studentInfos.get(studentInfos.size()-1).getPhone(),
                studentInfos.get(studentInfos.size()-1).getEmail(),
                studentInfos.get(studentInfos.size()-1).getPicture());
    }

    public void updateStudentInfo(String ID, String newName, String newPhone, String newEmail, ImageIcon newPicture) {
        try {
            File inputFile = new File("student_info.txt");
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if(data[0].equals(ID)) {
                    // 如果找到了需要更新的学生信息，用新的信息覆盖这一行
                    currentLine = ID + "," + newName + "," + newPhone + "," + newEmail;
                }
                writer.write(currentLine + "\n");
            }
            writer.close();
            reader.close();

            // 删除原文件，并将临时文件重命名为原文件
            if (!inputFile.delete()) {
                System.out.println("Could not delete original file");
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename temp file");
            }

            // 更新对应的jpg文件
            BufferedImage image = new BufferedImage(newPicture.getIconWidth(), newPicture.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            newPicture.paintIcon(null, image.getGraphics(), 0, 0);
            ImageIO.write(image, "jpg", new File(ID + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inquireInformation(){
        String input = JOptionPane.showInputDialog(null, "请输入查找学生姓名：", "查找", JOptionPane.PLAIN_MESSAGE);
        ArrayList<StudentInfo> infos = new ArrayList<>();
        for (StudentInfo studentInfo : studentInfos) {
            if (studentInfo.getName().equals(input)) {
                infos.add(studentInfo);
            }
        }

        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        JPanel jPanel1 = new JPanel();
        jPanel1.setBackground(Color.lightGray);

        JButton button1 = new JButton("上一页");
        JButton button2 = new JButton("下一页");
        jPanel1.add(button1);
        JLabel jLabel = new JLabel("第"+(number +1)+"位同学信息");
        jPanel1.add(jLabel);
        jPanel1.add(button2);

        bottom.add(jPanel1);
        // 重新绘制界面
        bottom.revalidate();
        bottom.repaint();

        if(!infos.isEmpty()) {
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

            JLabel imageLabel = new JLabel();  // 图片显示区域
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.GRAY);  // 在没有图片选择之前，显示区域为灰色
            imageLabel.setIcon(infos.get(number).getPicture());
            JLabel ID = new JLabel(infos.get(number).getID());
            JLabel name = new JLabel(infos.get(number).getName());
            JLabel phone = new JLabel(infos.get(number).getPhone());
            JLabel email = new JLabel(infos.get(number).getEmail());
            jPanel.add(imageLabel);
            jPanel.add(ID);
            jPanel.add(name);
            jPanel.add(phone);
            jPanel.add(email);
            jPanel.revalidate();
            jPanel.repaint();
        } else {
            JLabel jLabel1 = new JLabel("无学生信息");
            jLabel1.setLocation(jPanel.getWidth()/2, jPanel.getHeight()/2);
            jPanel.add(jLabel1);
            JOptionPane.showMessageDialog(null, "目前无学生信息", "", JOptionPane.INFORMATION_MESSAGE);

        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(number == 0){
                    JOptionPane.showMessageDialog(null, "达到上届！", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    number--;
                    inquireInformation();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number == studentInfos.size()-1){
                    JOptionPane.showMessageDialog(null, "达到下届！", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    number++;
                    inquireInformation();
                }
            }
        });
    }

    public void displayInformation(){
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        JPanel jPanel1 = new JPanel();
        jPanel1.setBackground(Color.lightGray);

        JButton button1 = new JButton("上一页");
        JButton button2 = new JButton("下一页");
        jPanel1.add(button1);
        JLabel jLabel = new JLabel("第"+(number +1)+"位同学信息");
        jPanel1.add(jLabel);
        jPanel1.add(button2);

        bottom.add(jPanel1);


        jPanel.removeAll();

        if(!studentInfos.isEmpty()) {
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

            JLabel imageLabel = new JLabel();  // 图片显示区域
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.GRAY);  // 在没有图片选择之前，显示区域为灰色
            imageLabel.setIcon(studentInfos.get(number).getPicture());
            JLabel ID = new JLabel(studentInfos.get(number).getID());
            JLabel name = new JLabel(studentInfos.get(number).getName());
            JLabel phone = new JLabel(studentInfos.get(number).getPhone());
            JLabel email = new JLabel(studentInfos.get(number).getEmail());
            jPanel.add(imageLabel);
            jPanel.add(ID);
            jPanel.add(name);
            jPanel.add(phone);
            jPanel.add(email);
        } else {
            JLabel jLabel1 = new JLabel("无学生信息");
            jLabel1.setLocation(jPanel.getWidth()/2, jPanel.getHeight()/2);
            jPanel.add(jLabel1);
            JOptionPane.showMessageDialog(null, "目前无学生信息", "", JOptionPane.INFORMATION_MESSAGE);

        }

        // 重新绘制界面
        bottom.revalidate();
        bottom.repaint();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(number == 0){
                    JOptionPane.showMessageDialog(null, "达到上届！", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    number--;
                    displayInformation();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (number == studentInfos.size()-1){
                    JOptionPane.showMessageDialog(null, "达到下届！", "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    number++;
                    displayInformation();
                }
            }
        });
    }

    public ArrayList<StudentInfo> getStudentInfos() {
        return studentInfos;
    }

    public void setStudentInfos(ArrayList<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
    }
}
