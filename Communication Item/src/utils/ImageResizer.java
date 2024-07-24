package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageResizer {

    public static void resizeImage(File inputImageFile, File outputImageFile, int scaledWidth, int scaledHeight) throws IOException {
        // 读取输入图片
        BufferedImage inputImage = ImageIO.read(inputImageFile);

        // 创建输出图片
        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

        // 绘制缩放后的图片
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // 从输入文件中获取扩展名
        String formatName = outputImageFile.getName().substring(outputImageFile.getName().lastIndexOf(".") + 1);

        // 写入输出文件
        ImageIO.write(outputImage, formatName, outputImageFile);
    }

    public static void main(String[] args) {
        File inputImageFile = new File("assets/logo.png");
        File outputImageFile = new File("assets/resized_logo.png");
        int scaledWidth = 100; // 缩放后的宽度
        int scaledHeight = 100; // 缩放后的高度

        try {
            resizeImage(inputImageFile, outputImageFile, scaledWidth, scaledHeight);
            System.out.println("Image resized successfully.");
        } catch (IOException e) {
            System.err.println("Error resizing image: " + e.getMessage());
        }
    }
}
