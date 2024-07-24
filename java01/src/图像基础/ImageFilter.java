package jiayu0520图像基础;

import java.awt.*;
import java.awt.image.BufferedImage;

//滤镜算法
public class ImageFilter {
    private Graphics gr;
    private int[][] pixelArr;
    private int count = 1;
    private BufferedImage bufferedImage;  //图像缓冲

    public ImageFilter(Graphics gr, int[][] pixelArr) {
        this.gr = gr;
        this.pixelArr = pixelArr;
    }

    public ImageFilter(Graphics gr) {
        this.gr = gr;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    //右转
    public void right(){
        int[][] pixel = null;
        if(count == 1) {
            //保存旋转后的像素值
            pixel = new int[pixelArr[0].length][pixelArr.length];
            for (int i = 0; i < pixelArr.length; i++) {
                for (int j = 0; j < pixelArr[0].length; j++) {
                    pixel[j][pixelArr.length - i - 1] = pixelArr[i][j];
                }
            }
        }
        else if(count == 2) {
            //保存旋转后的像素值
            pixel = new int[pixelArr[0].length][pixelArr.length];
            for (int i = 0; i < pixelArr.length; i++) {
                for (int j = 0; j < pixelArr[0].length; j++) {
                    pixel[j][pixelArr.length - i - 1] = pixelArr[i][j];
                }
            }
        }
        else if(count == 3) {
            //保存旋转后的像素值
            pixel = new int[pixelArr[0].length][pixelArr.length];
            for (int i = 0; i < pixelArr.length; i++) {
                for (int j = 0; j < pixelArr[0].length; j++) {
                    pixel[j][pixelArr.length - i - 1] = pixelArr[i][j];
                }
            }
            count=1;
        }
        this.pixelArr = pixel;
        count++;
        draw(pixel);
    }

    //哈哈镜
    public void filter(){
        bufferedImage = new BufferedImage(pixelArr[0].length,pixelArr.length,BufferedImage.TYPE_INT_RGB);

        //计算图片的中心点
        int h = pixelArr.length;
        int w = pixelArr[0].length;
        int cx = w/2;
        int cy = h/2;
        //确定放大的范围
        int r = 100;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                int y = (i-cy);
                int x = (j-cx);
                int dis = (int)Math.sqrt(x*x+y*y);
                if(dis < r){  //在范围了便宜像素点，越靠近中心偏移量越大
                    int nx = x*dis/r+cx;
                    int ny = y*dis/r+cy;
                    bufferedImage.setRGB(j,i,pixelArr[ny][nx]);
                }
            }
        }
        gr.drawImage(bufferedImage,50,50,null);
    }

    //把像素点画在界面上
    //程序 > jvm > os > 总线 > 屏幕
    public void draw(int[][] pixelArr) {
        //创建缓冲图片
        bufferedImage = new BufferedImage(pixelArr[0].length, pixelArr.length, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < pixelArr.length; i++) {
            for (int j = 0; j < pixelArr[0].length; j++) {
                int pixel = pixelArr[i][j];
                //设置像素值到缓冲图片上
                bufferedImage.setRGB(j, i, pixel);

            }
        }
        //把缓冲图片显示在界面上
        gr.drawImage(bufferedImage, 50, 50, null);
    }
}
