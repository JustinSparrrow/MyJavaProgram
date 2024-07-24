import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class In_Out {
    //打开输入流
    Scanner scanner = new Scanner(System.in);

    //使用标准scanner类进行输入
    public void function_1(){
        System.out.println("------Function_one------");
        System.out.println("读取字符串");
        //输入
        //检测是否有输入
        while (scanner.hasNextLine()){
            String str1 = scanner.nextLine();
            if(str1.isEmpty()){
                break;
            }
            //输出
            System.out.println(str1);
        }

        System.out.println("读取字符");
        while (scanner.hasNext()){
            String str2 = scanner.next();
            if (str2.equals("\\")){
                break;
            }
            System.out.println(str2);
        }
    }

    //使用System.in.read()方法
    public void function_2(){
        System.out.println("------Function_two------");
        int c;
        try {
            while ((c = System.in.read()) != -1){
                System.out.println((char) c);
                if((char) c == 'q')
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Console方法
    public void Function_3(){
        System.out.println("------Function_three------");
        Console console = System.console();
        if(console == null){
            System.out.println("没有控制台");
            return;
        }
        String str3;
        while ((str3 = console.readLine()) != null){
            System.out.println(str3);
            if (str3.isEmpty())
                break;
        }
    }

    //BufferReader
    public void function_4(){
        System.out.println("------function_four------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("请输入内容：");
            while(true){
                String s = reader.readLine();
                String m = reader.readLine();
                System.out.println(s+m);

                break;
            }

            // 此处关闭BufferedReader对象
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        In_Out lab1 = new In_Out();
        lab1.function_1();
        lab1.function_2();
        lab1.Function_3();
        lab1.function_4();
        lab1.scanner.close();   //关闭输入流对象
    }
}
