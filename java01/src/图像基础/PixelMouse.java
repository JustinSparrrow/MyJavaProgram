package jiayu0520图像基础;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

//事件处理类
public class PixelMouse  implements ActionListener {

    private Graphics gr; //画笔对象
    private int[][] pixelArr;  //保存图片像素值的二维数组
    ImageFilter imageFilter2;

    public PixelMouse() {
        readImage("/Users/moqi/Downloads/helloworld.png");
    }

    public void setGr(Graphics gr) {
        this.gr = gr;
    }

    //还原图像效果
    //马赛克、灰度
    //程序的执行过程：程序>加载进内存（jvm）> os > 总线 > 显卡 > 显示器

    //通过IO流读取图片数据（像素点）
    public int[][] getImagePixel(File file) {
        BufferedImage bufferedImage = null;
        try {
            //读取图片数据
            bufferedImage = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        int[][] pixelArr = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //获取图片的每个像素值
                int pixel = bufferedImage.getRGB(j, i);
                pixelArr[i][j] = pixel;
            }
        }
        return pixelArr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str) {
            case "原图":
                ImageFilter imageFilter = new ImageFilter(gr);
                imageFilter.draw(pixelArr);
                break;
            case "向右翻转":
                if (imageFilter2 == null) {
                    imageFilter2 = new ImageFilter(gr);
                }
                imageFilter2.right();
                break;
            case "打开":
                //文件选择器
                JFileChooser jFileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif");
                jFileChooser.setFileFilter(filter);
                int returnVal = jFileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    System.out.println("file = " + jFileChooser.getSelectedFile());
                    readImage(jFileChooser.getSelectedFile().getPath());
                }
                break;
            case "哈哈镜":
                ImageFilter  imageFilter3 = new ImageFilter(gr,pixelArr);
                imageFilter3.filter();
                break;
        }
    }

    public void stateChanged(ChangeEvent e){
        //获取当前事件源对象 e.getSource();


        //取出最后一个图层
    }


    public void readImage(String path) {
        File file = new File(path);
        pixelArr = getImagePixel(file);
    }
}

    //把像素点画在界面上
    //程序 > jvm > os > 总线 > 屏幕


