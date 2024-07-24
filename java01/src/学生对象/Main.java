package jiayu0228学生对象;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Student rouji = new Student();
        rouji.name = "肉鸡";
        rouji.score_A = 80;
        rouji.score_B = 75;
        //特征的描述
        rouji.ID();

        Student jiayu = new Student();
        jiayu.name = "麻子";
        jiayu.score_A = 80;
        jiayu.score_B = 75;

        System.out.println("The student has down well?(1/0)");
        Scanner in = new Scanner(System.in); //使用Scanner类定义对象
        int a = in.nextInt(); //接收整形数据
        int b = in.nextInt();

        if(b == 1)
            jiayu.study(2,5);
        else
            jiayu.lose(2,5);

        if(a==1)
            rouji.study(2,5);
        else
            rouji.lose(2,5);
    }
}