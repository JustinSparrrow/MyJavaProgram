import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
    RandomAccessFile 是Java中的一个类，它允许你对存储在文件系统中的文件进行读写操作，并且可以在文件中的任意位置进行这些操作。这意味着你不需要从文件的开始一直读到需要的位置，而是可以直接跳转到文件的任意位置进行读或写操作，这就是“随机存取”的含义。
    RandomAccessFile类支持“读”和“写”操作，你可以使用它来创建新文件或者打开一个已存在的文件进行修改。在打开文件时，你需要指定一个模式，主要有两种模式：
    "r"：以只读方式打开文件。如果文件不存在，会抛出FileNotFoundException异常。
    "rw"：打开文件进行读写操作。如果文件不存在，则会创建一个新文件。
    RandomAccessFile提供了多种方法来操作文件，包括读写基本类型的数据（如int、long、byte等），读写字符串，以及跳转到文件中的特定位置（通过seek方法）。
 */

public class lab11_3 {

    public void DocumentProcessing() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件路径：");
        String path = scanner.nextLine();

        try {
            RandomAccessFile raf = new RandomAccessFile(path, "r");

            // 这里可以执行特定的读写操作，例如：
            // 移动到文件的某个位置
            raf.seek(0);
            // 读取数据
            byte[] data = new byte[64]; // 假设我们想读取64字节
            int bytesRead = raf.read(data);
            System.out.println("读取的数据：" + new String(data, 0, bytesRead));

            // 关闭RandomAccessFile
            raf.close();
        } catch (IOException e) {
            System.out.println("发生IO异常：" + e.getMessage());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new lab11_3().DocumentProcessing();
    }
}
