package 计算机;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        四则运算 ab = new 四则运算();
        ab.a = 0;
        ab.b = 0;
        ab.c = 0;
        ab.count = 0;
        boolean condition = true;
        char m ;

        for (; condition; )
        {
            System.out.println("Please enter the first number:");
            Scanner in = new Scanner(System.in);
            ab.a = in.nextInt();
            System.out.println("Please enter the second number:");
            ab.b = in.nextInt();

            ab.judgment();

            switch (ab.count) {
                case 1:
                    ab.addition(ab.a, ab.b);
                    break;
                case 2:
                    ab.subtraction(ab.a, ab.b);
                    break;
                case 3:
                    ab.multiplication(ab.a, ab.b);
                    break;
                case 4:
                    ab.division(ab.a, ab.b);
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }

            System.out.println("Do you want to try again?(Y/N)");
            Scanner scanner = new Scanner(System.in);
            m = scanner.next().charAt(0);
            if(m == 'N' || m == 'n')
            {
                condition = false;
                System.out.println("Thanks for using!");
            }
        }
    }
}
