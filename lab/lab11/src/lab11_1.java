import java.io.File;
import java.util.DoubleSummaryStatistics;
import java.util.Objects;
import java.util.Scanner;

public class lab11_1 {
    public void DocumentProcessing(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件路径：");
        String path = scanner.nextLine();

        File file = new File(path);

        if(file.isDirectory()){
            int fileCount = 0;
            int dirCount = 0;

            for (File f : Objects.requireNonNull(file.listFiles())) {
                if (f.isFile()) {
                    fileCount++;
                } else if (f.isDirectory()) {
                    dirCount++;
                }
            }

            System.out.println("文件夹数量：" + dirCount);
            System.out.println("文件数量：" + fileCount);
        } else if (file.isFile()) {
            System.out.println("文件大小：" + file.length() + " bytes");
            System.out.println("最后修改日期：" + new java.util.Date(file.lastModified()));
        } else {
            System.out.println("输入的路径不存在！");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new lab11_1().DocumentProcessing();
    }

}