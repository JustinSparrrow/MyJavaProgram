package lab3_1;

import java.util.Scanner;

public class Main {

    void isPrime(int x){
        int count = 0;
        int number = 1;
        for(int i = 2; i <= x; i++){
            boolean flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                count++;
                //test
//                System.out.println("i:"+i+" j:"+j+" i%j="+i%j);
                //end
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.print(i+"\t");
                if(number % 10 == 0){
                    System.out.println();
                }
                number++;
            }
        }
        System.out.println();
        number -= 1;
        System.out.println("素数个数："+number);
        System.out.println("测试次数："+count);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入界限：");
        int number = scanner.nextInt();
        main.isPrime(number);
        System.out.println();
    }
}