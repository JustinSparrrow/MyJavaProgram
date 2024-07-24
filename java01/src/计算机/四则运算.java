package 计算机;

import java.util.Scanner;

public class 四则运算 {
    public int a;
    public int b;
    public int c;
    public int count;
    public char x;

    int judgment()
    {
        System.out.println("What operation do you want to do?");
        System.out.println("Please enter an operation symbol:");
        Scanner scanner = new Scanner(System.in);
        x = scanner.next().charAt(0);
        switch (x)
        {
            case '+':return count = 1;
            case '-':return count = 2;
            case '*':return count = 3;
            case '/':return count = 4;
            default:return 0;
        }
    }

    void addition(int a,int b)
    {
        c = a+b;
        System.out.println(c);
    }
    void subtraction(int a,int b)
    {
        c = a-b;
        System.out.println(c);
    }
    void multiplication(int a,int b)
    {
        c = a*b;
        System.out.println(c);
    }
    void division(int a,int b) {
        if (b == 0)
            System.out.println("Error!");
        else {
            c = a / b;
            System.out.println("约数为" + c);
            c = a % b;
            System.out.println("余数为" + c);
        }
    }
}
