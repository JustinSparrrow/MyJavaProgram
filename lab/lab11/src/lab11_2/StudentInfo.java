package lab11_2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class StudentInfo {
    private String ID;
    private String name;
    private String phone;
    private String email;
    private ImageIcon picture;

    public StudentInfo(String ID, String name, String phone, String email, ImageIcon picture) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.picture = picture;

        try {
            FileWriter writer = new FileWriter("student_info.txt", true);
            writer.write(this.ID + "," + this.name + "," + this.phone + "," + this.email + "\n");
            writer.close();

            BufferedImage image = new BufferedImage(picture.getIconWidth(), picture.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            picture.paintIcon(null, image.getGraphics(), 0, 0);
            ImageIO.write(image, "jpg", new File(ID + ".jpg"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageIcon getPicture() {
        return picture;
    }

    public void setPicture(ImageIcon picture) {
        this.picture = picture;
    }
}
