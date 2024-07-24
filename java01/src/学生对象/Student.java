package jiayu0228学生对象;

import java.util.Scanner;

public class Student {
    //public 访问修饰符
    //对象是student
    public String name;
    public char sex;
    public int ID;
    public int score_A;
    public int score_B;
    //对象属性列举
    public void ID()
    {
        System.out.println("What's your ID?");
        Scanner in = new Scanner(System.in);
        ID = in.nextInt();
        System.out.println(ID);
    }
    public void study(int sco_1,int sco_2)
    {
        score_A += sco_1;
        score_B += sco_2;
        System.out.println(name+"正在学习,A科目成绩增加了"+sco_1+"分，现在的学分"+score_A);
        System.out.println(name+"正在学习,B科目成绩增加了"+sco_2+"分，现在的学分"+score_B);
    }
    public void lose(int sco_1,int sco_2)
    {
        score_A -= sco_1;
        score_B -= sco_2;
        System.out.println(name+"上课睡觉,A科目成绩扣除"+sco_1+"分，现在的学分"+score_A);
        System.out.println(name+"上课睡觉,B科目成绩扣除"+sco_2+"分，现在的学分"+score_B);
    }
}
